
public class Main {

	public static void main(String[] args) {

		System.out.println("Balance\tTimestamp");

		Runnable myRunnable = new Runnable() {
			double balance = 100; // Initial balance

			public synchronized void run() {
				for (int i = 0; i < 5; ++i) {
					// Emulates balance change
					if (Math.random() < 0.5) {
						balance = balance + 100;
					}

					long timestamp = System.currentTimeMillis();

					System.out.println(balance + "\t" + timestamp); // Emulates response sending

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		};

		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);
		Thread thread3 = new Thread(myRunnable);
		Thread thread4 = new Thread(myRunnable);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
