package lesson09;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
	static final ThreadLocal<String> name = new ThreadLocal<>();
	public static void main(String[] args) {
		/* if  used
		 * final SimpleVar<String> name = new SimpleVar<>(); 
		 * Console:
		 * Thread-2 
		 * Thread-2 
		 * Thread-2
		 */
		
		
		/* if used
		 * final ThreadLocal<String> name = new ThreadLocal<>(); 
		 * Console:
		 * Thread-1
		 * Thread-0
		 * Thread-2
		 */
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
//					name.set(Thread.currentThread().getName());
					function1();
					try {
						TimeUnit.MILLISECONDS.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//					System.out.println(name.get());
					function2();
				}
			}).start();
		}
	}

	static void function1() {
		name.set(Thread.currentThread().getName());
	}
	static void function2() {
		System.out.println(name.get());
	}
	
	
	static class SimpleVar<T> {
		T value;

		public synchronized T get() {
			return value;
		}

		public synchronized void set(T value) {
			this.value = value;
		}
	}
}