package uk.ac.brunel.sr2calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uk.ac.brunel.sr2calculator.awards.AwardTest;
import uk.ac.brunel.sr2calculator.module.StudentProfileTest;

@RunWith(Suite.class)
@SuiteClasses({ AwardTest.class, StudentProfileTest.class })
public class AllTests {

}
