package controller;

import java.util.List;
import java.util.Map;

import POJO.StudentCluster;

public interface MappingController<T,E> {
	boolean doMapping(List<StudentCluster>studentClusterList, List<T> elementList, Map<StudentCluster,E> toFill);
}
