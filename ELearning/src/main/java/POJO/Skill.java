package POJO;

public class Skill {
	private int id;
	private String name;
	private double level;
	
	public Skill(int id, String name, double level) {
		super();
		this.id = id;
		this.name = name;

		if(level > 100)
			this.level = 100;
		else if(level < 1)
			this.level = 1;
		else 
			this.level = level;
	}


	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", level=" + level + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if( null == obj)
			return false;
		
		Skill s = (Skill) obj;
		return s.level == this.level;
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
	public double getLevel() {
		return level;
	}
	public void setLevel(double level) {
		if(level > 100)
			this.level = 100;
		else if(level < 1)
			this.level = 1;
		else 
			this.level = level;
	}
	
}
