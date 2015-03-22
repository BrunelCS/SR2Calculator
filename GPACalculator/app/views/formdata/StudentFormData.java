package views.formdata;

import models.Grade;
import play.data.validation.ValidationError;
import uk.ac.brunel.sr2calculator.awards.Award;
import uk.ac.brunel.sr2calculator.awards.AwardFactory;
import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.ModuleFactory;
import uk.ac.brunel.sr2calculator.module.ModuleResult;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

import java.util.ArrayList;
import java.util.List;

public class StudentFormData {

    //Level 2 Grades
    public String CS2001Grade = "";
    public String CS2002Grade = "";
    public String CS2003Grade = "";
    public String CS2004Grade = "";
    public String CS2005Grade = "";
    
    //Placement
    public String CS2555Grade = "";
    
    //Level 3 Grades
    public String CS3072Grade = "";
    public String CS3001Grade = "";
    public String CS3100Grade = "";
    public String CS3002Grade = "";
    public String CS3003Grade = "";
    
    //Results
    public String level2GPA = "";
    public String level3GPA = "";
    public String overallGPA = "";
    public String classification = "";
    public String gradeVolume1 = "";
    public String gradeVolume2 = "";
    public String gradeVolume3 = "";
    public String gradeVolume4 = "";
    public String gradeVolume5 = "";


  /** Required for form instantiation. */
  public StudentFormData() {}

    /**
    * Creates an initialized form instance. Assumes the passed data is valid. 
    */
    public StudentFormData (Grade CS2001Grade, Grade CS2002Grade, Grade CS2003Grade, Grade CS2004Grade, Grade CS2005Grade, Grade CS2555Grade, 
                                Grade CS3072Grade, Grade CS3001Grade, Grade CS3100Grade, Grade CS3002Grade, Grade CS3003Grade) {
                  
        //Level 2 Grades
        this.CS2001Grade = CS2001Grade.getName();
        this.CS2002Grade = CS2002Grade.getName();
        this.CS2003Grade = CS2003Grade.getName();
        this.CS2004Grade = CS2004Grade.getName();
        this.CS2005Grade = CS2005Grade.getName();
        
        //Placement
        this.CS2555Grade = CS2555Grade.getName();
        
        //Level 3 Grades
        this.CS3072Grade = CS3072Grade.getName();
        this.CS3001Grade = CS3001Grade.getName();
        this.CS3100Grade = CS3100Grade.getName();
        this.CS3002Grade = CS3002Grade.getName();
        this.CS3003Grade = CS3003Grade.getName();
        
        createStudentProfile();
    }
    
    
    
     public void createStudentProfile(){
		StudentProfile profile = new StudentProfile();
		
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2001_CB"), new GradePoint(CS2001Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2002_CN"),new GradePoint(CS2002Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2003_CN"), new GradePoint(CS2003Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2004_CN"), new GradePoint(CS2004Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2005_CN"), new GradePoint(CS2005Grade)));
		
		
		if(CS2555Grade != "")
		    profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2555"), new GradePoint(CS2555Grade)));
		
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3072_CB"), new GradePoint(CS3072Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3001_CE"), new GradePoint(CS3001Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3100_CN"), new GradePoint(CS3100Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3002_CE"), new GradePoint(CS3002Grade)));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3003_CN"), new GradePoint(CS3003Grade)));	
		
		
	    level2GPA = "L2 Weighted GPA: " + profile.calculateLevelWeightedGPA(2);
	    level3GPA = "L3 Weighted GPA: " + profile.calculateLevelWeightedGPA(3);
	    overallGPA = "Overall Weighted GPA: " + profile.calculateLevelSR2WeightedGPA();
	    classification = "Classification: " + profile.calculateClassification(true).getName();
	    
	    List<Award> awards = AwardFactory.getInstance().getAwards();    

		gradeVolume1 = "Credit Volume at least at " + awards.get(0).getName() + " = " + profile.calculateOverallVolumeForClassification(awards.get(0));
		gradeVolume2 = "Credit Volume at least at " + awards.get(1).getName() + " = " + profile.calculateOverallVolumeForClassification(awards.get(1));
		gradeVolume3 = "Credit Volume at least at " + awards.get(2).getName() + " = " + profile.calculateOverallVolumeForClassification(awards.get(2));
		gradeVolume4 = "Credit Volume at least at " + awards.get(3).getName() + " = " + profile.calculateOverallVolumeForClassification(awards.get(3));
		gradeVolume5 = "Credit Volume at least at " + awards.get(4).getName() + " = " + profile.calculateOverallVolumeForClassification(awards.get(4));
		
  }
  
   

  /**
   * Validates Form<StudentFormData>.
   * Called automatically in the controller by bindFromRequest().
   * 
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    //Level 2
    if (CS2001Grade == null) {
      errors.add(new ValidationError("CS2001Grade", "No grade was given."));
    }
    if (CS2002Grade == null) {
      errors.add(new ValidationError("CS2002Grade", "No grade was given."));
    }
    if (CS2003Grade == null) {
      errors.add(new ValidationError("CS2003Grade", "No grade was given."));
    }
    if (CS2004Grade == null) {
      errors.add(new ValidationError("CS2004Grade", "No grade was given."));
    }
    if (CS2005Grade == null) {
      errors.add(new ValidationError("CS2005Grade", "No grade was given."));
    }
    
    //Level 3
    if (CS3072Grade == null) {
      errors.add(new ValidationError("CS3072Grade", "No grade was given."));
    }
    if (CS3001Grade == null) {
      errors.add(new ValidationError("CS3001Grade", "No grade was given."));
    }
    if (CS3100Grade == null) {
      errors.add(new ValidationError("CS3100Grade", "No grade was given."));
    }
    if (CS3002Grade == null) {
      errors.add(new ValidationError("CS3002Grade", "No grade was given."));
    }
    if (CS3003Grade == null) {
      errors.add(new ValidationError("CS3003Grade", "No grade was given."));
    }


    if(errors.size() > 0)
      return errors;

    return null;
  }
}
