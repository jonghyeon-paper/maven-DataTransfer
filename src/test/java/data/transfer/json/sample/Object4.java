package data.transfer.json.sample;

public class Object4 {
	
	private String name1;
	private String name2;
	private int birthday;
	private String gender;
	
	public Object4() {
	}
	
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Object4 [name1=" + name1 + ", name2=" + name2 + ", birthday=" + birthday + ", gender=" + gender + "]";
	}
}