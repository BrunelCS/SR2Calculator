package uk.ac.brunel.sr2calculator.awards;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class FirstClassHonours extends AbstractAward {

	FirstClassHonours() {
		super();
	}

	@Override
	public String getName() {
		return "First Class Honours";
	}

	@Override
	protected boolean eligibleForClassification(StudentProfile profile) {
		double gpa = profile.calculateLevelSR2WeightedGPA();
		double volume = profile.calculateOverallVolumeForClassification(this);
		
		// fail fast
		if (volume<0.33) {
			return false;
		}
		
		if (volume>=0.33 && gpa >=14.5) {
			return true;
		}
		
		if (volume>=0.41 && gpa >=13.5) {
			return true;
		}
		
		if (volume>=0.50 && gpa >=12.5) {
			return true;
		}
		
		if (volume>=0.58 && gpa >=11.5) {
			return true;
		}
		
		if (volume>=0.66 && gpa >=10.5) {
			return true;
		}
		
		return false;
	}

	@Override
	protected boolean hasLowEnoughEGrade(StudentProfile profile) {
		// No E grade at Level 2 or 3
		if (profile.calculateVolumeForGradePointsAtLevels(
				new GradePoint[]{new GradePoint("E+"),new GradePoint("E"),new GradePoint("E-")}, 
				new int[]{2,3})
				>0) {
			return false;
		}
		return true;
	}

	@Override
	public GradePoint getMinimumGradePoint() {
		return new GradePoint("A-");
	}

}
