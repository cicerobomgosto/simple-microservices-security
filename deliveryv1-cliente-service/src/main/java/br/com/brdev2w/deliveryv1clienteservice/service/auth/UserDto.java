package br.com.brdev2w.deliveryv1clienteservice.service.auth;


public class UserDto {

	private String username;
	private String password;

	public UserDto(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
