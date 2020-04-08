package lesson09;

import java.util.concurrent.*;

public class ExecutorServiceRun {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Callable<String> task = () ->{
			Thread.sleep(3000);
			return Thread.currentThread().getName();
		};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			Future<String> result = service.submit(task);
			System.out.println(result.get());
		}
		service.shutdown();
	}
}