package service;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.Teacher;
import model.TrainingGroup;
import model.User;

public class TrainingGroupService extends DataService {
	public TrainingGroup create(Teacher teacher, List<Student> students) {
		TrainingGroup trainingGroup = new TrainingGroup(teacher, students);
		return trainingGroup;
	}

	public List<TrainingGroup> getAllTrainingGroup() {
		List<User> students = getAllStudent();
		List<User> teachers = getAllTeacher();
		List<TrainingGroup> tGroups = new ArrayList<>();
		for (int i = 0; i < teachers.size(); i++) {
			TrainingGroup tg = create(((Teacher) teachers.get(i)), new ArrayList<Student>());
			for (int j = students.size() / teachers.size() * i; j < students.size() / teachers.size(); j++) {
				tg.addStudent(((Student) students.get(j)));
			}
			tGroups.add(tg);
		}
		return tGroups;
	}
}
