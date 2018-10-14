package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static String listStringToString( List<String> stringList) {
		StringBuilder sb = new StringBuilder();
		
		for(String element : stringList)
			sb.append( element );
		
		return sb.toString();
	}

	public static String readFile(String path) throws Exception{
		List<String> inputList = null;
		Path p = new File( path ).toPath();

		inputList = Files.readAllLines( p );

		return Utils.listStringToString( inputList );
	}
	
	public static boolean writeFile(String path, String content) throws Exception{
		List<String>toWrite = new ArrayList<>();
		Path p = new File( path ).toPath();
		toWrite.add( content );

		Files.write (p, toWrite);

		return true;
	}
	
	public static double euclidianDistance(double[] onePoint, double[] anotherPoint) {
		double distance = 0.0;
		
		if (onePoint.length != anotherPoint.length)
			return -1;
		
		for (int i = 0; i < onePoint.length; i++)
			distance += Math.pow(onePoint[i] - anotherPoint[i], 2)/Constants.DIMENSION;
		
		return Math.sqrt(distance);
	}
}
