package model;

import java.util.ArrayList;
import java.util.List;

import POJO.ClusterImpl;


public class ModelImpl<T> implements Model<T>{

	private List<T> elementList;
	private List<ClusterImpl> clusterList;
	
	public ModelImpl(){
		elementList = new ArrayList<>();
		clusterList = new ArrayList<>();
	}

	@Override
	public void addAllElements(List<T> elements) {
		this.elementList.addAll( elements );
	}

	@Override
	public void addAllClusters(List<ClusterImpl> clusters) {
		this.clusterList.addAll( clusters );	
	}
	
	@Override
	public List<T> getAllElements() {
		return new ArrayList<>( this.elementList );
	}

	@Override
	public List<ClusterImpl> getAllClusters() {
		return new ArrayList<>( this.clusterList);
	}
	
}
