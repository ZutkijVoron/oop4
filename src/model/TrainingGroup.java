package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingGroup {
	private Teacher teacher;
	private List<Student> students;

	public TrainingGroup(Teacher teacher, List<Student> students) {
		this.teacher = teacher;
		this.students = students;
	}

	public TrainingGroup(Teacher teacher) {
		this(teacher, new ArrayList<Student>());
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	@Override
	public String toString() {
		return "teacher:\n" + getTeacher() + "\nStudent:\n" + getStudents();
	}

}
