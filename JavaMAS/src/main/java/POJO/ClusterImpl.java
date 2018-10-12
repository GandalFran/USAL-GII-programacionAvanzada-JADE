package POJO;

import java.io.Serializable;
import java.util.List;


public class ClusterImpl implements Serializable{

	private Class<?> type;
	private List<Object> clusterElements;
	
	public ClusterImpl(Class<?> type, List<Object> clusterElements) {
		this.type = type;
		this.clusterElements = clusterElements;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clusterElements == null) ? 0 : clusterElements.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClusterImpl other = (ClusterImpl) obj;
		if (clusterElements == null) {
			if (other.clusterElements != null)
				return false;
		} else if (!clusterElements.equals(other.clusterElements))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ClusterImpl [type=" + type + ", clusterElements=" + clusterElements + "]";
	}
	public List<Object> getClusterElements() {
		return clusterElements;
	}
	public void setClusterElements(List<Object> clusterElements) {
		this.clusterElements = clusterElements;
	}
	
	public Class<?> getType() {
		return type;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
}
