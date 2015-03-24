package uk.ac.brunel.sr2calculator.awards;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public interface Award {

	public GradePoint getMinimumGradePoint();
	
	public boolean hasRequiredCredits(StudentProfile profile);

	public boolean canBeAwardedForProfile(StudentProfile profile);

	public String getName();

}