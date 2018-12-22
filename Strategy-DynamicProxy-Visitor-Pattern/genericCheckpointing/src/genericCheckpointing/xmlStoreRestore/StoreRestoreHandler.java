package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;

//Store Restore Handler Class.

public class StoreRestoreHandler implements InvocationHandler {

	@Override
	public String toString() {
		return "StoreRestoreHandler [result=" + result + ", fp=" + fp + "]";
	}

	Results result;
	FileProcessor fp;

	@Override
	public Object invoke(Object arg0, Method m, Object[] arg2) throws Throwable {
		
		XMLDeserialization xmlDeser = new XMLDeserialization();
		xmlDeser.setFp(fp);
		
		
		if(m.getName().matches("writeObj")) {
			if(arg2[2].toString().matches("XML")) {
				serializeData((SerializableObject)arg2[0], new XMLSerialization(this.result));
				return null;
			}
		}
		else if(m.getName().matches("readObj")) {
			if(arg2[0].toString().matches("XML")) {
				serializeData(new SerializableObject(), xmlDeser);
				return xmlDeser.getsObject();
			}
		}
		return null;
	}
	
	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
        sStrategy.processInput(sObject);
	}
	
	public void setFileName(String path) {
		fp = new FileProcessor(path);
	}
	
	public void setResult(Results result) {
		this.result = result;
	}

}
