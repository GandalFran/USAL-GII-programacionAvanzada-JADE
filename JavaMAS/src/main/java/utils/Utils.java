package utils;

import java.util.List;
import java.math.*;
import POJO.Project;
import POJO.Student;

public class Utils {

	public static String listStringToString( List<String> stringList) {
		StringBuilder sb = new StringBuilder();
		
		for(String element : stringList)
			sb.append( element );
		
		return sb.toString();
	}
	
	public static double euclidianDistance(Integer[] onePoint, Integer[] anotherPoint) {
		double distance = 0.0;
		
		if (onePoint.length != anotherPoint.length)
			return -1;
		
		for (int i = 0; i < onePoint.length; i++)
			distance += Math.pow(onePoint[i].intValue() - anotherPoint[i].intValue(), 2);
		
		return Math.sqrt(distance);
	}
}
