package day09;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
//Ìí¼Ó²âÊÔÌ×¼ş
public class AllTests {
	public static Test suite() {
	TestSuite suite = new TestSuite("Test for day09");
	//$JUnit-BEGIN$
	suite.addTest(new JUnit4TestAdapter(Test3.class));
	//suite.addTest(new JUnit4TestAdapter(Test1.class));
	//suite.addTest(new JUnit4TestAdapter(TC012MessageAssertChrome.class));
	//$JUnit-END$
	return suite;
	}
}
