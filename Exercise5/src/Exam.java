import java.util.ArrayList;

public class Exam {
	
	private int maxValue = 60;
	
	private ArrayList<Student> students = new ArrayList<>(); //many-to-many association
	private Course course; //-course
	
	//composition has-a relationship
	private ArrayList <Question> questions;; 
	
	/*
	 * @requires questions != null
	 */
	public Exam(Course course, ArrayList<Question> questions) { //composition 
		this.questions = questions; //min. one Question... infinite
		this.course = course; //exactly one course
	}
	
	public Boolean register(Student student){
		if(students.contains(student)) {
			return false;
		}
		else {
			students.add(student);
			student.addExam(this);
			return true;
		}
	}
	
	public void addQuestion(int id, String task, int value) {
		questions.add(new Question(id,task,value)); //composition, question does not exist alone
	}
	
	public ArrayList<Student> getRegisteredStudents() {
		return students;
	}
	
	public void setMaxValue(int max) {
		this.maxValue=max;
	}
}
