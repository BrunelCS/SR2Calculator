package uk.ac.brunel.sr2calculator.awards;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class NoAward implements Award {

	@Override
	public GradePoint getMinimumGradePoint() {
		return new GradePoint("F");
	}

	@Override
	public boolean canBeAwardedForProfile(StudentProfile profile) {
		return true;
	}

	@Override
	public String getName() {
		return "No Award";
	}

}
