package POJO;

import java.util.List;

public class Cluster <T>{

	private List<T> clusterElements;
	
	public Cluster( List<T> clusterElements ){
		this.clusterElements = clusterElements;
	}
	
	public List<T> getClusterElements() {
		return clusterElements;
	}

	public void setClusterElements(List<T> clusterElements) {
		this.clusterElements = clusterElements;
	}
	
	
}
