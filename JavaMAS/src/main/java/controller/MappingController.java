package controller;

import java.util.ArrayList;
import java.util.List;

import POJO.Cluster;
import POJO.Project;
import POJO.Student;

public interface MappingController {
	boolean doMappingAndExport(String filePath, List<Cluster<Student>>studentClusterList, List<Student> helpersList);
	boolean doMappingAndExport(String filePath, List<Cluster<Student>>studentClusterList, ArrayList<Project> projectList);
}
