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
	protected boolean meetsBorderlineCriteria(StudentProfile profile) {
		return true;
	}
	
	@Override
	protected boolean meetsMinimumGPA(StudentProfile profile) {
		return true;
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
