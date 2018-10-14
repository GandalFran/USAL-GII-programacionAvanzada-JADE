package controller.studentController.IOServiceImpl;

import java.util.Map;

import com.google.gson.Gson;

import POJO.Student;
import POJO.StudentCluster;
import controller.IOServices.MapFileDAO;
import utils.Utils;

public class JsonStudentMapFileDAOImpl  implements MapFileDAO<StudentCluster,Student>{
	
	@Override
	public boolean importMultipleObject(String path, Map<StudentCluster, Student> toFill) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean exportMultipleObject(String path, Map<StudentCluster, Student> toExport) {
		try {
			Utils.writeFile(path, new Gson().toJson(toExport));
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
