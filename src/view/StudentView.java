package view;

import model.Student;
import model.User;

public class StudentView extends UserView {
	@Override
	public void printConsole(User user) {
		super.printConsole(user);
		System.out.println("ID: " + ((Student) user).getStudentId());
	}
}
