package controller.mappingController;

import java.util.ArrayList;
import java.util.List;

import POJO.ClusterImpl;
import POJO.Student;

public interface MappingController {
	boolean doMappingAndExport(String filePath, List<ClusterImpl>studentClusterList, List<Student> helpersList);
	boolean doMappingAndExport(String filePath, List<ClusterImpl>studentClusterList, ArrayList<ClusterImpl> projectClusterList);
}
