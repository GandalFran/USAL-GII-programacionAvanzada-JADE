package TestPackage;

import java.util.ArrayList;
import java.util.Scanner;

import POJO.Cluster;
import POJO.Project;
import POJO.Student;
import controller.Controller;
import controller.IOServices.FileDAO;
import controller.IOServices.IOServicesImpl.JsonFileDAOImpl;
import controller.controllerImpl.ControllerImpl;
import utils.Constants;

public class Main {

	
	public static void main(String[]args){
		boolean result;
		Scanner sc = new Scanner(System.in);
		
		ControllerImpl<Student> studentController = new ControllerImpl<>();
		ControllerImpl<Project> projectController = new ControllerImpl<>();
	
		
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
		
		
		/*
		
		
		
		System.out.print("Elimine los ficheros de clusterizacion y pulse enter");
		sc.nextLine();
		
		System.out.print("[Controller][Clustering][Student] Importing students - ");
		result = studentController.clusterize();	System.out.println(result);	
		System.out.print("[Controller][Clustering][Project] Importing clusters - ");
		result = projectController.clusterize();	System.out.println(result);	
		
		
		System.out.print("[Controller][Clustering][Student] Exporing clusters - ");
		result = studentController.exportClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][Clustering][Project] Exporing clusters - ");
		result = projectController.exportClusters(Constants.PROJECT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		
		
		*/
		
		
		
		System.out.print("[Controller][Mapping][Student] Mapping students-students - ");
		result = studentController.doMappingAndExport(Constants.STUDENT_HELPERS_FILE_PATH, studentController.getAllClusters(), studentController.getAllElements());	System.out.println(result);	
		System.out.print("[Controller][Mapping][Project] Mapping students-projects - ");
		result = studentController.doMappingAndExport(Constants.STUDENT_PROJECTS_FILE_PATH, studentController.getAllClusters(),(ArrayList<Cluster<Project>>) projectController.getAllClusters());	System.out.println(result);
	}
}
