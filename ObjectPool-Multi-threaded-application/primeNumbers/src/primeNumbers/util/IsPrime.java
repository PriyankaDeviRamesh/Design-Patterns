package primeNumbers.util;

/**
 * This class is responsible for checking if a number is prime or not with the check() 
 * and returns boolean value accordingly 
 * **/

public class IsPrime {
	
	public boolean check(int Num) {
		if (Num % 2 == 0) {
			return false;
		} 
		else 
			return true;
	}

	@Override
	public String toString() {
		return "IsPrime [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
