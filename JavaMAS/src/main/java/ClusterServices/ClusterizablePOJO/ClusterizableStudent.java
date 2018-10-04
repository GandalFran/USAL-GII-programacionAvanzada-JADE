package ClusterServices.ClusterizablePOJO;

import ClusterServices.DataTypes.Clusterizable;
import POJO.Skill;
import POJO.Student;

public class ClusterizableStudent extends Student implements Clusterizable{

	@Override
	public Integer[] getClusterParametersArray() {
		int i = 0;
		Integer[]toReturn = new Integer[ this.getSkills().size()];
		
		i = 0; 
		for(Skill s : this.getSkills()) {
			toReturn[i++] = s.getLevel();
		}
		
		return toReturn;
	}

}
