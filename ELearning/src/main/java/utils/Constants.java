package utils;

import java.io.File;

public interface Constants {
	String USER_DESKTOP = System.getProperty("user.home") + File.separator + "Desktop" + File.separator;
	
	String PROJECTS_FILE_PATH = USER_DESKTOP + "projectData.json";
	String STUDENTS_FILE_PATH = USER_DESKTOP + "studentData.json";
	String PROJECT_CLUSTERS_FILE_PATH = USER_DESKTOP + "projectClusterizedData.json";
	String STUDENT_CLUSTERS_FILE_PATH = USER_DESKTOP + "studentClusterizedData.json";
	String STUDENT_HELPERS_FILE_PATH  = USER_DESKTOP + "studentGroupsMatchedWithHelpers.json";
	String STUDENT_PROJECTS_FILE_PATH = USER_DESKTOP + "sutdentGroupsMatchedWithProjects.json";
	
	String PCA_NAME = "PCA";
	String SCA_NAME = "SCA";
	String DPCA_NAME = "DPCA";
	String DSCA_NAME = "DSCA";
	String SPMA_NAME = "SPMA";	
	String SSMA_NAME = "SSMA";
	
	String ONTOLY_NAME = "MAIN_ONTOLOGY";
	
	float EPSILON = 18.0f;
	float DELTA = 10.0f;	

	int DIMENSION = 3;
	double MAXRADIUS = 18;
	int MINPOINTS = 2;
}
