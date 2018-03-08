package data.transfer.json.sample;

public class Object3 {
	
	private Float id;
	private String fullname;
	
	public Object3() {
	}
	
	public Object3(Float id, String fullname) {
		this.id = id;
		this.fullname = fullname;
	}
	
	public Float getId() {
		return id;
	}
	public void setId(Float id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	@Override
	public String toString() {
		return "Object3 [id=" + id + ", fullname=" + fullname + "]";
	}
}