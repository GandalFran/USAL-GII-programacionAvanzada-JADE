package ClusterServices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ClusterServices.DataTypes.Clusterizable;
import ClusterServices.DataTypes.ClusterizableElement;

/*
 * T es o bien ClusterizableProject o ClusterizableSutdent
 * */ 
public class DBSCANClusterServiceImpl<T extends Clusterizable> implements CluserService<T>
{
	@Override
	public Boolean clusterize(List<T>toCluster, List<ClusterizableElement<T>>[]clusters) {
		List<ClusterizableElement<T>> clusterizableList = null;
		
		clusterizableList = parseInputIntoClusterizableElement(toCluster);
		clusters = clusteringAlgorithm( clusterizableList );
		
		return  true;
	}
	

	private List<ClusterizableElement<T>> parseInputIntoClusterizableElement(Collection<T>toParse){
		List<ClusterizableElement<T>> toReturn = new ArrayList<>();
		
		for(T element : toParse){
			toReturn.add( new ClusterizableElement<T>(element));
		}
		
		return toReturn;
	}
	
	
	private List<ClusterizableElement<T>>[] clusteringAlgorithm( List<ClusterizableElement<T>> clusterizableList){
		return null;
	}
}
