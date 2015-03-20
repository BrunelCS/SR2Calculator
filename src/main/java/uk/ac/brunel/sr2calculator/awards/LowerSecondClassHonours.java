package uk.ac.brunel.sr2calculator.awards;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class LowerSecondClassHonours extends AbstractAward {

	LowerSecondClassHonours() {
		super();
	}

	@Override
	public String getName() {
		return "Lower Second Class Honours";
	}

	@Override
	protected boolean eligibleForClassification(StudentProfile profile) {
		double gpa = profile.calculateLevelSR2WeightedGPA();
		double volume = profile.calculateOverallVolumeForClassification(this);
		
		// fail fast
		if (volume<0.33) {
			return false;
		}
		
		if (volume>=0.33 && gpa >=8.5) {
			return true;
		}
		
		if (volume>=0.41 && gpa >=7.5) {
			return true;
		}
		
		if (volume>=0.50 && gpa >=6.5) {
			return true;
		}
		
		if (volume>=0.58 && gpa >=5.5) {
			return true;
		}
		
		if (volume>=0.66 && gpa >=4.5) {
			return true;
		}
		
		return false;
	}

	@Override
	protected boolean hasLowEnoughEGrade(StudentProfile profile) {
		// Max 40 credits @ L2, 20 credits @ L3, 40 credits in total
		int l2volume = profile.calculateVolumeForGradePointsAtLevels(E_GRADES, new int[]{2});
	    int l3volume = profile.calculateVolumeForGradePointsAtLevels(E_GRADES, new int[]{3});
	    if (l2volume>40 || l3volume>20 || l2volume+l3volume>40) {
			return false;
		}
		return true;
	}

	@Override
	public GradePoint getMinimumGradePoint() {
		return new GradePoint("C-");
	}

}
