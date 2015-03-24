package uk.ac.brunel.sr2calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uk.ac.brunel.sr2calculator.awards.FirstClassHonoursTest;
import uk.ac.brunel.sr2calculator.awards.LowerSecondClassHonoursTest;
import uk.ac.brunel.sr2calculator.awards.ThirdClassHonoursTest;
import uk.ac.brunel.sr2calculator.awards.UpperSecondClassHonoursTest;
import uk.ac.brunel.sr2calculator.module.StudentProfileTest;

@RunWith(Suite.class)
@SuiteClasses({ StudentProfileTest.class, 
				FirstClassHonoursTest.class, 
				UpperSecondClassHonoursTest.class,
				LowerSecondClassHonoursTest.class,
				ThirdClassHonoursTest.class})
public class AllTests {
	

}
