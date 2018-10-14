package POJO;

import java.util.List;

public class StudentCluster implements ClusterImpl<Student>{

	private List<Student> clusterElements;

	public StudentCluster(){
		
	}
	
	public StudentCluster( List<Student> clusterElements) {
		this.clusterElements = clusterElements;
	}
	
	@Override
	public List<Student> getClusterElements() {
		return this.clusterElements;
	}

	@Override
	public void setClusterElements(List<Student> clusterElements) {
		this.clusterElements = clusterElements;
	}
	
	
}
