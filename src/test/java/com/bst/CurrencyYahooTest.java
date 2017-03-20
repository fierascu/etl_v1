package com.bst;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;

import static com.bst.CurrencyYahoo.urlBegin;

public class CurrencyYahooTest extends TestCase {

    public static final String USED_YQL_XML = "Used/yql.xml";
    static Logger log = Logger.getLogger(CurrencyYahooTest.class.getName());

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CurrencyYahooTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CurrencyYahooTest.class);
    }


    /**
     * Rigourous Test :-)
     */
    public void testCurrencyYahooGet() {
        CurrencyYahoo cy = new CurrencyYahoo();
        assertTrue(cy.getEur() == 4.5499);
    }

    public void testReadXml() {
        try {
            String xmlTestFile = Utils.getFileWithUtil(USED_YQL_XML);
            log.trace(xmlTestFile);
            assertTrue(xmlTestFile.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void testParseXml() {
        try {
            String withXPath = Utils.class.getClassLoader().getResource(USED_YQL_XML).toString();
            CurrencyYahoo cy = new CurrencyYahoo(withXPath);
            Boolean xmlTestParseFile = cy.setWithXPath(withXPath);
            log.trace(xmlTestParseFile);
            assertTrue(xmlTestParseFile);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void testSetWithXPath() {
        CurrencyYahoo cy = new CurrencyYahoo();
        assertTrue(cy.setWithXPath(urlBegin));
    }
}
