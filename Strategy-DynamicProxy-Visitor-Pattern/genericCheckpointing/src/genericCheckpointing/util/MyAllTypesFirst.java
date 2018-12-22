package genericCheckpointing.util;

import genericCheckpointing.visitor.VisitorI;

//MyAllTypesFirst class have certain data types for processing and extends the empty SerializableObject base class.

public class MyAllTypesFirst extends SerializableObject{
	
	int myInt;
	long myLong;
	String myString;
	boolean myBool;
	int myOtherInt;
	long myOtherLong;
	
	public MyAllTypesFirst() {
		
	}
	
	public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBool, int myOtherInt, long myOtherLong) {
		this.myInt = myInt;
		this.myLong = myLong;
		this.myString = myString;
		this.myBool = myBool;
		this.myOtherInt = myOtherInt;
		this.myOtherLong = myOtherLong;
	}
	
	/**
	 * @return the myOtherLong
	 */
	public long getMyOtherLong() {
		return myOtherLong;
	}
	/**
	 * @param myOtherLong the myOtherLong to set
	 */
	public void setMyOtherLong(long myOtherLong) {
		this.myOtherLong = myOtherLong;
	}
	/**
	 * @return the myInt
	 */
	public int getMyInt() {
		return myInt;
	}
	/**
	 * @param myInt the myInt to set
	 */
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	/**
	 * @return the myLong
	 */
	public long getMyLong() {
		return myLong;
	}
	/**
	 * @param myLong the myLong to set
	 */
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	/**
	 * @return the myString
	 */
	public String getMyString() {
		return myString;
	}
	/**
	 * @param myString the myString to set
	 */
	public void setMyString(String myString) {
		this.myString = myString;
	}
	/**
	 * @return the myBool
	 */
	public boolean getMyBool() {
		return myBool;
	}
	/**
	 * @param myBool the myBool to set
	 */
	public void setMyBool(boolean myBool) {
		this.myBool = myBool;
	}
	/**
	 * @return the myOtherInt
	 */
	public int getMyOtherInt() {
		return myOtherInt;
	}
	/**
	 * @param myOtherInt the myOtherInt to set
	 */
	public void setMyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}
	
	public int accept(VisitorI visitor) {
		return visitor.visit(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (myBool ? 1231 : 1237);
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result + myOtherInt;
		result = prime * result + (int) (myOtherLong ^ (myOtherLong >>> 32));
		result = prime * result + ((myString == null) ? 0 : myString.hashCode());
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
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myBool != other.myBool)
			return false;
		if (myInt != other.myInt)
			return false;
		if (myLong != other.myLong)
			return false;
		if (myOtherInt != other.myOtherInt)
			return false;
		if (myOtherLong != other.myOtherLong)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myLong=" + myLong + ", myString=" + myString + ", myBool="
				+ myBool + ", myOtherInt=" + myOtherInt + ", myOtherLong=" + myOtherLong + "]";
	}

}
