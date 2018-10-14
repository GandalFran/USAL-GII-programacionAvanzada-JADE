package TestPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import POJO.ClusterImpl;
import POJO.Project;
import POJO.Student;
import controller.controllerImpl.ProjectControllerImpl;
import utils.Constants;

public class Main {

	
	public static void main(String[]args){
		boolean result;
		Scanner sc = new Scanner(System.in);
		
		ProjectControllerImpl<Student> studentController = new ProjectControllerImpl<>();
		ProjectControllerImpl<Project> projectController = new ProjectControllerImpl<>();
	
		
		System.out.print("[Controller][IO][Student] Importing students - ");
		result = studentController.importElements(Constants.STUDENTS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][IO][Student] Importing clusters - ");
		result = studentController.importElements(Constants.STUDENT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		
		System.out.print("[Controller][IO][Project] Importing projects - ");
		result = projectController.importElements(Constants.PROJECTS_FILE_PATH);		System.out.println(result);	
		System.out.print("[Controller][IO][Project] Importing clusters - ");
		result = projectController.importElements(Constants.PROJECT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		
		System.out.print("Elimine los ficheros y pulse enter");
		sc.nextLine();
		
		System.out.print("[Controller][IO][Student] Exporing students - ");
		result = studentController.exportElements(Constants.STUDENTS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][IO][Student] Exporing clusters - ");
		result = studentController.exportClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		
		System.out.print("[Controller][IO][Project] Exporing projects - ");
		result = projectController.exportElements(Constants.PROJECTS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][IO][Project] Exporing clusters - ");
		result = projectController.exportClusters(Constants.PROJECT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		
		System.err.println(studentController.getAllClusters());

		
		System.out.print("Elimine los ficheros de clusterizacion y pulse enter");
		sc.nextLine();
		
		System.out.print("[Controller][Clustering][Student] Clusterizing - ");
		result = studentController.clusterize();	System.out.println(result);	
		System.out.print("[Controller][Clustering][Project] Clusterizing - ");
		result = projectController.clusterize();	System.out.println(result);	
		
		
		System.out.print("[Controller][Clustering][Student] Exporing clusters - ");
		result = studentController.exportClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][Clustering][Project] Exporing clusters - ");
		result = projectController.exportClusters(Constants.PROJECT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		
		
		
		System.out.print("[Controller][Mapping][Student] Mapping students-students - ");
		result = studentController.doMappingAndExport(Constants.STUDENT_HELPERS_FILE_PATH, studentController.getAllClusters(), studentController.getAllElements());	System.out.println(result);	
		System.out.print("[Controller][Mapping][Project] Mapping students-projects - ");
		result = studentController.doMappingAndExport(Constants.STUDENT_PROJECTS_FILE_PATH, studentController.getAllClusters(),(ArrayList<ClusterImpl>) projectController.getAllClusters());	System.out.println(result);
	}
}
