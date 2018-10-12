package controller.IOServices.IOServicesImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;

import POJO.Project;
import controller.IOServices.FileDAO;
import utils.Utils;

public class JsonFileDAOImpl<T> implements FileDAO<T>{
	
	@Override
	public boolean importMultipleObject( String path, List<T> toFill ){
		String toParse = null;
		Gson gson = new Gson();
		List<String> inputList = null;
		Path p = new File( path ).toPath();
		
		try{
			inputList = Files.readAllLines( p );
		}catch(Exception e){
			return false;
		}
		
		toParse = Utils.listStringToString( inputList );
		toFill.addAll( gson.fromJson(toParse, toFill.getClass()));
		
		return true;
	}
	
	@Override
	public boolean exportMultipleObject( String path, List<T> toExport ){
		List<String>toWrite = new ArrayList<>();
		Gson gson = new Gson();
		Path p = new File( path ).toPath();
		
		toWrite.add( gson.toJson(toExport) );
		
		try{
			Files.write (p, toWrite);
		}catch(Exception e){
			return false;
		}
		
		
		return true;
	}



}
