package com.bst;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;

public class CurrencyUtilTest extends TestCase {

    static Logger log = Logger.getLogger(CurrencyUtilTest.class.getName());

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CurrencyUtilTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CurrencyUtilTest.class);
    }


    /**
     * Rigourous Test :-)
     */
    public void testCurrencyUtilGet() {
        CurrencyUtil currValues = new CurrencyUtil();
        assertTrue(currValues.getSize() == 3);

        Double nonExisting = currValues.getCurrency("nonExisting");
        assertTrue(nonExisting == 1.0);

        Double nul = currValues.getCurrency(null);
        assertTrue(nul == 1.0);

        Double ron = currValues.getCurrency("RON");
        assertTrue(ron == 1.0);

        Double eur = currValues.getCurrency("EUR_DEFAULT_VALUE");
        assertTrue(eur == 4.6);

        Double usd = currValues.getCurrency("USD_DEFAULT_VALUE");
        assertTrue(usd == 4.3);
    }
}
