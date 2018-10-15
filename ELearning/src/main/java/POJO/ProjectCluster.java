package POJO;

import java.util.Arrays;
import java.util.List;

import controller.ICluster;

public class ProjectCluster implements ICluster<Project>{

	private Project[] clusterElements;

	public ProjectCluster(List<Project> clusterElements) {
		this.clusterElements = new Project[clusterElements.size()];
		this.clusterElements = clusterElements.toArray(this.clusterElements);
	}

	@Override
	public String toString() {
		return Arrays.toString(this.clusterElements);
	}
	
	public List<Project> getClusterElements() {
		return Arrays.asList( clusterElements);
	}

	public void setClusterElements(List<Project> clusterElements) {
		this.clusterElements = (Project[]) clusterElements.toArray();
	}

}