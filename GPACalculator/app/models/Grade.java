package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import views.formdata.StudentFormData;

/**
 * This class includes:
 * <ul>
 * <li> The model structure (fields, plus getters and setters).
 * <li> Some methods to facilitate form display and manipulation (makeGPAMap, etc.).
 * <li> Some fields and methods to "fake" a database of GPAs.
 * </ul>
 */
public class Grade {
  private long id;
  private String name;

  public Grade(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  /**
   * Create a map of GPA name -> boolean where the boolean is true if the Grade corresponds to the student.
   */
  public static Map<String, Boolean> makeGPAMap1(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS2001Grade != null && student.CS2001Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }

  public static Map<String, Boolean> makeGPAMap2(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS2002Grade != null && student.CS2002Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
  public static Map<String, Boolean> makeGPAMap3(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS2003Grade != null && student.CS2003Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }

  public static Map<String, Boolean> makeGPAMap4(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS2004Grade != null && student.CS2004Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
   public static Map<String, Boolean> makeGPAMap5(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS2005Grade != null && student.CS2005Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
  public static Map<String, Boolean> makeGPAMap6(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS2555Grade != null && student.CS2555Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
  public static Map<String, Boolean> makeGPAMap7(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS3072Grade != null && student.CS3072Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
  public static Map<String, Boolean> makeGPAMap8(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS3001Grade != null && student.CS3001Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
  public static Map<String, Boolean> makeGPAMap9(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS3100Grade != null && student.CS3100Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
  public static Map<String, Boolean> makeGPAMap10(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS3002Grade != null && student.CS3002Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  
  public static Map<String, Boolean> makeGPAMap11(StudentFormData student) {
    Map<String, Boolean> gpaMap = new TreeMap<String, Boolean>();
    for (Grade gpa : allGrades) {
      gpaMap.put(gpa.getName(),  (student == null) ? false : (student.CS3003Grade != null && student.CS3003Grade.equals(gpa.getName())) );
    }
    return gpaMap;
  }
  


  /**
   * Return the GPA instance in the database with name 'gpa' or null if not found.
   */
  public static Grade findGPA(String gpaName) {
    for (Grade gpa : allGrades) {
      if (gpaName.equals(gpa.getName())) {
        return gpa;
      }
    }
    return null;
  }

  /**
   * Define a default Grade, used for form display.
   */
  public static Grade getDefaultGPA() {
    return findGPA("A");
  }

  @Override
  public String toString() {
    return String.format("[Grade %s]", this.name);
  }

  private static List<Grade> allGrades = new ArrayList<>();

  /** Instantiate the fake database of GPAs. */
  static {
      
		allGrades.add(new Grade(1, "F"));
		allGrades.add(new Grade(2, "E-"));
		allGrades.add(new Grade(3, "E"));
		allGrades.add(new Grade(4, "E+"));
		allGrades.add(new Grade(5, "D-"));
		allGrades.add(new Grade(6, "D"));
		allGrades.add(new Grade(7, "D+"));
		allGrades.add(new Grade(8, "C-"));
		allGrades.add(new Grade(9, "C"));
		allGrades.add(new Grade(10, "C+"));
		allGrades.add(new Grade(11, "B-"));
		allGrades.add(new Grade(12, "B"));
		allGrades.add(new Grade(13, "B+"));
		allGrades.add(new Grade(14, "A-"));
		allGrades.add(new Grade(15, "A"));
		allGrades.add(new Grade(16, "A+"));
		allGrades.add(new Grade(17, "A*"));

  }


}
