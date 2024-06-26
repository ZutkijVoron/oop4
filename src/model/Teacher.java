package model;

/**
 * Teacher
 */
public class Teacher extends User {
	private int teacherId;

	public Teacher(String firstName, String lastName, String secondName, int teacherId) {
		super(firstName, lastName, secondName);
		this.teacherId = teacherId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getSecondName() + "\nteacher ID: " + getTeacherId();
	}
}
