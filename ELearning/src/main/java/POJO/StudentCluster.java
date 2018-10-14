package POJO;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import controller.ICluster;

public class StudentCluster implements ICluster<Student>, Serializable{

	private static final long serialVersionUID = 1L;

	private List<Student> clusterElements;

	public StudentCluster(List<Student> clusterElements) {
		this.clusterElements = clusterElements;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.clusterElements.toArray());
	}
	
	public List<Student> getClusterElements() {
		return clusterElements;
	}

	public void setClusterElements(List<Student> clusterElements) {
		this.clusterElements = clusterElements;
	}

}
