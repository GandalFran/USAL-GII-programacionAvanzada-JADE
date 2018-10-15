package Test;

import java.util.Arrays;
import java.util.Scanner;

import controller.projectController.ProjectControllerImpl;
import controller.studentController.StudentControllerImpl;
import utils.Constants;

public class Main {

	
	public static void main(String[]args){
		boolean result;
		Scanner sc = new Scanner(System.in);
		
		StudentControllerImpl studentController = new StudentControllerImpl();
		ProjectControllerImpl projectController = new ProjectControllerImpl();
		
		System.out.print("[Controller][IO][Student] Importing students - ");
		result = studentController.importElements(Constants.STUDENTS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][IO][Student] Exporing students - ");
		result = studentController.exportElements(Constants.STUDENTS_FILE_PATH);	System.out.println(result);	

		System.out.print("[Controller][IO][Project] Importing projects - ");
		result = projectController.importElements(Constants.PROJECTS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][IO][Project] Exporing projects - ");
		result = projectController.exportElements(Constants.PROJECTS_FILE_PATH);	System.out.println(result);	
		
		System.out.println("[Controller][IO][All] Comprobar que la deserializacion es correcta ");
		System.out.println("\t STUDENTS: " + Arrays.toString(studentController.getAllElements().toArray()) );
		System.out.println("\t PROJECTS: " + Arrays.toString(projectController.getAllElements().toArray()) );		
		
		System.out.print("[Controller][Clustering][Student] Clusterizing - ");
		result = studentController.clusterize();	System.out.println(result);	
		System.out.print("[Controller][Clustering][Project] Clusterizing - ");
		result = projectController.clusterize();	System.out.println(result);
		
		System.out.println("[Controller][Clustering][All] Clustering result");
		System.out.println("\t STUDENT CLUSTERS: " + Arrays.toString(studentController.getAllClusters().toArray()) );
		System.out.println("\t PROJECT CLUSTERS: " + Arrays.toString(projectController.getAllClusters().toArray()) );
		
		System.out.print("Elimine los ficheros de clusterizacion y pulse enter");
		sc.nextLine();
		
		System.out.print("[Controller][IO][Student] Exporing clusters - ");
		result = studentController.exportClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][IO][Project] Exporing clusters - ");
		result = projectController.exportClusters(Constants.PROJECT_CLUSTERS_FILE_PATH);	System.out.println(result);	

		studentController.clear();
		projectController.clear();
		
		System.out.print("[Controller][IO][Student] Importing clusters - ");
		result = studentController.importClusters(Constants.STUDENT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][IO][Project] Importing clusters - ");
		result = projectController.importClusters(Constants.PROJECT_CLUSTERS_FILE_PATH);	System.out.println(result);	
		
		System.out.println("[Controller][IO][All] Clustering result");
		System.out.println("\t STUDENT CLUSTERS: " + Arrays.toString(studentController.getAllClusters().toArray()) );
		System.out.println("\t PROJECT CLUSTERS: " + Arrays.toString(projectController.getAllClusters().toArray()) );	
		
		System.out.print("[Controller][Mapping][Student] Mapping students-students - ");
		result = studentController.doMappingAndExport(Constants.STUDENT_HELPERS_FILE_PATH);	System.out.println(result);	
		System.out.print("[Controller][Mapping][Project] Mapping students-projects - ");
		result = projectController.doMappingAndExport(Constants.STUDENT_PROJECTS_FILE_PATH, studentController.getAllClusters());	System.out.println(result);
		
	}
}

