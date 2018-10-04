package ClusterServices.ClusterizablePOJO;

import ClusterServices.DataTypes.Clusterizable;
import POJO.Project;
import POJO.Skill;

public class ClusterizableProject extends Project implements Clusterizable{
	
	@Override
	public Integer[] getClusterParametersArray() {
		int i = 0;
		Integer[]toReturn = new Integer[ this.getNeededSkills().size()];
		
		i = 0; 
		for(Skill s : this.getNeededSkills()) {
			toReturn[i++] = s.getLevel();
		}
		
		return toReturn;
	}

}