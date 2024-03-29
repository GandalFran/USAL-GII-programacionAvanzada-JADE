package POJO;

import java.util.Arrays;
import java.util.List;

import controller.ICluster;

public class StudentCluster implements ICluster<Student>{

	private Student[] clusterElements;

	public StudentCluster(List<Student> clusterElements) {
		this.clusterElements = new Student[clusterElements.size()];
		this.clusterElements = clusterElements.toArray(this.clusterElements);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.clusterElements);
	}
	
	public List<Student> getClusterElements() {
		return Arrays.asList( clusterElements);
	}

	public void setClusterElements(List<Student> clusterElements) {
		this.clusterElements = (Student[]) clusterElements.toArray();
	}

}
