package com.correportuvida.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<String> collectAsString (List<? extends Object> objects, String fieldName){
		
		List<String> stringsAsAttribute = new ArrayList<String>();
		
		String getterName = "get"+Character.toUpperCase(fieldName.charAt(0))+fieldName.substring(1, fieldName.length());
		try {
			
			for (Object object : objects) {
				Method getterMethod = object.getClass().getMethod(getterName);
				Object result = getterMethod.invoke(object);
				stringsAsAttribute.add(result.toString());
			}
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringsAsAttribute;
	}
}
