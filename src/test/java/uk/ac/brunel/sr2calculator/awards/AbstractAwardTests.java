package uk.ac.brunel.sr2calculator.awards;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class AbstractAwardTests extends TestSuite {
	
	public static class ClassificationTestCase extends TestCase {
		StudentProfile profile = mock(StudentProfile.class);
		
		private boolean expected;
		private Award classification;
		
		
		public ClassificationTestCase(int F, int level2E, int level3E, double gpa, double volumeAt, Award classification, boolean expected) {
			createProfile( F,  level2E,  level3E,  gpa,  volumeAt,  classification);
			StringBuffer buffer = new StringBuffer();
			buffer.append("test");
			buffer.append(classification.getName());
			buffer.append("F"+F);
			buffer.append("L2E"+level2E);
			buffer.append("L3E"+level3E);
			buffer.append("gpa"+gpa);
			buffer.append("|"+(volumeAt*100.0)+"@"+classification.getName());
			this.expected = expected;
			this.classification = classification;
			if (expected) {
				buffer.append("ExpectTrue");
			} else {
				buffer.append("ExpectFail");
			}
			setName(buffer.toString());
		}
		
		protected void runTest() throws Throwable {
		    boolean actual = classification.canBeAwardedForProfile(profile);
			
			assertEquals(getName() + "FAILED", expected, actual);
		}
		
		protected void setL2AndL3FailureVolume(int volume) {
			when(profile.calculateVolumeForGradePointsAtLevels(AbstractAward.F_GRADE, new int[]{2,3})).thenReturn(volume);
		}

		protected void setEGradeVolume(int l2, int l3) {
			when(profile.calculateVolumeForGradePointsAtLevels(eq(AbstractAward.E_GRADES), eq(new int[]{2}))).thenReturn(l2);
			when(profile.calculateVolumeForGradePointsAtLevels(eq(AbstractAward.E_GRADES), eq(new int[]{3}))).thenReturn(l3);
			when(profile.calculateVolumeForGradePointsAtLevels(eq(AbstractAward.E_GRADES), eq(new int[]{2,3}))).thenReturn(l2+l3);
		}
		
		protected void setGPA(double gpa) {
			when(profile.calculateLevelSR2WeightedGPA()).thenReturn(gpa);
		}
		
		protected void setVolumeAtClassification(Award award, double volume) {
			when(profile.calculateOverallProportionForClassification(award)).thenReturn(volume);
		}
		
		protected void createProfile(int F, int level2E, int level3E, double gpa, double volumeAt, Award classification) {
			profile = mock(StudentProfile.class);
			setGPA(gpa);
			setL2AndL3FailureVolume(F);
			setEGradeVolume(level2E, level3E);
			setVolumeAtClassification(classification, volumeAt);
		}
	}
	

}
