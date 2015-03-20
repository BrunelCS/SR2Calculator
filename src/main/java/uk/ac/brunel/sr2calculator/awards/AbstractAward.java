package uk.ac.brunel.sr2calculator.awards;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public abstract class AbstractAward implements Award {
	
	protected static final GradePoint[] E_GRADES = 
			new GradePoint[]{new GradePoint("E+"),new GradePoint("E"),new GradePoint("E-")};
	protected static final GradePoint[] F_GRADE = 
			new GradePoint[]{new GradePoint("F")};
	
	
	/* (non-Javadoc)
	 * @see uk.ac.brunel.sr2.data.ClassificationI#canBeAwardedForProfile(uk.ac.brunel.sr2.data.StudentProfile)
	 */
	@Override
	public boolean canBeAwardedForProfile(StudentProfile profile) {
		return hasNoFailure(profile) && eligibleForClassification(profile) && hasLowEnoughEGrade(profile); 			
	}

	private boolean hasNoFailure(StudentProfile profile) {
		if (profile.calculateVolumeForGradePointsAtLevels(F_GRADE, new int[]{2,3}) > 0) {
			return false;
		}
		return true;
	}

	protected abstract boolean eligibleForClassification(StudentProfile profile);

	protected abstract boolean hasLowEnoughEGrade(StudentProfile profile);
}
