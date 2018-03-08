package sample.data;

public class Level3 {
	private Float id;
	private String fullname;
	
	public Level3() {
	}
	
	public Level3(Float id, String fullname) {
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
		return "Level3 [id=" + id + ", fullname=" + fullname + "]";
	}
	
}