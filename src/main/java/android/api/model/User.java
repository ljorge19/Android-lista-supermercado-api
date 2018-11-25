package android.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class User {

	@Id
    public String id;
    @Indexed(unique=true)
    private String login;
	private String name;
	private String password;
	
	public User() {
		super();
	}
	public User(String login, String name, String password) {
		super();
		this.login = login;
		this.name = name;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", name=" + name + ", password=" + password + "]";
		//return "User [login=" + login + ", name=" + name + ", password=" + password + "]";
	}
	
}
