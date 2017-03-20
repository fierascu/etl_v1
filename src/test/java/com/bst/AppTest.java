package com.bst;

import com.bst.data.ProdFeed;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;

import static com.bst.App.convertToKeywords;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    static Logger log = Logger.getLogger(AppTest.class.getName());

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }


    public static void testConvertToKeywords() {
        String testString = " Extensie 16 zone pentru PC4020, PC 4116   ";
        ProdFeed pf = new ProdFeed();
        pf.setDescription(testString);
        log.trace(convertToKeywords(pf));
        assertTrue(convertToKeywords(pf).equals("Extensie,16,zone,pentru,PC4020,PC,4116"));
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
