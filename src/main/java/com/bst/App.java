package com.bst;

import com.bst.data.*;
import com.bst.utils.Utils;
import com.bst.utils.currency.CurrencyUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bst.utils.io.FilesIoRead.*;
import static com.bst.utils.io.FilesIoWrite.prepareCats;
import static com.bst.utils.io.FilesIoWrite.writeProductsToFile;
import static com.bst.utils.Utils.*;


public class App {
    static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // TODO remember to use original csv files!!!!!
        // TODO read filenames as properties

        Utils.CreatePaths();

        log.info("1. read files:");
        List pfl = processInputFileProdFeed(PRODUCT_FEED_FILE);//12961
        List ml = readFileManufacturer(MANUFACTURER_FILE);
        List cl = readFileCategory(CATEGORY_FILE);
        List pl = processInputFileProduct(PRODUCT_FILE);//should be 11272
        // read existing products, filter after cod

        log.info("2. etl: MAGIC!");
        List<ProdPojo> ppl = extractProdPojos(pfl, ml, cl, pl);

        log.info("3. write files:");
        prepareCats(ppl);
        writeProductsToFile(ppl);
    }

    private static List extractProdPojos(List<ProdFeed> pfla, List<Manufacturer> mla, List<Category> cla, List<Product> pla) {
        List<ProdPojo> resList = new ArrayList<>();

        Set<String> uniqueExistingProdByReferint = pla.stream()
                .map(e -> e.getReferinta())
                .collect(Collectors.toSet());

        log.info("Reducing existing products by code: initial=" + pfla.size() + " resulting uniqueExistingProdByReferint.size=" + uniqueExistingProdByReferint.size());
        //Reducing existing products by code: initial=12961 resulting uniqueExistingProdByReferint.size=11271


        List<ProdFeed> filterdProdFeedFromProdByCode = pfla.stream()
                .filter(e -> uniqueExistingProdByReferint.contains(e.getCode()))
                .collect(Collectors.toList());

        log.info("Filter existing products by code: initial=" + pfla.size() + " resulting filterdProdFeedFromProdByCode.size=" + filterdProdFeedFromProdByCode.size());
        //Filter existing products by code: initial=12961 resulting listOutput.size=0

        resList = convertFeedProdToProd(filterdProdFeedFromProdByCode, cla);
        return resList;
    }

    private static List<ProdPojo> convertFeedProdToProd(List<ProdFeed> filterdProdFeedFromProdByCode, List<Category> cla) {
        List<ProdPojo> result = new ArrayList<>();
        CurrencyUtil currValues = new CurrencyUtil();

        for (ProdFeed auxFeedProd : filterdProdFeedFromProdByCode) {

            ProdPojo newProd = new ProdPojo(
                    auxFeedProd.getId(), //id
                    "FeedProd", //siteName
                    auxFeedProd.getName(),//title
                    auxFeedProd.getDescription(),//description
                    convertToKeywords(auxFeedProd),//keywords
                    "",//image
                    auxFeedProd.getManufacturer_name(),//brand
                    convertToPrice(auxFeedProd.getPrice(), auxFeedProd.getCurrency(), PRICE_FACTOR, currValues),//price
                    "",//productLink
                    auxFeedProd.getCode(),//sku
                    auxFeedProd.getDescription(),//shortDesc
                    convertToCategory(auxFeedProd.getProduct_category_name(), cla),//cats
                    convertToProperties(auxFeedProd),//properties
                    "",//bulkDesc
                    "",//bulkPrice
                    ""//originalLink
            );
            result.add(newProd);
        }

        log.info("from " + filterdProdFeedFromProdByCode.size() + " made " + result.size());
        return result;
    }

    private static String convertToPrice(String price, String currency, Double priceFactor, CurrencyUtil currValues) {
        Double priceD = 0.0;
        try {
            priceD = Double.parseDouble(price.replace(",", "."));
        } catch (Exception e) {
            log.error(e);
        }
        priceD = priceD * priceFactor * currValues.getCurrency(currency);
        //String.format("%.2f", value)
        return String.format("%." + NO_OF_DECIMALS + "f", priceD);
    }

    private static String convertToCategory(String product_category_name, List<Category> cla) {
        for (Category cat : cla) {
            if (cat.getDescriere().toLowerCase().contains(product_category_name.toLowerCase())
                    || cat.getNume().toLowerCase().contains(product_category_name.toLowerCase())
                    ) {
                return cat.getNume();
            }
        }
        return product_category_name;
    }

    public static String convertToProperties(ProdFeed auxFeedProd) {

        return "Stare: Produs Nou| Garantie: " + auxFeedProd.getWarranty();
    }

    public static String convertToKeywords(ProdFeed auxFeedProd) {
        return auxFeedProd.getDescription().trim().replaceAll(" ", ",").replaceAll(",,", ",");
    }


}
