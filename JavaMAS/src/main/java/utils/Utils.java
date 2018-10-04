package utils;

import java.util.List;

import ClusterServices.ClusterizablePOJO.ClusterizableProject;
import ClusterServices.ClusterizablePOJO.ClusterizableStudent;
import POJO.Project;
import POJO.Student;

public class Utils {

	public static String listStringToString( List<String> stringList) {
		StringBuilder sb = new StringBuilder();
		
		for(String element : stringList)
			sb.append( element );
		
		return sb.toString();
	}
	
	public static ClusterizableProject getClusterizable(Project p) {
		ClusterizableProject cp = new ClusterizableProject();
		
		cp.setId(p.getId());
		cp.setName(p.getName());
		cp.setNeededSkills(p.getNeededSkills());
		
		return cp;
		
	}
	
	public static ClusterizableStudent getClusterizable(Student s) {
		ClusterizableStudent cs = new ClusterizableStudent();
		
		cs.setId(s.getId());
		cs.setName(s.getName());
		cs.setSkills(s.getSkills());
		
		return cs;
		
	}
	
	public static Project getNotClusterizable( ClusterizableProject cp) {
		return new Project(cp.getId(),cp.getName(),cp.getNeededSkills());
	}
	
	public static Student getNotClusterizable( ClusterizableStudent cs) {
		return new Student(cs.getId(),cs.getName(),cs.getSkills());
	}
}
