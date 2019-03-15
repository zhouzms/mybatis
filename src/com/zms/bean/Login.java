package com.zms.bean;

public class Login {
	private int id_login;//µÇÂ¼±íid
	private String username_login;
	private String password_login;
	public int getId_login() {
		return id_login;
	}
	public void setId_login(int id_login) {
		this.id_login = id_login;
	}
	public String getUsername_login() {
		return username_login;
	}
	public void setUsername_login(String username_login) {
		this.username_login = username_login;
	}
	@Override
	public String toString() {
		return "Login [id_login=" + id_login + ", username_login=" + username_login + ", password_login="
				+ password_login + "]";
	}
	public String getPassword_login() {
		return password_login;
	}
	public void setPassword_login(String password_login) {
		this.password_login = password_login;
	}
}
