package week4_session_login.model;

public class Admin {
	private String name, pass;
	private int role;
	public Admin() {
		
	}
	public Admin(String name, String pass, int role) {
		super();
		this.name = name;
		this.pass = pass;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
}
