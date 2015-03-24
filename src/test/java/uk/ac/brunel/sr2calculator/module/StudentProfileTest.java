package uk.ac.brunel.sr2calculator.module;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.brunel.sr2calculator.awards.AwardFactory;

public class StudentProfileTest {
	private StudentProfile profile;

	@Before
	public void setUp() throws Exception {
		profile = new StudentProfile();
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2001_CB"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2002_CN"), new GradePoint("D-")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2003_CN"), new GradePoint("C-")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2006_CN"), new GradePoint("B-")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS2007_C1"), new GradePoint("C")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3006_CE"), new GradePoint("D+")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3007_CN"), new GradePoint("C")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3008_CB"), new GradePoint("A-")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3074_CB"), new GradePoint("B")));
		profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule("CS3100_CN"), new GradePoint("E")));
	}

	@After
	public void tearDown() throws Exception {
		profile = null;
	}

	@Test
	public void testLevel2GPA() {
		assertEquals("Level 2 Weighted Average is Incorrect", 9.5, profile.calculateLevelWeightedGPA(2), 0.00001);
	}
	
	@Test
	public void testLevel3GPA() {
		assertEquals("Level 3 Weighted Average is Incorrect", 9.5, profile.calculateLevelWeightedGPA(3), 0.00001);
	}
	
	@Test
	public void testSR2OverallGPA() {
		assertEquals("Overall Weighted Average is Incorrect", 9.5, profile.calculateLevelSR2WeightedGPA(), 0.00001);
	}
	
	@Test
	public void testLevel2VolumeAtClass() {
		assertEquals("Level 2 1st Class Volume is Incorrect", 0.0f, profile.calculateVolumeForLevelAndClassification(2, AwardFactory.getInstance().getFirstClass()), 0.1);
		assertEquals("Level 2 2.1 Class Volume is Incorrect", 0.5f, profile.calculateVolumeForLevelAndClassification(2, AwardFactory.getInstance().getUpperSecondClass()), 0.1);
		assertEquals("Level 2 2.2 Class Volume is Incorrect", 0.83f, profile.calculateVolumeForLevelAndClassification(2, AwardFactory.getInstance().getLowerSecondClass()), 0.1);
		assertEquals("Level 2 3rd Class Volume is Incorrect", 1.0f, profile.calculateVolumeForLevelAndClassification(2, AwardFactory.getInstance().getThirdClass()), 0.1);
	}
	
	@Test
	public void testLevel3VolumeAtClass() {
		assertEquals("Level 3 1st Class Volume is Incorrect", 0.17f, profile.calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getFirstClass()), 0.1);
		assertEquals("Level 3 2.1 Class Volume is Incorrect", 0.5f, profile.calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getUpperSecondClass()), 0.1);
		assertEquals("Level 3 2.2 Class Volume is Incorrect", 0.67f, profile.calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getLowerSecondClass()), 0.1);
		assertEquals("Level 3 3rd Class Volume is Incorrect", 0.83f, profile.calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getThirdClass()), 0.1);
	}
	
	@Test
	public void testOverallVolume() {
		assertEquals("Overall 1st Class Volume is Incorrect", 0.11f, profile.calculateOverallProportionForClassification(AwardFactory.getInstance().getFirstClass()), 0.1);
		assertEquals("Overall 2.1 Class Volume is Incorrect", 0.5f, profile.calculateOverallProportionForClassification(AwardFactory.getInstance().getUpperSecondClass()), 0.1);
		assertEquals("Overall 2.2 Class Volume is Incorrect", 0.72f, profile.calculateOverallProportionForClassification(AwardFactory.getInstance().getLowerSecondClass()), 0.1);
		assertEquals("Overall 3rd Class Volume is Incorrect", 0.89f, profile.calculateOverallProportionForClassification(AwardFactory.getInstance().getThirdClass()), 0.1);
	}
	
	@Test 
	public void testZeroVolume() {
		assertEquals("Zero Volume 1st", 0.0f, new StudentProfile().calculateOverallProportionForClassification(AwardFactory.getInstance().getFirstClass()), 0.1);
		assertEquals("Zero Volume 2.1", 0.0f, new StudentProfile().calculateOverallProportionForClassification(AwardFactory.getInstance().getUpperSecondClass()), 0.1);
		assertEquals("Zero Volume 2.2", 0.0f, new StudentProfile().calculateOverallProportionForClassification(AwardFactory.getInstance().getLowerSecondClass()), 0.1);
		assertEquals("Zero Volume 2.3", 0.0f, new StudentProfile().calculateOverallProportionForClassification(AwardFactory.getInstance().getThirdClass()), 0.1);
		assertEquals("Zero Volume Level 3 1st Class Volume", 0.0f, new StudentProfile().calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getFirstClass()), 0.1);
		assertEquals("Zero Volume Level 3 2.1 Class Volume", 0.0f, new StudentProfile().calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getUpperSecondClass()), 0.1);
		assertEquals("Zero Volume Level 3 2.2 Class Volume", 0.0f, new StudentProfile().calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getLowerSecondClass()), 0.1);
		assertEquals("Zero Volume Level 3 3rd Class Volume", 0.0f, new StudentProfile().calculateVolumeForLevelAndClassification(3, AwardFactory.getInstance().getThirdClass()), 0.1);
	}
	
	@Test
	public void testClassificationCalculation() {
		assertEquals(AwardFactory.getInstance().getLowerSecondClass(), profile.calculateClassification(false));
		assertEquals(AwardFactory.getInstance().getNone(), new StudentProfile().calculateClassification(false));
	}

}
