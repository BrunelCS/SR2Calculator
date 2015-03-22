package uk.ac.brunel.sr2calculator.awards;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class UpperSecondClassHonours extends AbstractAward {

	UpperSecondClassHonours() {
		super();
	}

	@Override
	public String getName() {
		return "Upper Second Class Honours";
	}

	@Override
	protected boolean meetsBorderlineCriteria(StudentProfile profile) {
		double gpa = profile.calculateLevelSR2WeightedGPA();
		double volume = profile.calculateOverallVolumeForClassification(this);
		
		// fail fast
		if (volume<0.41) {
			return false;
		}
		
		if (volume>=0.41 && gpa >=10.5) {
			return true;
		}
		
		if (volume>=0.45 && gpa >=10.0) {
			return true;
		}
		
		if (volume>=0.50 && gpa >=9.5) {
			return true;
		}
		
		if (volume>=0.54 && gpa >=9.0) {
			return true;
		}
		
		if (volume>=0.58 && gpa >=8.5) {
			return true;
		}
		
		return false;
	}

	@Override
	protected boolean meetsMinimumGPA(StudentProfile profile) {
		return profile.calculateLevelSR2WeightedGPA() >= 11;
	}
	
	@Override
	protected boolean hasLowEnoughEGrade(StudentProfile profile) {
		// Max 20 credits @ L2, 0 credits @ L3
		int l2volume = profile.calculateVolumeForGradePointsAtLevels(E_GRADES, new int[]{2});
	    int l3volume = profile.calculateVolumeForGradePointsAtLevels(E_GRADES, new int[]{3});
	    if (l2volume>20 || l3volume>0) {
			return false;
		}
		return true;
	}

	@Override
	public GradePoint getMinimumGradePoint() {
		return new GradePoint("B-");
	}

}
