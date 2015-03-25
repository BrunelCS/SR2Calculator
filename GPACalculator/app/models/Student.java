package models;

import java.util.ArrayList;
import java.util.List;

import views.formdata.StudentFormData;

/**
 * This class includes:
 * <ul>
 * <li> The model structure (fields, plus getters and setters).
 * <li> Methods to facilitate form display (makeStudentFormData).
 * <li> Some fields and methods to "fake" a database of Students, including valid and invalid.
 * </ul> 
 */
public class Student {

	private long id;
	
	//Level 2 Grades
	public Grade CS2001Grade;
	public Grade CS2002Grade;
	public Grade CS2003Grade;
	public Grade CS2004Grade;
	public Grade CS2005Grade;

	//Placement
	public Grade CS2555Grade;

	//Level 3 Grades
	public Grade CS3072Grade;
	public Grade CS3001Grade;
	public Grade CS3100Grade;
	public Grade CS3002Grade;
	public Grade CS3003Grade;

	public Student() {
	}

	public Student(long id, Grade CS2001Grade, Grade CS2002Grade, Grade CS2003Grade, Grade CS2004Grade, Grade CS2005Grade, Grade CS2555Grade, 
			Grade CS3072Grade, Grade CS3001Grade, Grade CS3100Grade, Grade CS3002Grade, Grade CS3003Grade) {
		this.setId(id);
		//Level 2 Grades
		this.CS2001Grade = CS2001Grade;
		this.CS2002Grade = CS2002Grade;
		this.CS2003Grade = CS2003Grade;
		this.CS2004Grade = CS2004Grade;
		this.CS2005Grade = CS2005Grade;

		//Placement
		this.CS2555Grade = CS2555Grade;

		//Level 3 Grades
		this.CS3072Grade = CS3072Grade;
		this.CS3001Grade = CS3001Grade;
		this.CS3100Grade = CS3100Grade;
		this.CS3002Grade = CS3002Grade;
		this.CS3003Grade = CS3003Grade;
	}

	public String toString() {
		return String.format("[CS2001Grade: '%s' CS2002Grade: '%s' CS2003Grade: %s CS2004Grade: %s CS2005Grade: %s CS2555Grade: %s "
				+ "CS3072Grade: %s CS3001Grade: %s CS3100Grade: %s CS3002Grade: %s CS3003Grade: %s]",  
				this.CS2001Grade, this.CS2002Grade, this.CS2003Grade, this.CS2004Grade, this.CS2005Grade, this.CS2555Grade, 
				this.CS3072Grade, this.CS3001Grade, this.CS3100Grade, this.CS3002Grade, this.CS3003Grade);
	}

	private long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}


	public Grade getCS2001Grade() {
		return CS2001Grade;
	}

	public void setCS2001Grade(Grade CS2001Grade) {
		this.CS2001Grade = CS2001Grade;
	}

	public Grade getCS2002Grade() {
		return CS2002Grade;
	}

	public void setCS2002Grade(Grade CS2002Grade) {
		this.CS2002Grade = CS2002Grade;
	}

	public Grade getCS2003Grade() {
		return CS2003Grade;
	}

	public void getCS2003Grade(Grade CS2003Grade) {
		this.CS2003Grade = CS2003Grade;
	}

	public Grade getCS2004Grade() {
		return CS2004Grade;
	}

	public void setCS2004Grade(Grade CS2004Grade) {
		this.CS2004Grade = CS2004Grade;
	}

	public Grade getCS2005Grade() {
		return CS2005Grade;
	}

	public void setCS2005Grade(Grade CS2005Grade) {
		this.CS2005Grade = CS2005Grade;
	}

	public Grade getCS2555Grade() {
		return CS2555Grade;
	}

	public void setCS2555Grade(Grade CS2555Grade) {
		this.CS2555Grade = CS2555Grade;
	}
	

	public Grade getCS3072Grade() {
		return CS3072Grade;
	}

	public void setCS3072Grade(Grade CS3072Grade) {
		this.CS3072Grade = CS3072Grade;
	}

	public Grade getCS3001Grade() {
		return CS3001Grade;
	}

	public void setCS3001Grade(Grade CS3001Grade) {
		this.CS3001Grade = CS3001Grade;
	}

	public Grade getCS3100Grade() {
		return CS2001Grade;
	}

	public void setCS3100Grade(Grade CS2001Grade) {
		this.CS2001Grade = CS2001Grade;
	}

	public Grade getCS3002Grade() {
		return CS2001Grade;
	}

	public void setCS3002Grade(Grade CS2001Grade) {
		this.CS2001Grade = CS2001Grade;
	}

	public Grade getCS3003Grade() {
		return CS2001Grade;
	}

	public void setCS3003Grade(Grade CS2001Grade) {
		this.CS2001Grade = CS2001Grade;
	}


	/**
	 * Return a StudentFormData instance constructed from a student instance.
	 */
	public static StudentFormData makeStudentFormData(long id) {
		for (Student student : allStudents) {
			if (student.getId() == id) {
				return new StudentFormData(student.CS2001Grade, student.CS2002Grade, student.CS2003Grade, student.CS2004Grade, student.CS2005Grade, student.CS2555Grade,
						student.CS3072Grade, student.CS3001Grade, student.CS3100Grade, student.CS3002Grade, student.CS3003Grade);
			}
		}
		throw new RuntimeException("Couldn't find student");
	}


	/**
	 * Returns a Student instance created from the form data.
	 */
	public static Student makeInstance(StudentFormData formData) {
		Student student = new Student();
		
		student.CS2001Grade = Grade.findGPA(formData.CS2001Grade);
		student.CS2002Grade = Grade.findGPA(formData.CS2002Grade);
		student.CS2003Grade = Grade.findGPA(formData.CS2003Grade);
		student.CS2004Grade = Grade.findGPA(formData.CS2004Grade);
		student.CS2005Grade = Grade.findGPA(formData.CS2005Grade);

		student.CS2555Grade = Grade.findGPA(formData.CS2555Grade);

		student.CS3072Grade = Grade.findGPA(formData.CS3072Grade);
		student.CS3001Grade = Grade.findGPA(formData.CS3001Grade);
		student.CS3100Grade = Grade.findGPA(formData.CS3100Grade);
		student.CS3002Grade = Grade.findGPA(formData.CS3002Grade);
		student.CS3003Grade = Grade.findGPA(formData.CS3003Grade);

		return student;
	}

	/** Fake a database of students. */
	private static List<Student> allStudents = new ArrayList<>();

  static {
	    // Valid student. No optional data supplied.
	    allStudents.add(new Student(1, Grade.findGPA("A"), Grade.findGPA("B"), Grade.findGPA("A"), Grade.findGPA("D"), Grade.findGPA("C+"), Grade.findGPA("B-"), 
	    									Grade.findGPA("A-"), Grade.findGPA("B-"), Grade.findGPA("C+"), Grade.findGPA("A*"), Grade.findGPA("D")));
	  }
	
	/**
	 * Find a student instance given the ID.
	 */
	public static Student getById(long id) {
		for (Student student : allStudents) {
			if (student.getId() == id) {
				return student;
			}
		}
		throw new RuntimeException("Couldn't find student");
	}

}
