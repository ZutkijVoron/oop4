package service;

import model.User;
import model.Teacher;
import model.Student;
import model.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * DataService
 */
public class DataService {
	private List<User> users = new ArrayList<>();

	public void create(String firstName, String lastName, String secondName, Type type) {
		int id = getFreeId(type);
		if (type == Type.STUDENT) {
			users.add(new Student(firstName, lastName, secondName, id));
		} else if (Type.TEACHER == type) {
			users.add(new Teacher(firstName, lastName, secondName, id));
		}
	}

	private int getFreeId(Type type) {
		boolean itStudent = type == Type.STUDENT;
		int id = 1;
		for (User user : users) {
			if (user instanceof Teacher && !itStudent) {
				id = ((Teacher) user).getTeacherId() + 1;
			} else if (user instanceof Student && itStudent) {
				id = ((Student) user).getStudentId() + 1;
			}
		}
		return id;
	}

	public List<User> getAllStudent() {
		List<User> res = new ArrayList<>();
		for (User user : users) {
			if (user instanceof Student) {
				res.add(user);
			}
		}
		return res;
	}

	public List<User> getAllTeacher() {
		List<User> res = new ArrayList<>();
		for (User user : users) {
			if (user instanceof Teacher) {
				res.add(user);
			}
		}
		return res;
	}

}
