package Think_In_Java.Concurrence;

class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}
	public void run() {
		try {
			System.out.println(getName()+Thread.currentThread().getPriority());
			sleep(duration);
		} catch (InterruptedException e) {
			//线程获取名字getName
			System.out.println(getName() + " was interrupted. " + "isInterrupted(): "
					+ isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}

	public void run() {
		try {
			System.out.println(getName()+Thread.currentThread().getPriority());
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}

public class JoinThread {
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500), grumpy = new Sleeper(
				"Grumpy", 1500);
		Joiner dopey = new Joiner("Dopey", sleepy), doc = new Joiner("Doc",
				grumpy);
		System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority());
		grumpy.interrupt();
	}
}