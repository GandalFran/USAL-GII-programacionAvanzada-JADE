package controller.studentController.IOServiceImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import POJO.Project;
import POJO.StudentCluster;
import controller.IOServices.ListFileDAO;
import utils.Utils;

public class JsonStudentClusterListFileDAOImpl implements ListFileDAO<StudentCluster>{


	@Override
	public boolean importMultipleObject(String path, List<StudentCluster> toFill) {
		try{
			Gson g = new Gson();
			toFill.addAll( Arrays.asList(g.fromJson(Utils.readFile(path), StudentCluster[].class)));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean exportMultipleObject(String path, List<StudentCluster> toExport) {
		try {
			Utils.writeFile(path, new Gson().toJson(toExport));
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
