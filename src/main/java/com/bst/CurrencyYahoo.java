package com.bst;


import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.net.URL;

import static com.bst.CurrencyUtil.EUR_DEFAULT_VALUE;
import static com.bst.CurrencyUtil.USD_DEFAULT_VALUE;

public class CurrencyYahoo {

    public static final String EXPR_EUR = "/query/results/rate[@id ='EURRON']/Rate/text()";
    public static final String EXPR_USD = "/query/results/rate[@id ='USDRON']/Rate/text()";
    public static String urlBegin = "http://query.yahooapis.com/v1/public/yql?q=select%20%2a%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22EURRON%22,%20%22USDRON%22%29&env=store://datatables.org/alltableswithkeys";
    static Logger log = Logger.getLogger(CurrencyYahoo.class.getName());
    private Double eur;
    private Double usd;

    public CurrencyYahoo() {
        if (!setWithXPath(urlBegin)) {
            setEur(EUR_DEFAULT_VALUE);
            setUsd(USD_DEFAULT_VALUE);
        }
    }

    public CurrencyYahoo(String url) {
        if (!setWithXPath(url)) {
            setEur(EUR_DEFAULT_VALUE);
            setUsd(USD_DEFAULT_VALUE);
        }
    }

    public Document extractFromUrl(String url) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error(e);
        }

        Document doc = null;
        try {
            doc = db.parse(new URL(url).openStream());
        } catch (SAXException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
        return doc;
    }

    public Boolean setWithXPath(String url) {
        Document doc = extractFromUrl(url);
        if (doc != null) {
            try {
                XPath xPath = XPathFactory.newInstance().newXPath();
                Node nodeEur = (Node) xPath.evaluate(EXPR_EUR, doc, XPathConstants.NODE);
                setEur(nodeEur.getTextContent());
                Node nodeUsd = (Node) xPath.evaluate(EXPR_USD, doc, XPathConstants.NODE);
                setUsd(nodeUsd.getTextContent());
            } catch (XPathExpressionException e) {
                log.error(e);
            }
            return true;
        }
        return false;
    }

    public Double getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = Double.parseDouble(eur);
    }

    public void setEur(Double eur) {
        this.eur = eur;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = Double.parseDouble(usd);
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }

}
