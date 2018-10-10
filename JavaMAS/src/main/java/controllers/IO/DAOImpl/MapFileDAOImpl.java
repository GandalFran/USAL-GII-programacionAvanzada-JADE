package controllers.IO.DAOImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import utils.Utils;

public class MapFileDAOImpl<T,E> implements MapFileDAO<T,E>{

	@Override
	public boolean importMultipleObject(String path, Map<T, E> toFill) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean exportMultipleObject(String path, Map<T, E> toExport) {
		List<String>toWrite = null;
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
