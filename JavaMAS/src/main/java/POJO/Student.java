package POJO;

import java.util.ArrayList;
import java.util.List;

import controller.Clusterizable;


public class Student implements Clusterizable{
	private int id;
	private String name;
	private List<Skill> skills;
	
	
	public Student() {
		this.skills = new ArrayList<>();
	}
	
	public Student(int id, String name, List<Skill> skills) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", skills=" + skills + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
	@Override
	public Integer[] getClusterParametersArray() {
		int i = 0;
		Integer[] toReturn = new Integer[this.skills.size()];
		
		for(Skill s : this.skills){
			toReturn[i++] = s.getLevel();
		}
		
		return toReturn;
	}
}
