package uk.ac.brunel.sr2calculator;

import uk.ac.brunel.sr2calculator.awards.Award;
import uk.ac.brunel.sr2calculator.awards.AwardFactory;
import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.ModuleFactory;
import uk.ac.brunel.sr2calculator.module.ModuleResult;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

/**
 * This is an example of using the classifer programmatically to work out a classification from a grade profile 
 * @author simon.kent@brunel.ac.uk
 *
 */
public class CheckResults {

	public static void main(String[] args) throws Exception {
		// Create a student profile and add some modules and grades
		StudentProfile profile = new StudentProfile();
		
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2001_CB"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2002_CN"),new GradePoint("D")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2003_CN"), new GradePoint("C")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2004_CN"), new GradePoint("C")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2005_CN"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2555"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3002_CE"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3003_CN"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3004_CB"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3004_CB"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3072_CB"), new GradePoint("A")));	
		
		// Print some information calculated from the profile
		System.out.println("L2 Weighted GPA: " + profile.calculateLevelWeightedGPA(2));
		System.out.println("L3 Weighted GPA: " + profile.calculateLevelWeightedGPA(3));
		
		// Print some logging about awards
		for (Award award : AwardFactory.getInstance().getAwards()) {
			System.out.println("Credit Volume at least at " + award.getName() + "=" + profile.calculateOverallVolumeForClassification(award));
		}		

		System.out.println("Overall Weighted GPA: " + profile.calculateLevelSR2WeightedGPA());
		System.out.println("Classification: " + profile.calculateClassification(true));
	}

}
