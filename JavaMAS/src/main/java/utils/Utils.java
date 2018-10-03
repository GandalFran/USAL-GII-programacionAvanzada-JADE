package utils;

import java.util.List;

public class Utils {

	public static String listStringToString( List<String> stringList) {
		StringBuilder sb = new StringBuilder();
		
		for(String element : stringList)
			sb.append( element );
		
		return sb.toString();
	}
}
