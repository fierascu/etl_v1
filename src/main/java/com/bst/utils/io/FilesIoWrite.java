package com.bst.utils.io;

import com.bst.data.CatPojo;
import com.bst.data.ProdPojo;
import com.opencsv.CSVWriter;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.util.*;

import static com.bst.data.CatPojo.getCategoryOrDefaultCat;
import static com.bst.utils.Utils.*;

public class FilesIoWrite {
    static Logger log = Logger.getLogger(FilesIoWrite.class.getName());

    private FilesIoWrite() {
        throw new IllegalAccessError("Utility class");
    }

    public static void main(String[] args) {
    }


    public static void prepareCats(List<ProdPojo> drl) {
        if (drl == null || drl.isEmpty()) return;
        log.info("Received a list of lines of " + drl.size() + " categories from the products");
        //create categories
        List<CatPojo> cats = new ArrayList<>();
        Set<String> uniqueCats = new HashSet<String>();

        // extract unique cats
        for (ProdPojo dr : drl) {
            if (!dr.getCats().isEmpty()) {
                uniqueCats.add(dr.getCats());
            }
        }
        cats.addAll(getUniqueCats(uniqueCats));

        //write categories to file for original language
        writeCatsToFile(cats);
    }

    public static void writeCatsToFile(List<CatPojo> cats) {
        String outputCsvCat = CSV_DIR + "Categories_" + getTimestamp() + ".csv";
        String headerResultCat = "id;Active (0/1);Name*;Parent Category;Root category (0/1);description;Meta-title;Meta-keywords;Meta-description;URL rewritten;Image URL;ID ou nom de la boutique";
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputCsvCat), SEPARATOR_CHAR, QUOTE_CHAR)) {
            // feed in your array (or convert your data to an array)
            writer.writeNext(headerResultCat.split(SEPARATOR));

            for (CatPojo cat : cats) {
                String[] entries = (
                        cat.id + SEPARATOR + //id
                                cat.active + SEPARATOR + // Active (0/1)
                                cat.name + SEPARATOR +// Name*
                                cat.parentCategory + SEPARATOR +// Parent Category
                                cat.rootCategory + SEPARATOR +// Root category (0/1)
                                SEPARATOR +// description
                                SEPARATOR +// Meta-title
                                SEPARATOR +// Meta-keywords
                                SEPARATOR +// Meta-description
                                cat.name.toLowerCase().replaceAll(" ", "-") + SEPARATOR +// URL rewritten
                                cat.imageUrl + SEPARATOR +// Image URL
                                cat.storeId // ID ou nom de la boutique;
                ).split(SEPARATOR);
                writer.writeNext(entries);
            }

            log.info("Wrote: " + outputCsvCat);
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static void writeProductsToFile(List<ProdPojo> drl) {
        if (drl == null || drl.isEmpty()) return;
        String outputCsvProd = CSV_DIR + "Products_" + getTimestamp();
        String headerResultProd = "id;Active (0/1);Name;Categories;Price tax excl;Tax rules id;Wholesale price;On sale (0/1);Discount amount;Discount percent;Discount from (yyy-mm-dd);Discount to (yyy-mm-dd);Reference #;Supplier reference #;Supplier;Manufacturer;EAN13;UPC;Ecotax;Weight;Quantity;Short description;description;Tags;Meta-title;Meta-keywords;Meta-description;URL rewritten;Text when in-stock;Text if back-order allowed;Available for order (0=No/1=Yes);Product creation date;Show price (0=No/1=Yes);Image URLs;Delete existing images (0=No/1=Yes);Feature(Name:Value:Position);Available online only (0=No/1=Yes);Condition (new/used/refurbished);ID / Name of shop";

        List<String[]> bulkProdList = new ArrayList<>();
        int contor = 0;
        for (int i = 0; i < drl.size(); i++) {
            ProdPojo dr = drl.get(i);
            String[] entries = (
                    dr.getId() + SEPARATOR +  //id
                            "1" + SEPARATOR + //Active (0/1)
                            dr.getTitle() + SEPARATOR + //Name
                            getCategoryOrDefaultCat(dr.getCats()) + SEPARATOR +//Categories
                            dr.getPrice() + SEPARATOR +//Price tax excl
                            "1" + SEPARATOR +//Tax rules id
                            SEPARATOR +//Wholesale price
                            "1" + SEPARATOR +//On sale (0/1)
                            SEPARATOR +//Discount amount
                            SEPARATOR +//Discount percent
                            SEPARATOR +//Discount from (yyy-mm-dd)
                            SEPARATOR +//Discount to (yyy-mm-dd)
                            SEPARATOR +//Reference #
                            SEPARATOR +//Supplier reference #
                            dr.getBrand() + SEPARATOR +//Supplier
                            dr.getBrand() + SEPARATOR +//Manufacturer
                            SEPARATOR +//EAN13
                            SEPARATOR +//UPC
                            SEPARATOR +//Ecotax
                            SEPARATOR +//Weight
                            QUANTITY_STOCK + SEPARATOR +//Quantity
                            dr.getShortDesc() + SEPARATOR +//Short description
                            dr.getDescription() + SEPARATOR +//description
                            dr.getKeywords() + SEPARATOR +//Tags
                            dr.getShortDesc() + SEPARATOR +//Meta-title
                            dr.getKeywords() + SEPARATOR +//Meta-keywords
                            dr.getShortDesc() + SEPARATOR +//Meta-description
                            dr.getTitle().toLowerCase().replaceAll(" ", "-") + SEPARATOR +//URL rewritten
                            "In stock" + SEPARATOR +//Text when in-stock
                            "Out stock" + SEPARATOR +//Text if back-order allowed
                            "1" + SEPARATOR +//Available for order (0=No/1=Yes)
                            SEPARATOR +//Product creation date
                            SEPARATOR +//Show price (0=No/1=Yes)
                            getImageUrl(dr.getImage()) + SEPARATOR +//Image URLs
                            SEPARATOR +//Delete existing images (0=No/1=Yes)
                            "Cod: " + dr.getSku() + "|" + dr.getProperties() + bulk(dr.getBulkDesc(), dr.getBulkPrice(), dr.getPrice()) + SEPARATOR + //Feature(Name:Value:Position)
                            "0" + SEPARATOR +//Available online only (0=No/1=Yes)
                            "new" + SEPARATOR +//Condition (new/used/refurbished)
                            "1"//ID / Name of shop
            ).split(SEPARATOR);

            bulkProdList.add(entries);

            String outputCsvProdFileName = outputCsvProd + "_" + i + ".csv";
            if (contor > SPLIT_PROD_EXPORT_FILE && i < drl.size()) {
                try (CSVWriter writer = new CSVWriter(new FileWriter(outputCsvProdFileName), SEPARATOR_CHAR, QUOTE_CHAR)) {
                    // feed in your array (or convert your data to an array)
                    writer.writeNext(headerResultProd.split(";"));
                    for (String[] bl : bulkProdList) {
                        writer.writeNext(bl);
                    }
                    bulkProdList.clear();
                    contor = 0;
                    log.info("Wrote: " + outputCsvProdFileName);
                } catch (Exception e) {
                    log.error(e);
                }
            } else {
                contor++;
            }

            if (i + 1 == drl.size()) {
                try (CSVWriter writer = new CSVWriter(new FileWriter(outputCsvProdFileName), SEPARATOR_CHAR, QUOTE_CHAR)) {
                    // feed in your array (or convert your data to an array)
                    writer.writeNext(headerResultProd.split(";"));
                    for (String[] bl : bulkProdList) {
                        writer.writeNext(bl);
                    }
                    bulkProdList.clear();
                    log.info("Wrote: " + outputCsvProdFileName);
                } catch (Exception e) {
                    log.error(e);
                }
            }

        }

    }


    private static Collection<? extends CatPojo> getUniqueCats(Set<String> uniqueCats) {
        int noCats = CATEGORY_ID_START_NO; // starting number for category id
        List<CatPojo> cats = new ArrayList<>();
        CatPojo newLabelCat = new CatPojo(noCats++ + "", OTHERS_DEFAULT_CATEGORY_NAME, PARENT_HOME_CATEGORY_NAME, "0");
        cats.add(newLabelCat);

        for (String uniqueCat : uniqueCats) {
            String[] tokens = uniqueCat.split(SEPARATOR_ESCAPED_MULTIPLE_VALUES);
            // find cat if exist
            for (int i = 0; i < tokens.length; i++) {
                List<CatPojo> newCats = new ArrayList<>();
                //for (CatPojo cat : cats) {
                //if (!tokens[i].equalsIgnoreCase(cat.name)){// &&
                if (!cats.toString().contains(tokens[i])) {
                    //cat don't exist, create a new one
                    String rootCat = "0";// always not root cat
                    String parentCat = i == 0 ? PARENT_HOME_CATEGORY_NAME : tokens[i - 1].trim();//get the previous cat aka token
                    newCats.add(new CatPojo(noCats++ + "", tokens[i].trim(), parentCat, rootCat));
                }
                if (newCats.size() > 0) {
                    cats.addAll(newCats);
                    // log.trace(noCats + "=>" + newCats.toString());
                }
            }
        }
        log.trace("Looking trough categories and found " + cats.size() + " uniques categories.");
        return cats;
    }

}
