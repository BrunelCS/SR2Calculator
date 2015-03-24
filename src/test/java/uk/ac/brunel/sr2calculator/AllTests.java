package uk.ac.brunel.sr2calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uk.ac.brunel.sr2calculator.awards.FirstClassHonoursTest;
import uk.ac.brunel.sr2calculator.awards.LowerSecondClassHonoursTest;
import uk.ac.brunel.sr2calculator.awards.NoAwardTest;
import uk.ac.brunel.sr2calculator.awards.ThirdClassHonoursTest;
import uk.ac.brunel.sr2calculator.awards.UpperSecondClassHonoursTest;
import uk.ac.brunel.sr2calculator.module.ModuleTest;
import uk.ac.brunel.sr2calculator.module.StudentProfileTest;

@RunWith(Suite.class)
@SuiteClasses({ ModuleTest.class,
				StudentProfileTest.class, 
				FirstClassHonoursTest.class, 
				UpperSecondClassHonoursTest.class,
				LowerSecondClassHonoursTest.class,
				ThirdClassHonoursTest.class,
				NoAwardTest.class})
public class AllTests {
	

}
