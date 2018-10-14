package controller.projectController.IOServicesImpl;

import java.util.Arrays;
import java.util.List;
import POJO.Project;
import POJO.Student;
import controller.IOServices.ListFileDAO;
import utils.Utils;
import com.google.gson.Gson;

public class JsonProjectListFileDAOImpl implements ListFileDAO<Project>{

	@Override
	public boolean importMultipleObject(String path, List<Project> toFill) {
		try{
			Gson g = new Gson();
			toFill.addAll( Arrays.asList(g.fromJson(Utils.readFile(path), Project[].class)));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean exportMultipleObject(String path, List<Project> toExport) {
		try {
			Utils.writeFile(path, new Gson().toJson(toExport));
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
