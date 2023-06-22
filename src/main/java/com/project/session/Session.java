package com.project.session;

public class Session {
	
	private int _userId;
	private String _email;
	private String _password;
	private String _role;
	
	
	private static Session session;
	
	static {
		session = new Session();
	}
	
	public static Session getSession() {
		return session;
	}
//	public Session() {
//
//	}
//
//	public Session(int userId, String email, String password, String role) {
//
//		this.userId = userId;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	@Override
	public String toString() {
		return "Session [userId=" + _userId + ", email=" + _email + ", password=" + _password + ", role=" + _role + "]";
	}
}