package controller;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.Teacher;
import model.TrainingGroup;
import model.Type;
import model.User;
import service.DataService;
import service.TrainingGroupService;
import view.StudentView;

public class Controller {
	private final DataService dataService = new DataService();
	private final TrainingGroupService trainingGroupService = new TrainingGroupService();
	private final StudentView studentView = new StudentView();

	public void createStudent(String firstName, String lastName, String secondName) {
		dataService.create(firstName, lastName, secondName, Type.STUDENT);
	}

	public void createTeacher(String firstName, String lastName, String secondName) {
		dataService.create(firstName, lastName, secondName, Type.TEACHER);
	}

	public void getAllStudent() {
		List<User> users = dataService.getAllStudent();
		for (User user : users) {
			studentView.printConsole(user);
		}
	}

	public void getTrainingGroups() {
		List<User> students = dataService.getAllStudent();
		List<User> teachers = dataService.getAllTeacher();
		for (int i = 0; i < teachers.size(); i++) {
			System.out.println(teachers.get(i));
			for (int j = students.size() / teachers.size() * i; j < students.size() / teachers.size(); j++) {
				System.out.println(students.get(j));
			}
		}
	}

	public void createTrainingGroup() {
		List<User> students = dataService.getAllStudent();
		List<User> teachers = dataService.getAllTeacher();
		for (int i = 0; i < teachers.size(); i++) {
			TrainingGroup tg = trainingGroupService.create(((Teacher) teachers.get(i)), new ArrayList<Student>());
			for (int j = students.size() / teachers.size() * i; j < students.size() / teachers.size(); j++) {
				tg.addStudent(((Student) students.get(j)));
			}
		}
	}
}
