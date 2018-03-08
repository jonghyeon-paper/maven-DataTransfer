package data.transfer.json.sample;

import java.util.List;

public class Object1 {
	
	private String id;
	private String name;
	private Object2 object2;
	private List<Object4> object4;
	
	public Object1() {
	}
	
	public Object1(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object2 getObject2() {
		return object2;
	}
	public void setObject2(Object2 object2) {
		this.object2 = object2;
	}
	public List<Object4> getObject4() {
		return object4;
	}
	public void setObject4(List<Object4> object4) {
		this.object4 = object4;
	}
	
	@Override
	public String toString() {
		return "Object1 [id=" + id + ", name=" + name + ", object2=" + object2 + ", object4=" + object4 + "]";
	}
}