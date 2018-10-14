package POJO;

import java.util.Arrays;
import java.util.List;

import controller.ICluster;

public class ProjectCluster implements ICluster<Project>{

	private static final long serialVersionUID = 1L;
	
	private List<Project> clusterElements;

	public ProjectCluster(List<Project> clusterElements) {
		this.clusterElements = clusterElements;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.clusterElements.toArray());
	}
	
	public List<Project> getClusterElements() {
		return clusterElements;
	}

	public void setClusterElements(List<Project> clusterElements) {
		this.clusterElements = clusterElements;
	}

}