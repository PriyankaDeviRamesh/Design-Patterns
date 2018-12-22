package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Field;

import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;

//This class is responsible for XMLSerialization

public class XMLSerialization implements SerStrategy {
	
	@Override
	public String toString() {
		return "XMLSerialization [results=" + results + "]";
	}

	Results results;
	
	public XMLSerialization(Results results) {
		this.results = results;
	}

	@Override
	public void processInput(SerializableObject sObject) {
		results.addToResults("<DPSerialization>");
		Class<?> cls = sObject.getClass();
		Field[] fld = cls.getDeclaredFields();
		results.addToResults(" <complexType xsi:type=\""+cls.getName()+"\">");
		for(Field fl: fld) {
			try {
				String methodName = "get" + Character.toUpperCase(fl.getName().charAt(0)) + fl.getName().substring(1);
				Object invokeRet = cls.getMethod(methodName).invoke(sObject);
				if(fl.getType() == int.class && (int)invokeRet>=10) {results.addToResults(serializeInt(fl.getName(), (int)invokeRet));}
				else if(fl.getType() == float.class) results.addToResults(serializeFloat(fl.getName(), (float)invokeRet));
				else if(fl.getType() == double.class && (double)invokeRet>=10) results.addToResults(serializeDouble(fl.getName(), (double)invokeRet));
				else if(fl.getType() == long.class && (long)invokeRet>=10) results.addToResults(serializeLong(fl.getName(), (long)invokeRet));
				else if(fl.getType() == char.class) results.addToResults(serializeChar(fl.getName(), (char)invokeRet));
				else if(fl.getType() == boolean.class) results.addToResults(serializeBool(fl.getName(), (boolean)invokeRet));
				else if(fl.getType() == String.class) results.addToResults(serializeString(fl.getName(), (String)invokeRet));
				else if(fl.getType() == short.class) results.addToResults(serializeShort(fl.getName(), (short)invokeRet));
			} catch (Exception e) {
				continue;
			} 
		}
		results.addToResults(" </complexType>");
		results.addToResults("</DPSerialization>");
	}
	
	public String serializeInt(String name, int value) {
		return "  <" +name+" xsi:type=\"xsd:int\">"+value+"</"+name+">";
	}
	
	public String serializeFloat(String name, float value) {
		return "  <" +name+" xsi:type=\"xsd:float\">"+value+"</"+name+">";
	}
	
	public String serializeDouble(String name, double value) {
		return "  <" +name+" xsi:type=\"xsd:double\">"+value+"</"+name+">";
	}
	
	public String serializeLong(String name, long value) {
		return "  <" +name+" xsi:type=\"xsd:long\">"+value+"</"+name+">";
	}
	
	public String serializeChar(String name, char value) {
		return "  <" +name+" xsi:type=\"xsd:char\">"+value+"</"+name+">";
	}
	
	public String serializeBool(String name, boolean value) {
		return "  <" +name+" xsi:type=\"xsd:boolean\">"+value+"</"+name+">";
	}
	
	public String serializeString(String name, String value) {
		return "  <" +name+" xsi:type=\"xsd:string\">"+value+"</"+name+">";
	}
	
	public String serializeShort(String name, short value) {
		return "  <" +name+" xsi:type=\"xsd:short\">"+value+"</"+name+">";
	}

}
