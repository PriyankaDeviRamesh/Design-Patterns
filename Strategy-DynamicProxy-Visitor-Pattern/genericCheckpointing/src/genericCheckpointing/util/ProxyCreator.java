package genericCheckpointing.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import genericCheckpointing.server.StoreRestoreI;

//This class is to createProxy.

public class ProxyCreator {

	public StoreRestoreI createProxy(Class<?>[] interfaceArray, InvocationHandler handler) {
		StoreRestoreI serDeserObj = (StoreRestoreI) Proxy.newProxyInstance(getClass().getClassLoader(), interfaceArray,	handler);
		return serDeserObj;
	}

}
