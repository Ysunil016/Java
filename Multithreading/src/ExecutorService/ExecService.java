package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecService {

	public static void main(String[] args) {

		// Executor Maintains the Tasking in RoundRobin Fashion Based on Cores Available
		// It Utilises Each Core Respectively.
		int availableCores = Runtime.getRuntime().availableProcessors();
	
		System.out.println(availableCores);

		// Making Our Threads Scheduled Based on Available Cores.
		ExecutorService exec = Executors.newScheduledThreadPool(availableCores);

		for (int i = 0; i < 10; i++) {
			exec.execute(new threadTask());
		}

	}

	static class threadTask implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 1000000; i++) {
				System.out.println(Thread.currentThread().getId() + " " + i);
			}
		}

	}

}
