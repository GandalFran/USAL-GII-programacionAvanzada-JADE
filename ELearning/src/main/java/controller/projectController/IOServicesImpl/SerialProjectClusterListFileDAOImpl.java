package controller.projectController.IOServicesImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import POJO.ProjectCluster;
import controller.IOServices.ListFileDAO;

public class SerialProjectClusterListFileDAOImpl implements ListFileDAO<ProjectCluster>{

	@Override
	public boolean importMultipleObject(String path, List<ProjectCluster> toFill) {
		try{
	        File f = new File(path);
	        FileInputStream fis = new FileInputStream(f);
	        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream( fis));
	        toFill = (List<ProjectCluster>) ois.readObject();
	        ois.close();
	        fis.close();
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean exportMultipleObject(String path, List<ProjectCluster> toExport) {
		try {
	        File f = new File(path);
	        FileOutputStream fos = new FileOutputStream(f);
	        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
	        oos.writeObject(toExport);
	        oos.close();
	        fos.close();
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
