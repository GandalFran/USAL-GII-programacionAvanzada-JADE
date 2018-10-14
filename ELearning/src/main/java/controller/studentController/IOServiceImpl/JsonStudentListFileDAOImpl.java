package controller.studentController.IOServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import POJO.Student;
import controller.IOServices.ListFileDAO;
import utils.Utils;

public class JsonStudentListFileDAOImpl  implements ListFileDAO<Student>{

	@Override
	public boolean importMultipleObject(String path, List<Student> toFill) {
		try{
			Gson g = new Gson();
			toFill.addAll( Arrays.asList(g.fromJson(Utils.readFile(path), Student[].class)));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean exportMultipleObject(String path, List<Student> toExport) {
		try {
			Utils.writeFile(path, new Gson().toJson(toExport));
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
