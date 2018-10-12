package controller.IOServices.IOServicesImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import controller.IOServices.MapFileDAO;
import utils.Utils;

public class JsonMapFileDAOImpl<T,E> implements MapFileDAO<T,E>{

	@Override
	public boolean importMultipleObject(String path, Map<T, E> toFill) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean exportMultipleObject(String path, Map<T, E> toExport) {
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
