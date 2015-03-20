package uk.ac.brunel.sr2calculator.module;

import uk.ac.brunel.sr2calculator.awards.Award;
import uk.ac.brunel.sr2calculator.awards.AwardFactory;


public class CheckResults {

	public static void main(String[] args) throws Exception {
		StudentProfile profile = new StudentProfile();
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2001_CB"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2002_CN"), new GradePoint("D")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2003_CN"), new GradePoint("C")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2004_CN"), new GradePoint("C")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2005_CN"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2555"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3002_CE"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3003_CN"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3004_CB"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3004_CB"), new GradePoint("A")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3072_CB"), new GradePoint("A")));	
		
		System.out.println("L2 Weighted GPA: " + profile.calculateLevelWeightedGPA(2));
		System.out.println("L3 Weighted GPA: " + profile.calculateLevelWeightedGPA(2));
		
		for (Award award : AwardFactory.getInstance().getAwards()) {
			System.out.println("Credit Volume at least at " + award.getName() + "=" + profile.calculateOverallVolumeForClassification(award));
		}		

		System.out.println("Overall Weighted GPA: " + profile.calculateLevelSR2WeightedGPA());
		System.out.println("Classification: " + profile.calculateClassification(true));
	}

}
