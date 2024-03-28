import controller.Controller;

/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		Controller ctr = new Controller();
		ctr.createStudent("1", "1", "1");
		ctr.createStudent("12", "2", "22");
		ctr.createStudent("1]", "1e", "1e");
		ctr.createStudent("1q", "1q", "1q");
		ctr.createStudent("1q", "1q", "1q");
		ctr.createStudent("1q", "1q", "1q");
		ctr.createTeacher(null, null, null);
		ctr.createTeacher("a", "1", "1");
		ctr.createTrainingGroup();
		ctr.getTrainingGroups();
	}
}
