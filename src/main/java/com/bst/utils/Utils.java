package com.bst.utils;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Utils {


    public static final Double PRICE_FACTOR = 1.2;
    public static final int NO_OF_DECIMALS = 2;
    // paths & files
    public static String WORKING_DIR = "c:\\TEMP\\bst\\";
    public static String CSV_DIR = WORKING_DIR + "exportedCsv\\";
    public static String ERR_LOG_FILE = CSV_DIR + "errors.csv";
    public static String EXPORT_FILE = CSV_DIR + "export.csv";
    public static String IMG_DIR = WORKING_DIR + "exportedImg\\";
    public static String PRODUCT_FEED_FILE = WORKING_DIR + "product-feed.csv";
    public static String MANUFACTURER_FILE = WORKING_DIR + "manufacturer.csv";
    public static String CATEGORY_FILE = WORKING_DIR + "category.csv";
    public static String PRODUCT_FILE = WORKING_DIR + "product.csv";
    // variables
    public static String SEPARATOR = ";";
    public static char SEPARATOR_CHAR = SEPARATOR.charAt(0);
    public static String SEPARATOR_MULTIPLE_VALUES = "|";
    public static String SEPARATOR_ESCAPED_MULTIPLE_VALUES = "\\|";
    public static char QUOTE_CHAR = '"';
    public static String OTHERS_DEFAULT_CATEGORY_NAME = "Others";
    public static String PARENT_HOME_CATEGORY_NAME = "Home";
    public static int SPLIT_PROD_EXPORT_FILE = 3998;
    public static boolean USE_RANDOM_WAIT = true;
    public static int USE_RANDOM_WAIT_LIMIT = 3000;
    public static String QUANTITY_STOCK = "1000";
    public static String DEFAULT_IMG = "default.jpg";
    public static int CATEGORY_ID_START_NO = 1000;
    // ftp
    public static int FTP_PORT = 21;
    public static String FTP_SERVER = "www.bestservice-it.ro";
    public static String FTP_USER;
    public static String FTP_PASS;
    public static String SERVER_IMG_PATH = "/tmp/img/";
    public static String SERVER_IMG_IMPORT_PATH = "/public_html" + SERVER_IMG_PATH;
    public static String HTTP_PATH_IMG_IMPORT = "http://" + FTP_SERVER + SERVER_IMG_PATH;
    public static ArrayList<String> CUVINTE_DE_DELATURA = new ArrayList<String>(Arrays.asList("sa", "ca", "daca", "si", "deoarece", "pentru", "inca"));
    static Logger log = Logger.getLogger(Utils.class.getName());
    private static boolean ONLY_FOR_TESTING_PURPOSE = false;
    private static int ONLY_FOR_TESTING_PURPOSE_LIMIT = 10 + 1;//1 = header

    public static void main(String[] args) {
    }

    public static boolean isTestingWriting() {
        return ONLY_FOR_TESTING_PURPOSE & --ONLY_FOR_TESTING_PURPOSE_LIMIT <= 0;
    }

    public static String getTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    public static String getImageUrl(String image_url) {
        String imageName = DEFAULT_IMG;
        String[] tokens = image_url.split("/");
        if (tokens.length > 1) {
            imageName = tokens[tokens.length - 1];
        }
        return HTTP_PATH_IMG_IMPORT + imageName.toLowerCase();
        //return "img/import/" + tokens[tokens.length - 1];
    }

    public static String bulk(String bulkDesc, String bulkPrice, String price) {
        if ((bulkDesc.isEmpty() || bulkPrice.isEmpty()) || price.equals(bulkPrice)) {
            return "";
        }
        return SEPARATOR_MULTIPLE_VALUES + "bulk: " + bulkDesc + " " + bulkPrice;
    }

    public static String stripQuotes(String s) {
        if (s != null && s.length() >= 1) {
            return s.replaceAll("\"", "").trim();
        }
        return "";
    }

    public static void testStripQuotesOk() {
        log.trace(stripQuotes(""));
        log.trace(stripQuotes("01"));
        log.trace(stripQuotes("\"01\""));
    }

    public static String cleanDesc(String src) {
        return src.replace("&amp;", "-")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&#38;", "")
                .replace("&quote;", "")
                .replace(";", ". ")
                .replace("\r\n", ". ")
                .replace("\r", ". ")
                .replace("\n", ". ")
                .trim();
    }

    public static void CreatePaths() {
        List<String> pathsToCreate = Arrays.asList(CSV_DIR, IMG_DIR);
        pathsToCreate.stream().forEach(s -> {
            File directory = new File(s);
            if (!directory.exists()) {
                directory.mkdir();
            }
        });

    }

    public static String getFileWithUtil(String fileName) {
        String result = "";
        ClassLoader classLoader = Utils.class.getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            log.error(e);
        }
        return result;
    }
}