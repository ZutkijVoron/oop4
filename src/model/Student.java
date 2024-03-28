package model;

/**
 * Student
 */
public class Student extends User {
	private int studentId;

	public Student(String firstName, String lastName, String secondName, int studentId) {
		super(firstName, lastName, secondName);
		this.studentId = studentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getSecondName() + "\nstudent ID: " + getStudentId();
	}
}
