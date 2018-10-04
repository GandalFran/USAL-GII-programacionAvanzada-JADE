package ClusterServices;

import java.util.List;

import ClusterServices.DataTypes.Clusterizable;
import ClusterServices.DataTypes.ClusterizableElement;

public interface CluserService<T extends Clusterizable>{
	Boolean clusterize(List<T>toCluster, List<ClusterizableElement<T>>[]clusters);
}
