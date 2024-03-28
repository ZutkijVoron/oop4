package view;

import model.User;

public abstract class UserView {
	public void printConsole(User user) {
		System.out.println(user);
	}
}
