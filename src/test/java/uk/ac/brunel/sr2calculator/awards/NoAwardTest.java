package uk.ac.brunel.sr2calculator.awards;

import junit.framework.TestSuite;

public class NoAwardTest extends AbstractAwardTests {
	private static final Award AWARD = AwardFactory.getInstance().getNone();
	public static TestSuite suite() {
	    TestSuite suite = new TestSuite("Upper Second Tests");
	    //$JUnit-BEGIN$
	    // Should always be valid
	    suite.addTest(new ClassificationTestCase(0, 0, 0, 0, 0.0f, AWARD, true));
	    suite.addTest(new ClassificationTestCase(100, 100, 100, 100, 0.0f, AWARD, true));
	    //$JUnit-END$
	    return suite;
	  }
}
