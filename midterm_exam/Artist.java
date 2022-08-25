package midterm_exam;

public class Artist {
	private String name;
	private int age;
	
	public Artist() {
		name = "Unknown";
		age = 0;
	}
	
	public Artist(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
