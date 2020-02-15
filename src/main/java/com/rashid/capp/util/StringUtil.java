package com.rashid.capp.util;

public class StringUtil {
	
	public static String toCommaSeparetedString(Object[] items) {
		StringBuilder  stringBuilder = new StringBuilder();
		
		for(Object item : items) {
			stringBuilder.append(item).append(",");
		}
		if(stringBuilder.length()>0) {
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		return stringBuilder.toString();
	}

}
