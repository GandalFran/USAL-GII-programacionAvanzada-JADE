package controller.studentController;

import java.util.List;
import java.util.Map;

import POJO.Student;
import POJO.StudentCluster;
import controller.MappingController;
import utils.Constants;

public class StudentStudentMappingControllerImpl implements MappingController<Student,Student>{

	@Override
	public boolean doMapping(List<StudentCluster> studentClusterList, List<Student> helpersList, Map<StudentCluster, Student> toFill) {		
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
			
			// you are looking for a helper who has slightly better skills
			while (!flag) {
				k++;
				
				for (Student helper: helpersList) {
					double[] helperSkills = helper.getPoint();
					flag = true;
					
					for (int i = 0; i < helperSkills.length; i++) {
						if (averageSkills[i] < 100 - Constants.DELTA) {
							double difference = helperSkills[i] - averageSkills[i];
						
							if (difference < Constants.DELTA/k || difference > (k + 1)*Constants.DELTA) {
								flag = false;
								break;
							}
						} else if (helperSkills[i] < Constants.DELTA * k) {
							flag = false;
							break;
						}
					}
					
					// Adding the match.
					if (flag) {
						toFill.put(studentCluster, helper);
						break;
					}
				}
			}
		}

		return true;
	}
}
