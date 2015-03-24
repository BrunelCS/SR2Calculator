package uk.ac.brunel.sr2calculator.awards;

import junit.framework.TestSuite;

public class ThirdClassHonoursTest extends AbstractAwardTests {
	private static final Award AWARD = AwardFactory.getInstance().getThirdClass();
	public static TestSuite suite() {
	    TestSuite suite = new TestSuite("Upper Second Tests");
	    //$JUnit-BEGIN$
	    // Meets GPA (GPA is stubbed to 0, even though this can't happen in practice)
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 0, 0.0f, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 40, 0, 0, 0.0f, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 0, 40, 0, 0.0f, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 30, 30, 0, 0.0f, AWARD, true));
	    // Meets GPA, but too many F grades
	    suite.addTest(new ClassificationTestCase(1, 0, 0, 0, 0.0f, AWARD, false));
	    // Meets GPA, but too many Level 2 E grades
	    suite.addTest(new ClassificationTestCase(0, 41, 0, 0, 0.0f, AWARD, false));
	    // Meets GPA, but too many Level 3 E grades
	    suite.addTest(new ClassificationTestCase(0, 0, 41, 0, 0.0f, AWARD, false));
	    // Meets GPA, but too many combined Level 2 & 3 E grades
	    suite.addTest(new ClassificationTestCase(0, 31, 30, 0, 0.0f, AWARD, false));
	    //$JUnit-END$
	    return suite;
	  }
}
