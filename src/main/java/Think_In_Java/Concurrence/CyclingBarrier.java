package Think_In_Java.Concurrence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Horse implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random rand = new Random(47);
	/**
	 * 一个同步工具，线程随机地互相等待（即1等待1,1有时等待2），能重复利用线程
	 * 
	 */
	private static CyclicBarrier barrier;

	public Horse(CyclicBarrier b) {
		barrier = b;
	}

	public synchronized int getStrides() {
		return strides;
	}
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					strides += rand.nextInt(3); // Produces 0, 1 or 2
				}
				//此时，该线程进入等待状态
				barrier.await();
			}
		} catch (InterruptedException e) {
			// A legitimate way to exit
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
	}

	public String toString() {
		return "Horse " + id + " ";
	}

	public String tracks() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < getStrides(); i++)
			s.append("*");
		s.append(id);
		return s.toString();
	}
}

public class CyclingBarrier {
	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService exec = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;

	public CyclingBarrier(int nHorses, final int pause) {
		//B：barrier action存放thread，
		//nHorse:最后一个等待状态的nparties触发barrier活动，
		//Runnable：第二个参书表示要执行的代码快(此时作参数，还不执行)
		barrier = new CyclicBarrier(nHorses, new Runnable() {
			//在变量初始化时，此时下面的方法还不执行，再需要的时候再用
			public void run() {
				StringBuilder s = new StringBuilder();
				for (int i = 0; i < FINISH_LINE; i++)
					s.append("="); // The fence on the racetrack
				System.out.println(s);
				for (Horse horse : horses)
					System.out.println(horse.tracks());
				//
				for (Horse horse : horses)
					if (horse.getStrides() >= FINISH_LINE) {
						System.out.println(horse + "won!");
						exec.shutdownNow();
						return;
					}
				try {
					//nanosecond 纳秒
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					System.out.println("barrier-action sleep interrupted");
				}
			}
		});
		for (int i = 0; i < nHorses; i++) {
			Horse horse = new Horse(barrier);
			horses.add(horse);
			exec.execute(horse);
		}
	}

	public static void main(String[] args) {
		int nHorses = 7;
		int pause = 200;
//		if (args.length > 0) { // Optional argument
//			int n = new Integer(args[0]);
//			nHorses = n > 0 ? n : nHorses;
//		}
//		if (args.length > 1) { // Optional argument
//			int p = new Integer(args[1]);
//			pause = p > -1 ? p : pause;
//		}
		new CyclingBarrier(nHorses, pause);
	}
} /* (Execute to see output) */// :~
