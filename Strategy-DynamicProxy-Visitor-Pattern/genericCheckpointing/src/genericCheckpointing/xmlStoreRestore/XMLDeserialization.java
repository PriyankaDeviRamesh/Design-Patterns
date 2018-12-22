package genericCheckpointing.xmlStoreRestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

//This class is responsible for XMLDeserialization 

public class XMLDeserialization implements SerStrategy {

	@Override
	public String toString() {
		return "XMLDeserialization [sObject=" + sObject + ", fp=" + fp + "]";
	}

	SerializableObject sObject;
	FileProcessor fp;

	@Override
	public void processInput(SerializableObject sObject2) {

		if (!fp.flag && !fp.isEOF()) {
			/*try {
				if(fp.readLine().length() == 0) throw new Exception();
				}
				catch(Exception e) {
					System.err.println("File cannot be empty in deser mode");
				} */
			
			if (fp.readLine().matches("<DPSerialization>")) {
				String line;
				while (!(line = fp.readLine()).equals("</DPSerialization>")) {
					if (line.startsWith(" <complexType")) {
						Matcher matcher = Pattern.compile("\"(.*?)\"").matcher(line);
						if (matcher.find())
							try {
								sObject = (SerializableObject) Class.forName(matcher.group(1)).newInstance();
							} catch (Exception e) {
								e.printStackTrace();
							}
					} else if (!line.startsWith(" </complexType>")) {
						String name;
						Matcher matcher = Pattern.compile("<(.*?) xsi").matcher(line);
						if (matcher.find()) {
							name = matcher.group(1).trim();
							String type;
							matcher = Pattern.compile("\"xsd:(.*?)\"").matcher(line);
							if (matcher.find()) {
								type = matcher.group(1).trim();
								String value;
								matcher = Pattern.compile(">(.*?)</" + name + ">").matcher(line);
								if (matcher.find()) {
									value = matcher.group(1).trim();
									String methodName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
									try {
										sObject.getClass().getMethod(methodName, signature(type)).invoke(sObject, value(type, value));
									} catch (Exception e) {
										continue;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static Class<?> signature(String type) {

		switch(type) {
		case "int" : return int.class;
		case "char" : return char.class;
		case "string" : return String.class;
		case "boolean" : return boolean.class;
		case "float" : return float.class;
		case "double" : return double.class;
		case "long" : return long.class;
		case "short" : return short.class;
		}
		return null;
	}

	public static Object value(String type, String value) {

		switch(type) {
		case "int" : return new Integer(Integer.parseInt(value));
		case "char" : return new Character(value.charAt(0));
		case "string" : return value;
		case "boolean" : return Boolean.valueOf(value);
		case "float" : return Float.parseFloat(value);
		case "double" : return Double.parseDouble(value);
		case "long" : return Long.parseLong(value);
		case "short" : return Short.parseShort(value);
		}
		return null;
	}

	/**
	 * @return the sObject
	 */
	public SerializableObject getsObject() {
		return sObject;
	}

	/**
	 * @param sObject the sObject to set
	 */
	public void setsObject(SerializableObject sObject) {
		this.sObject = sObject;
	}

	/**
	 * @return the fp
	 */
	public FileProcessor getFp() {
		return fp;
	}

	/**
	 * @param fp the fp to set
	 */
	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}
}
