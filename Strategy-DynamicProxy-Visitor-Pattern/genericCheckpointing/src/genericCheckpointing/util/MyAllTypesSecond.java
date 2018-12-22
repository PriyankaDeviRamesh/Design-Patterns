package genericCheckpointing.util;

import genericCheckpointing.visitor.VisitorI;

//MyAllTypesSecond class have certain other data types for processing and extends the empty SerializableObject base class.


public class MyAllTypesSecond extends SerializableObject{

	double myDoubleT;
	float myFloatT;
	char myCharT;
	short myShortT;
	double myOtherDoubleT;
	
	public MyAllTypesSecond() {
		
	}
	
	public MyAllTypesSecond(double myDoubleT, float myFloatT, char myCharT,	short myShortT,	double myOtherDoubleT) {
		this.myDoubleT = myDoubleT;
		this.myFloatT = myFloatT;
		this.myCharT = myCharT;
		this.myShortT = myShortT;
		this.myOtherDoubleT = myOtherDoubleT;
	}
	
	/**
	 * @return the myOtherDoubleT
	 */
	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}
	/**
	 * @param myOtherDoubleT the myOtherDoubleT to set
	 */
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT = myOtherDoubleT;
	}
	/**
	 * @return the myDoubleT
	 */
	public double getMyDoubleT() {
		return myDoubleT;
	}
	/**
	 * @param myDoubleT the myDoubleT to set
	 */
	public void setMyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	/**
	 * @return the myFloatT
	 */
	public float getMyFloatT() {
		return myFloatT;
	}
	/**
	 * @param myFloatT the myFloatT to set
	 */
	public void setMyFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}
	/**
	 * @return the myCharT
	 */
	public char getMyCharT() {
		return myCharT;
	}
	/**
	 * @param myCharT the myCharT to set
	 */
	public void setMyCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	/**
	 * @return the myShortT
	 */
	public short getMyShortT() {
		return myShortT;
	}
	/**
	 * @param myShortT the myShortT to set
	 */
	public void setMyShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	
	public int accept(VisitorI visitor) {
		return visitor.visit(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		temp = Double.doubleToLongBits(myOtherDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myShortT;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharT != other.myCharT)
			return false;
		if (Double.doubleToLongBits(myDoubleT) != Double.doubleToLongBits(other.myDoubleT))
			return false;
		if (Float.floatToIntBits(myFloatT) != Float.floatToIntBits(other.myFloatT))
			return false;
		if (Double.doubleToLongBits(myOtherDoubleT) != Double.doubleToLongBits(other.myOtherDoubleT))
			return false;
		if (myShortT != other.myShortT)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyAllTypesSecond [myDoubleT=" + myDoubleT + ", myFloatT=" + myFloatT + ", myCharT=" + myCharT
				+ ", myShortT=" + myShortT + ", myOtherDoubleT=" + myOtherDoubleT + "]";
	}
}
