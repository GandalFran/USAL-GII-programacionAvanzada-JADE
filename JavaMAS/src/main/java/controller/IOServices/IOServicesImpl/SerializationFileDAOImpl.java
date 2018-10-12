package controller.IOServices.IOServicesImpl;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import POJO.ClusterImpl;
import controller.IOServices.FileDAO;

public class SerializationFileDAOImpl implements FileDAO<ClusterImpl>{

	@Override
	public boolean importMultipleObject(String path, List<ClusterImpl> toFill) {
		
		try{
	        File f = new File(path);
	        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream( new FileInputStream(f)));
	        toFill = (List<ClusterImpl>)(Object) ois.readObject();
	        ois.close();
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean exportMultipleObject(String path, List<ClusterImpl> toExport) {
		try {
	        File f = new File(path);
	        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
	        oos.writeObject(toExport);
	        oos.close();
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
