package uk.ac.brunel.sr2calculator.awards;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.ModuleFactory;
import uk.ac.brunel.sr2calculator.module.ModuleResult;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class AwardTest {
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
	}

	@Test
	public void testFirstClass() {
		assertFalse(AwardFactory.getInstance().getFirstClass().canBeAwardedForProfile(profile));
	}
	
	@Test
	public void test21Class() {
		assertFalse(AwardFactory.getInstance().getUpperSecondClass().canBeAwardedForProfile(profile));
	}
	
	@Test
	public void test22Class() {
		assertTrue(AwardFactory.getInstance().getLowerSecondClass().canBeAwardedForProfile(profile));
	}
	
	@Test
	public void test3Class() {
		assertTrue(AwardFactory.getInstance().getThirdClass().canBeAwardedForProfile(profile));
	}


}
