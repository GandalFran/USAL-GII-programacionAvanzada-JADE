package ClusterServices.DataTypes;

/*
 * En nuestro caso T es Projec o Student y E es int
 * */
public class ClusterizableElement <E extends Clusterizable>
{
	private int id;
	private Integer[] clusterParameters;
	
	public ClusterizableElement(E element) {
		this.id = element.getId();
		this.clusterParameters =(Integer[]) element.getClusterParametersArray().clone();
	}

	public Integer[] getClusterParameters() {
		return clusterParameters;
	}
	
	public int getId() {
		return id;
	}
	
}
