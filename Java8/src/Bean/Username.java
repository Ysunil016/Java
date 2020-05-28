package Bean;

public class Username {

	private String username;

	public String getUsername() {

		// Validate for XSS Attack
		// Validate for Username Input

		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
