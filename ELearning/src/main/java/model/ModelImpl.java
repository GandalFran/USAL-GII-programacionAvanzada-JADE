package model;

import java.util.ArrayList;
import java.util.List;


public class ModelImpl<E, C> implements Model<E,C>{

	private List<E> elementList;
	private List<C> clusterList;
	
	public ModelImpl(){
		elementList = new ArrayList<>();
		clusterList = new ArrayList<>();
	}

	@Override
	public void addAllElements(List<E> elements) {
		this.elementList.addAll( elements );
	}

	@Override
	public void addAllClusters(List<C> clusters) {
		this.clusterList.addAll( clusters );	
	}
	
	@Override
	public List<E> getAllElements() {
		return new ArrayList<>( this.elementList );
	}

	@Override
	public List<C> getAllClusters() {
		return new ArrayList<>( this.clusterList);
	}
	
	@Override
	public void clear() {
		this.elementList.clear();
		this.clusterList.clear();
	}
	
}