package genericCheckpointing.driver;

import java.util.ArrayList;
import java.util.Random;

import genericCheckpointing.util.Results;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.visitor.PalindromVisitorImpl;
import genericCheckpointing.visitor.PrimeVisitorImpl;
import genericCheckpointing.visitor.VisitorI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

// This is the main class that has the methods of the corresponding classes MATF MATS.

public class Driver {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("The Program accepts 3 input");
			System.exit(0);
		}

		String mode = args[0];
		int noOfObjects = Integer.parseInt(args[1]);
		String filePath;

		try {
			if (noOfObjects <= 0)
				throw new Exception();
		} catch (Exception e) {
			System.err.println("Enter a valid NUM_OF_OBJECTS");
			System.exit(0);
		}

		try {
			if (!mode.equals("serdeser") && (!mode.equals("deser")))
				throw new Exception();
		} catch (Exception e) {
			System.err.println("Enter a valid Mode");
			System.exit(0);
		}

		if (mode.equalsIgnoreCase("deser"))
			filePath = args[2];
		else
			filePath = "checkpoint.txt";

		Results res = new Results();

		ProxyCreator pc = new ProxyCreator();
		StoreRestoreHandler srHandler = new StoreRestoreHandler();
		srHandler.setFileName(filePath);
		srHandler.setResult(res);
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class },
				srHandler);

		MyAllTypesFirst myFirst;
		MyAllTypesSecond mySecond;
		Random rand = new Random();
		ArrayList<SerializableObject> list = new ArrayList<SerializableObject>();

		if (mode.matches("serdeser")) {
			for (int i = 0; i < noOfObjects; i++) {
				myFirst = new MyAllTypesFirst(Math.abs(rand.nextInt(100)), Math.abs(rand.nextLong()),
						"level" + String.valueOf(rand.nextInt(30)) + "level", rand.nextBoolean(),
						Math.abs(rand.nextInt()), Math.abs(rand.nextLong()));
				mySecond = new MyAllTypesSecond(rand.nextDouble() * 100, rand.nextFloat() * 100,
						(char) (rand.nextInt() % 26 + 97), (short) Math.abs(rand.nextInt()), rand.nextDouble() * 100);

				list.add(myFirst);
				list.add(mySecond);

				((StoreI) cpointRef).writeObj(myFirst, rand.nextInt(1000), "XML");
				((StoreI) cpointRef).writeObj(mySecond, rand.nextInt(1000), "XML");

				System.out.println(myFirst);
				System.out.println(mySecond);

			}
			res.writeToFile(filePath);
		}

		SerializableObject myRecordRet;
		ArrayList<SerializableObject> list2 = new ArrayList<SerializableObject>();

		for (int j = 0; j < 2 * noOfObjects; j++) {
			myRecordRet = ((RestoreI) cpointRef).readObj("XML");
            if(myRecordRet != null) {
			list2.add(myRecordRet);
		    }
        }
		for (SerializableObject obj : list2)
			if (obj != null)
				System.out.println(obj);

		int match = 0;
		for (SerializableObject obj : list) {
			if (!obj.equals(list2.get(list.indexOf(obj)))) {
				match++;
			}
		}

		if (!mode.matches("deser"))
			System.out.println(match + " instances mismatched");

		PalindromVisitorImpl palV = new PalindromVisitorImpl();
		PrimeVisitorImpl priV = new PrimeVisitorImpl();

		int uniquePrimeCount = 0;
		ArrayList<String> palindromes = new ArrayList<>();

		for (SerializableObject obj : list) {
			try {
				uniquePrimeCount = uniquePrimeCount
						+ (int) obj.getClass().getMethod("accept", VisitorI.class).invoke(obj, priV);

				boolean isPalindrome = (boolean) (((int) obj.getClass().getMethod("accept", VisitorI.class).invoke(obj,
						palV)) == 1) ? true : false;

				if (isPalindrome) {
					String fieldValue = (String) obj.getClass().getMethod("getMyString").invoke(obj);
					palindromes.add(fieldValue);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(uniquePrimeCount);
		System.out.println(palindromes.toString());

	}

}
