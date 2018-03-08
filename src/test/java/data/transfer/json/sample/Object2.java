package data.transfer.json.sample;

public class Object2 {
	
	private Integer id;
	private String name;
	
	public Object2() {
	}
	
	public Object2(Integer id, String name) {
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
		return "Object2 [id=" + id + ", name=" + name + "]";
	}
}