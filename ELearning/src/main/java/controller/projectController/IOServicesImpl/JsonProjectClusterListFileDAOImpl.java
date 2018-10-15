package controller.projectController.IOServicesImpl;

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
import POJO.ProjectCluster;
import controller.IOServices.ListFileDAO;
import utils.Utils;

public class JsonProjectClusterListFileDAOImpl implements ListFileDAO<ProjectCluster>{

	@Override
	public boolean importMultipleObject(String path, List<ProjectCluster> toFill) {
		try{
			Gson g = new Gson();
			toFill.addAll( Arrays.asList(g.fromJson(Utils.readFile(path), ProjectCluster[].class)));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean exportMultipleObject(String path, List<ProjectCluster> toExport) {
		try {
			Utils.writeFile(path, new Gson().toJson(toExport));
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
