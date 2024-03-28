package model;

/**
 * User
 */
public abstract class User {
	private String firstName;
	private String secondName;
	private String lastName;

	public User(String firstName, String lastName, String secondName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.secondName = secondName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getSecondName();
	}
}
