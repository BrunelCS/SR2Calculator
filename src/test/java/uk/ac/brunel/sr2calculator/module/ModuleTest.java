package uk.ac.brunel.sr2calculator.module;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModuleTest {
	Module module;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidConstruction() {
		ModuleFactory.getInstance().addModule("TESTMODULE1", 10, 1);
		ModuleFactory.getInstance().addModule("TESTMODULE2", 10, 2);
		ModuleFactory.getInstance().addModule("TESTMODULE3", 10, 3);

		Module testModule = ModuleFactory.getInstance().getModule("TESTMODULE1");

		assertEquals("TESTMODULE1", testModule.getModuleCode());
		assertEquals(10, testModule.getCredits());
		assertEquals(1, testModule.getLevel());
	}
	
	@Test
	public void testIllegalConstructionLevelTooHigh() {
		try {
			ModuleFactory.getInstance().addModule("TESTMODULE3", 10, 8);
			fail("Level must be valid");
		} catch (IllegalArgumentException e) {
			// PASS
		}	
	}
	
	@Test
	public void testIllegalConstructionLevelTooLow() {
		try {
			ModuleFactory.getInstance().addModule("TESTMODULE3", 10, 0);
			fail("Level must be valid");
		} catch (IllegalArgumentException e) {
			// PASS
		}	
	}
	

	

}
