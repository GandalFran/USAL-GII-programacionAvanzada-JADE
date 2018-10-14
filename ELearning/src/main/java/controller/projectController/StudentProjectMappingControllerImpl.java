package controller.projectController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import POJO.Project;
import POJO.ProjectCluster;
import POJO.Student;
import POJO.StudentCluster;
import controller.MappingController;
import utils.Constants;
import utils.Utils;

public class StudentProjectMappingControllerImpl implements MappingController<ProjectCluster,Project>{

	@Override
	public boolean doMapping(List<StudentCluster>studentClusterList, List<ProjectCluster> projectClusterList, Map<StudentCluster,Project> toFill) {
		
		for (StudentCluster studentCluster: studentClusterList) {
			List<Student> studentList = studentCluster.getClusterElements();
			double[] averageSkills = studentList.get(0).getPoint();
			
			// The average skills of the students are calculated
			for (int i = 1; i < studentList.size(); i++)
				for (int j = 0; j < averageSkills.length; j++)
					averageSkills[j] += studentList.get(i).getPoint()[j];
			
			for (int i = 0; i < averageSkills.length; i++)
				averageSkills[i] /= studentList.size();
			
			// We are looking for a projects' cluster that have skills similar 
			// to the average of the students' skills.
			for (ProjectCluster projectCluster: projectClusterList) {
				if (Constants.EPSILON > Utils.euclidianDistance(((Project) projectCluster.getClusterElements().get(0)).getPoint(), averageSkills)) {
					boolean flag = true;
					
					// We are looking for a project that is suitable for student cluster.
					for (Project project: projectCluster.getClusterElements()) {
						double[] projectSkills = project.getPoint();
						flag = true;
						
						for (int i = 0; i < projectSkills.length; i++) {
							double difference = projectSkills[i] - averageSkills[i];
							
							if (difference < 0 || difference > Constants.DELTA) {
								flag = false;
								break;
							}
						}
						
						// Adding the match.
						if(flag) {
							toFill.put(studentCluster, project);
							break;
						}
					}
					
					// If not found a suitable project, it will match with the first project of the project cluster.
					List<Project> firstProjectClusterList = (List<Project>)(Object) projectCluster.getClusterElements();
					if (!flag)
						toFill.put(studentCluster, firstProjectClusterList.get(0));
					
					break;
				}
			}	
		}
		

		return true;
	}

}