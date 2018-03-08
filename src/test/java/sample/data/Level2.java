package sample.data;

public class Level2 {
	private Integer id;
	private String name;
	
	public Level2() {
	}
	
	public Level2(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Level2 [id=" + id + ", name=" + name + "]";
	}
	
}
