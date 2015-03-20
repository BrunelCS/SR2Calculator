package uk.ac.brunel.sr2calculator.awards;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class ThirdClassHonours extends AbstractAward {

	ThirdClassHonours() {
		super();
	}

	@Override
	public String getName() {
		return "Third Class Honours";
	}

	@Override
	protected boolean eligibleForClassification(StudentProfile profile) {
		double gpa = profile.calculateLevelSR2WeightedGPA();
		double volume = profile.calculateOverallVolumeForClassification(this);
		
		// fail fast
		if (volume<0.72) {
			return false;
		}
		
		if (volume>=0.72 && gpa >=3.3) {
			return true;
		}
		
		return false;
	}

	@Override
	protected boolean hasLowEnoughEGrade(StudentProfile profile) {
		// Max 40 credits @ L2, 40 credits @ L3, 60 credits in total
		int l2volume = profile.calculateVolumeForGradePointsAtLevels(E_GRADES, new int[]{2});
	    int l3volume = profile.calculateVolumeForGradePointsAtLevels(E_GRADES, new int[]{3});
	    if (l2volume>40 || l3volume>40 || l2volume+l3volume>60) {
			return false;
		}
		return true;
	}

	@Override
	public GradePoint getMinimumGradePoint() {
		return new GradePoint("D-");
	}

}
