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
		int numStudentsPerTeacher = students.size() / teachers.size();

		for (int i = 0; i < teachers.size(); i++) {
			System.out.println(teachers.get(i));
			int startIndex = i * numStudentsPerTeacher;
			int endIndex = (i + 1) * numStudentsPerTeacher;
			if (i == teachers.size() - 1) { // If it's the last teacher, include remaining students
				endIndex = students.size();
			}
			for (int j = startIndex; j < endIndex; j++) {
				System.out.println(students.get(j));
			}
		}
	}

	public void createTrainingGroup() {
		List<User> students = dataService.getAllStudent();
		List<User> teachers = dataService.getAllTeacher();
		int numStudentsPerTeacher = students.size() / teachers.size();
		for (int i = 0; i < teachers.size(); i++) {
			TrainingGroup tg = trainingGroupService.create(((Teacher) teachers.get(i)), new ArrayList<Student>());
			int startIndex = i * numStudentsPerTeacher;
			int endIndex = (i + 1) * numStudentsPerTeacher;
			if (i == teachers.size() - 1) { // If it's the last teacher, include remaining students
				endIndex = students.size();
			}
			for (int j = startIndex; j < endIndex; j++) {
				tg.addStudent(((Student) students.get(j)));
			}
		}
	}
}
