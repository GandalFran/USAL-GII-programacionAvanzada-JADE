package model;

public class ModelImpl<T> implements Model<T>{

	private List<T> elementList;
	private List<Cluster<T>> clusterList;
	
	public ModelImpl(){
		elementList = new ArrayList<>();
		clusterList = new ArrayList<>();
	}

	@Override
	public void addAllElements(List<T> elements) {
		this.elementList.addAll( elements );
	}

	@Override
	public void addAllClusters(List<Cluster<T>> clusters) {
		this.clusterList.addAll( clusters );	
	}
	
	@Override
	public List<T> getAllElements() {
		return this.elementList.clone();
	}

	@Override
	public List<Cluster<T>> getAllClusters() {
		return this.clusterList.clone();
	}
	
}
