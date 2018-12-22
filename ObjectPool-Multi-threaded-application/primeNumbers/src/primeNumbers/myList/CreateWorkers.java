package primeNumbers.myList;

import java.util.List;

import primeNumbers.Mylogger.MyLogger;
import primeNumbers.Mylogger.MyLogger.DebugLevel;
import primeNumbers.util.FileProcessor;
import primeNumbers.util.IsPrime;
import primeNumbers.util.Results;

/** 
 * This class is responsible for starting the threads by invoking the WorkerThread's run() 
 * and also invokes borrow(). This class also has constructor that gets the objects of other class as arguments.
 *  **/

public class CreateWorkers {

	FileProcessor fp;
	Results r;
	IsPrime ip;

	public CreateWorkers (FileProcessor fpIn, Results rIn, IsPrime ipIn) {
		fp = fpIn;
		r = rIn;
		ip = ipIn;

		MyLogger.writeMessage ("CreateWorkers Constructor", DebugLevel.CONSTRUCTOR );
	}

	public void startWorkers (String NUM_THREADS) {
		ThreadPool wT = new ThreadPool(fp, r, ip);
		List<Thread> threads = wT.Borrow(Integer.parseInt(NUM_THREADS));

		for (Thread t : threads) {
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "CreateWorkers [fp=" + fp + ", r=" + r + ", ip=" + ip + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fp == null) ? 0 : fp.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		return result;
	}

}
