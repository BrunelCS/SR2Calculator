package uk.ac.brunel.sr2calculator.awards;

import junit.framework.TestSuite;

public class UpperSecondClassHonoursTest extends AbstractAwardTests {
	private static final Award AWARD = AwardFactory.getInstance().getUpperSecondClass();
	public static TestSuite suite() {
	    TestSuite suite = new TestSuite("Upper Second Tests");
	    //$JUnit-BEGIN$
	    // Meets GPA
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 11, 0.0f, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 20, 0, 11, 0.0f, AWARD, true));
	    // Meets GPA, but too many F grades
	    suite.addTest(new ClassificationTestCase(1, 0, 0, 11, 0.0f, AWARD, false));
	    // Meets GPA, but too many Level 2 E grades
	    suite.addTest(new ClassificationTestCase(0, 21, 0, 11, 0.0f, AWARD, false));
	    // Meets GPA, but too many Level 3 E grades
	    suite.addTest(new ClassificationTestCase(0, 0, 1, 11, 0.0f, AWARD, false));

	    // Range of borderline successful borderline cases
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 10.5, 0.41, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 10.0, 0.45, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 9.5, 0.50, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 9.0, 0.54, AWARD, true));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 8.5, 0.58, AWARD, true));
	    
	    // Range of unsuccessful borderline cases which miss on GPA
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 10.4, 0.41, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 9.9, 0.45, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 9.4, 0.50, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 8.9, 0.54, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 8.4, 0.58, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 8.0, 0.62, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 7.5, 0.66, AWARD, false));
	    
	    // Range of unsuccessful borderline cases which miss on volume
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 10.5, 0.40, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 10.0, 0.44, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 9.5, 0.49, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 9.0, 0.53, AWARD, false));
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 8.5, 0.57, AWARD, false));
	    //$JUnit-END$
	    return suite;
	  }
}
