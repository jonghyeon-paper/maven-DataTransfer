package sample.data;

import java.util.List;

public class Level1 {
	private String id;
	private String name;
	private Level2 level2;
	private List<Level3> level3List;
	
	public Level1() {
	}
	
	public Level1(String id, String name) {
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
	public Level2 getLevel2() {
		return level2;
	}
	public void setLevel2(Level2 level2) {
		this.level2 = level2;
	}
	public List<Level3> getLevel3List() {
		return level3List;
	}
	public void setLevel3List(List<Level3> level3List) {
		this.level3List = level3List;
	}

	@Override
	public String toString() {
		return "Level1 [id=" + id + ", name=" + name + ", level2=" + level2.toString() + ", level3List=" + level3List.toString() + "]";
	}
	
}
