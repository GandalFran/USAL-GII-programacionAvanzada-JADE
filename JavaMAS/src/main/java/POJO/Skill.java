package POJO;


public class Skill {
	private int id;
	private String name;
	private Integer level;
	
	public Skill(int id, String name, int level) {
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
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Skill other = (Skill) obj;
		if (id != other.id)
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (name != other.name)
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level > 100)
			this.level = 100;
		else if(level < 1)
			this.level = 1;
		else 
			this.level = level;
	}
	
	
	
}
