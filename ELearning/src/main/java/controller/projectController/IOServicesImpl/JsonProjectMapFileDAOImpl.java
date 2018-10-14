package controller.projectController.IOServicesImpl;

import java.util.Map;

import com.google.gson.Gson;

import POJO.Project;
import POJO.StudentCluster;
import controller.IOServices.MapFileDAO;
import utils.Utils;

public class JsonProjectMapFileDAOImpl implements MapFileDAO<StudentCluster,Project>{

	@Override
	public boolean importMultipleObject(String path, Map<StudentCluster, Project> toFill) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean exportMultipleObject(String path, Map<StudentCluster, Project> toExport) {
		try {
			Utils.writeFile(path, new Gson().toJson(toExport));
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}

}
