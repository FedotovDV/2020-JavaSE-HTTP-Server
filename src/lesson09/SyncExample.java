package lesson09;

import java.util.*;
import java.util.concurrent.TimeUnit;

public  class SyncExample {
	private List<String> list = new LinkedList<>();
	private int count = 0;

	public void addString(String s) {
		synchronized(this){ count++;
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.add(s);
	}
	}

	public synchronized String getString() {
		if (count > 0) {
			count--;
			return list.remove(0);
		} else {
			return null;
		}
	}
}