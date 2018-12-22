package primeNumbers.myList;

import java.util.ArrayList;
import java.util.List;

import primeNumbers.Mylogger.MyLogger;
import primeNumbers.Mylogger.MyLogger.DebugLevel;

import primeNumbers.util.FileProcessor;
import primeNumbers.util.IsPrime;
import primeNumbers.util.Results;


/**
 * This class is responsible for extending thread class and using run(). In run() it checks if the read input is prime or not by invoking check() from Isprime class. 
 * Later adds it to the results class.
 * **/

/* @author priyankadevi
 *
 */
public class ThreadPool {

	FileProcessor fp;
	Results r;
	IsPrime ip;

	List<Thread> threads = new ArrayList<Thread>();

	public ThreadPool(FileProcessor fpIn, Results rIn, IsPrime ipIn) {
		fp = fpIn;
		r = rIn;
		ip = ipIn;

		MyLogger.writeMessage ("WorkerThread Constructor", DebugLevel.CONSTRUCTOR );

		for(int i=0; i<5; i++) {
			Thread th = new Thread(new WorkerThread());
			threads.add(th);
		}
	}

	public List<Thread> Borrow(int NUM_THREADS) {
		List<Thread> Num_thread = new ArrayList<Thread>();	
		for(int j=0; j<NUM_THREADS; j++) {
			Num_thread.add(threads.remove(0));
		}

		return Num_thread;
	}

	public class WorkerThread implements Runnable{
		@Override
		public void run() {
			MyLogger.writeMessage ("run() is invoked", DebugLevel.RUN );
			String line = fp.readFromFile(fp.getFileName());
			while (line != null) {
				int n = Integer.parseInt(line);
				boolean value = ip.check(n);
				if (value) {
					r.addToResults(n);
					MyLogger.writeMessage ("An entry is added to the Results data structure: " + Integer.toString(n), DebugLevel.RESULTS_ENTRY );
				}

				line = fp.readFromFile(fp.getFileName()); 
			}
		}
	}

	@Override
	public String toString() {
		return "WorkerThread [fp=" + fp + ", r=" + r + ", ip=" + ip + ", threads=" + threads + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fp == null) ? 0 : fp.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		result = prime * result + ((threads == null) ? 0 : threads.hashCode());
		return result;
	}
}
