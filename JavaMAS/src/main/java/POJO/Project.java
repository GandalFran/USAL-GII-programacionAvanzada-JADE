package POJO;

import java.util.ArrayList;
import java.util.List;
import controller.Clusterizable;


public class Project implements Clusterizable{
	private int id;
	private String name;
	private List<Skill> neededSkills;
	
	public Project() {
		this.setNeededSkills(new ArrayList<>());
	}
	
	public Project(int id, String name,List<Skill> neededSkills) {
		this.setId(id);
		this.setName(name);
		this.setNeededSkills(neededSkills);
	}
	
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", neededSkills=" + neededSkills + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((neededSkills == null) ? 0 : neededSkills.hashCode());
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
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (neededSkills == null) {
			if (other.neededSkills != null)
				return false;
		} else if (!neededSkills.equals(other.neededSkills))
			return false;
		return true;
	}

	public List<Skill> getNeededSkills() {
		return neededSkills;
	}

	public void setNeededSkills(List<Skill> neededSkills) {
		this.neededSkills = neededSkills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Integer[] getClusterParametersArray() {
		int i = 0;
		Integer[] toReturn = new Integer[this.neededSkills.size()];
		
		for(Skill s : this.neededSkills){
			toReturn[i++] = s.getLevel();
		}
		
		return toReturn;
	}
	
}
