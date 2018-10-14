package controller;

import java.util.List;

import org.apache.commons.math3.ml.clustering.Clusterable;

public interface ClusterizationController<E extends Clusterable,C> {
	boolean clusterize(List<E>toCluster, List<C>clusters );
}
