package controller.projectController;

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
			boolean flag = false;
			int k = 0;
			
			// The average skills of the students are calculated
			for (int i = 1; i < studentList.size(); i++)
				for (int j = 0; j < averageSkills.length; j++)
					averageSkills[j] += studentList.get(i).getPoint()[j];
			
			for (int i = 0; i < averageSkills.length; i++)
				averageSkills[i] /= studentList.size();
			
			// We are looking for a projects' cluster that have skills similar 
			// to the average of the students' skills.
			while (!flag) {
				k++;
				
				for (ProjectCluster projectCluster: projectClusterList) {
					if (Constants.EPSILON * k > Utils.euclidianDistance(((Project) projectCluster.getClusterElements().get(0)).getPoint(), averageSkills)) {
						// We are looking for a project that is suitable for student cluster.
						for (Project project: projectCluster.getClusterElements()) {
							double[] projectSkills = project.getPoint();
							flag = true;
							
							for (int i = 0; i < projectSkills.length; i++) {
								double difference = projectSkills[i] - averageSkills[i];
								
								if (difference < 0 || difference > Constants.DELTA * k) {
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
						if (!flag) {
							flag = true;
							List<Project> firstProjectClusterList = projectCluster.getClusterElements();
							toFill.put(studentCluster, firstProjectClusterList.get(0));
						}
						
						break;
					}
				}	
			}
		}
		
		return true;
	}

}