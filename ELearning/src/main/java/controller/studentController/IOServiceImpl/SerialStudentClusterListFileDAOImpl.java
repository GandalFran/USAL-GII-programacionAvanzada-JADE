package controller.studentController.IOServiceImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import POJO.StudentCluster;
import controller.IOServices.ListFileDAO;

public class SerialStudentClusterListFileDAOImpl implements ListFileDAO<StudentCluster>{

	@Override
	public boolean importMultipleObject(String path, List<StudentCluster> toFill) {
		try{
	        File f = new File(path);
	        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream( new FileInputStream(f)));
	        toFill = (List<StudentCluster>) ois.readObject();
	        ois.close();
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean exportMultipleObject(String path, List<StudentCluster> toExport) {
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
