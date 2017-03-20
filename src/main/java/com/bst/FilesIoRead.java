package com.bst;

import com.bst.data.Category;
import com.bst.data.Manufacturer;
import com.bst.data.ProdFeed;
import com.bst.data.Product;
import com.opencsv.CSVReader;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.bst.Utils.cleanDesc;
import static com.bst.Utils.isTestingWriting;
import static com.bst.Utils.stripQuotes;

public class FilesIoRead {

    static Logger log = Logger.getLogger(FilesIoRead.class.getName());
    private static Function<String, ProdFeed> mapToItemProdFeed = (line) -> {
        String[] nextLine = line.split(",");
        ProdFeed prod = new ProdFeed();
        int col = 0;
        if (nextLine.length > col) {
            prod.setId(stripQuotes(nextLine[col]));
            col++; //1
        }
        if (nextLine.length > col) {
            prod.setName(stripQuotes(nextLine[col]));
            col++; //2
        }
        if (nextLine.length > col) {
            prod.setCode(stripQuotes(nextLine[col]));
            col++;//3
        }
        if (nextLine.length > col) {
            prod.setWarranty(stripQuotes(nextLine[col]));
            col++; //4
        }
        if (nextLine.length > col) {
            prod.setWarranty_type(stripQuotes(nextLine[col]));
            col++; //5
        }
        if (nextLine.length > col) {
            prod.setProduct_category_id(stripQuotes(nextLine[col]));
            col++; //6
        }
        if (nextLine.length > col) {
            prod.setProduct_category_name(stripQuotes(nextLine[col]));
            col++; //7
        }
        if (nextLine.length > col) {
            prod.setManufacturer_id(stripQuotes(nextLine[col]));
            col++; //8
        }
        if (nextLine.length > col) {
            prod.setManufacturer_name(stripQuotes(nextLine[col]));
            col++; //9
        }
        if (nextLine.length > col) {
            prod.setMin_quantity(stripQuotes(nextLine[col]));
            col++; //10
        }
        if (nextLine.length > col) {
            prod.setStock_value(stripQuotes(nextLine[col]));
            col++; //11
        }
        if (nextLine.length > col) {
            prod.setSupplier_stock_value(stripQuotes(nextLine[col]));
            col++; //12
        }
        if (nextLine.length > col) {
            prod.setSupplier_stock_delivery_date(stripQuotes(nextLine[col]));
            col++; //13
        }
        if (nextLine.length > col) {
            prod.setReserved_stock_value(stripQuotes(nextLine[col]));
            col++; //14
        }
        if (nextLine.length > col) {
            prod.setPrice(stripQuotes(nextLine[col]));
            col++; //15
        }
        if (nextLine.length > col) {
            prod.setSpecial_price(stripQuotes(nextLine[col]));
            col++; //16
        }

        if (nextLine.length > col) {
            prod.setCatalog_price(stripQuotes(nextLine[col]));
            col++; //17
        }

        if (nextLine.length > col) {
            prod.setGreen_stamp_value(stripQuotes(nextLine[col]));
            col++; //18
        }
        if (nextLine.length > col) {
            prod.setCurrency(stripQuotes(nextLine[col]));
            col++; //19
        }
        if (nextLine.length > col) {
            prod.setDiscount(stripQuotes(nextLine[col]));
            col++; //20
        }
        if (nextLine.length > col) {
            prod.setVat_percent(stripQuotes(nextLine[col]));
            col++; //21
        }
        if (nextLine.length > col) {
            prod.setHas_resealed(stripQuotes(nextLine[col]));
            col++; //22
        }
        if (nextLine.length > col) {
            prod.setDescription(cleanDesc(stripQuotes(nextLine[col])));
            col++; //23
        }
        if (nextLine.length > col) {
            prod.setRon_price(stripQuotes(nextLine[col]));
            col++; //24
        }
        if (nextLine.length > col) {
            prod.setRon_catalog_price(stripQuotes(nextLine[col]));
            col++; //25
        }
        if (nextLine.length > col) {
            prod.setPromo_price(stripQuotes(nextLine[col]));
            col++; //26
        }
        if (nextLine.length > col) {
            prod.setRon_promo_price(stripQuotes(nextLine[col]));
            col++; //27
        }
        if (nextLine.length > col) {
            prod.setOriginal_code(stripQuotes(nextLine[col]));
            col++; //28
        }
        if (nextLine.length > col) {
            prod.setDiscount_rate(stripQuotes(nextLine[col]));
            col++; //29
        }

        return prod;
    };

    private static Function<String, Product> mapToItemProduct = (line) -> {
        String[] nextLine = line.split(";");
        Product prod = new Product();
        int col = 0;
        if (nextLine.length > col) {
            prod.setId(stripQuotes(nextLine[col]));
            col++; //1
        }
        if (nextLine.length > col) {
            prod.setImagine(stripQuotes(nextLine[col]));
            col++; //2
        }
        if (nextLine.length > col) {
            prod.setNume(stripQuotes(nextLine[col]));
            col++;//3
        }
        if (nextLine.length > col) {
            prod.setReferinta(stripQuotes(nextLine[col]));
            col++;//4
        }
        if (nextLine.length > col) {
            prod.setCategorie(stripQuotes(nextLine[col]));
            col++; //5
        }
        if (nextLine.length > col) {
            prod.setPretDeBaza(stripQuotes(nextLine[col]));
            col++; //6
        }
        if (nextLine.length > col) {
            prod.setPretFinal(stripQuotes(nextLine[col]));
            col++; //7
        }
        if (nextLine.length > col) {
            prod.setCantitate(stripQuotes(nextLine[col]));
            col++; //8
        }
        if (nextLine.length > col) {
            prod.setStare(stripQuotes(nextLine[col]));
            col++; //9
        }
        //log.trace(prod.toString());
        return prod;
    };

    private FilesIoRead() {
        throw new IllegalAccessError("Utility class");
    }

    public static void main(String[] args) {
        //testStripQuotesOk();
    }

    public static List<ProdFeed> readFileProdFeed(String file) {


        //
        processInputFileProdFeed(file);
        //
        List<ProdFeed> resList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1)) {
            //
            //List<String[]> rows = reader.readAll();
            //
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (isTestingWriting()) break;

                ProdFeed prod = new ProdFeed();
                int col = 0;
                if (nextLine.length > col) {
                    prod.setId(stripQuotes(nextLine[col]));
                    col++; //1
                }
                if (nextLine.length > col) {
                    prod.setName(stripQuotes(nextLine[col]));
                    col++; //2
                }
                if (nextLine.length > col) {
                    prod.setCode(stripQuotes(nextLine[col]));
                    col++;//3
                }
                if (nextLine.length > col) {
                    prod.setWarranty(stripQuotes(nextLine[col]));
                    col++; //4
                }
                if (nextLine.length > col) {
                    prod.setWarranty_type(stripQuotes(nextLine[col]));
                    col++; //5
                }
                if (nextLine.length > col) {
                    prod.setProduct_category_id(stripQuotes(nextLine[col]));
                    col++; //6
                }
                if (nextLine.length > col) {
                    prod.setProduct_category_name(stripQuotes(nextLine[col]));
                    col++; //7
                }
                if (nextLine.length > col) {
                    prod.setManufacturer_id(stripQuotes(nextLine[col]));
                    col++; //8
                }
                if (nextLine.length > col) {
                    prod.setManufacturer_name(stripQuotes(nextLine[col]));
                    col++; //9
                }
                if (nextLine.length > col) {
                    prod.setMin_quantity(stripQuotes(nextLine[col]));
                    col++; //10
                }
                if (nextLine.length > col) {
                    prod.setStock_value(stripQuotes(nextLine[col]));
                    col++; //11
                }
                if (nextLine.length > col) {
                    prod.setSupplier_stock_value(stripQuotes(nextLine[col]));
                    col++; //12
                }
                if (nextLine.length > col) {
                    prod.setSupplier_stock_delivery_date(stripQuotes(nextLine[col]));
                    col++; //13
                }
                if (nextLine.length > col) {
                    prod.setReserved_stock_value(stripQuotes(nextLine[col]));
                    col++; //14
                }
                if (nextLine.length > col) {
                    prod.setPrice(stripQuotes(nextLine[col]));
                    col++; //15
                }
                if (nextLine.length > col) {
                    prod.setSpecial_price(stripQuotes(nextLine[col]));
                    col++; //16
                }

                if (nextLine.length > col) {
                    prod.setCatalog_price(stripQuotes(nextLine[col]));
                    col++; //17
                }

                if (nextLine.length > col) {
                    prod.setGreen_stamp_value(stripQuotes(nextLine[col]));
                    col++; //18
                }
                if (nextLine.length > col) {
                    prod.setCurrency(stripQuotes(nextLine[col]));
                    col++; //19
                }
                if (nextLine.length > col) {
                    prod.setDiscount(stripQuotes(nextLine[col]));
                    col++; //20
                }
                if (nextLine.length > col) {
                    prod.setVat_percent(stripQuotes(nextLine[col]));
                    col++; //21
                }
                if (nextLine.length > col) {
                    prod.setHas_resealed(stripQuotes(nextLine[col]));
                    col++; //22
                }
                if (nextLine.length > col) {
                    prod.setDescription(cleanDesc(stripQuotes(nextLine[col])));
                    col++; //23
                }
                if (nextLine.length > col) {
                    prod.setRon_price(stripQuotes(nextLine[col]));
                    col++; //24
                }
                if (nextLine.length > col) {
                    prod.setRon_catalog_price(stripQuotes(nextLine[col]));
                    col++; //25
                }
                if (nextLine.length > col) {
                    prod.setPromo_price(stripQuotes(nextLine[col]));
                    col++; //26
                }
                if (nextLine.length > col) {
                    prod.setRon_promo_price(stripQuotes(nextLine[col]));
                    col++; //27
                }
                if (nextLine.length > col) {
                    prod.setOriginal_code(stripQuotes(nextLine[col]));
                    col++; //28
                }
                if (nextLine.length > col) {
                    prod.setDiscount_rate(stripQuotes(nextLine[col]));
                    col++; //29
                }
                //log.trace(prod.toString());
                resList.add(prod);
            }

        } catch (Exception e) {
            log.error("Error while reading file: " + file + " with error: " + e);
        }

        log.info(resList.size() + " ProdFeeds in file: " + file);
        return resList;
    }

    public static List<Manufacturer> readFileManufacturer(String file) {
        List<Manufacturer> resList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file), ';', '"', 1)) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (isTestingWriting()) break;

                Manufacturer manu = new Manufacturer();
                int col = 0;
                if (nextLine.length > col) {
                    manu.setID(stripQuotes(nextLine[col]));
                    col++; //1
                }
                if (nextLine.length > col) {
                    manu.setLogo(stripQuotes(nextLine[col]));
                    col++; //2
                }
                if (nextLine.length > col) {
                    manu.setNume(stripQuotes(nextLine[col]));
                    col++;//3
                }
                if (nextLine.length > col) {
                    manu.setAdrese(stripQuotes(nextLine[col]));
                    col++; //4
                }
                if (nextLine.length > col) {
                    manu.setProduse(stripQuotes(nextLine[col]));
                    col++; //5
                }
                if (nextLine.length > col) {
                    manu.setActiv(stripQuotes(nextLine[col]));
                    col++; //6
                }
                //log.trace(manu.toString());
                resList.add(manu);
            }

        } catch (FileNotFoundException e) {
            log.info("Error while reading file: " + file + " with error: " + e);
        } catch (IOException e) {
            log.error(e);
        }

        log.info(resList.size() + " Manufacturers in file: " + file);
        return resList;
    }

    public static List readFileCategory(String file) {
        List<Category> resList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file), ';', '"', 1)) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (isTestingWriting()) break;

                Category cat = new Category();
                int col = 0;
                if (nextLine.length > col) {
                    cat.setID(stripQuotes(nextLine[col]));
                    col++; //1
                }
                if (nextLine.length > col) {
                    cat.setNume(stripQuotes(nextLine[col]));
                    col++; //2
                }
                if (nextLine.length > col) {
                    cat.setDescriere(cleanDesc(stripQuotes(nextLine[col])));
                    col++;//3
                }
                if (nextLine.length > col) {
                    cat.setPozitie(stripQuotes(nextLine[col]));
                    col++; //4
                }
                if (nextLine.length > col) {
                    cat.setAfisat(stripQuotes(nextLine[col]));
                    col++; //5
                }
                //log.trace(cat.toString());
                resList.add(cat);
            }

        } catch (FileNotFoundException e) {
            log.info("Error while reading file: " + file + " with error: " + e);
        } catch (IOException e) {
            log.error(e);
        }

        log.info(resList.size() + " Categories in file: " + file);
        return resList;
    }

    public static List readFileProduct(String file) {
        List resList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1)) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (isTestingWriting()) break;

                Product prod = new Product();
                int col = 0;
                if (nextLine.length > col) {
                    prod.setId(stripQuotes(nextLine[col]));
                    col++; //1
                }
                if (nextLine.length > col) {
                    prod.setImagine(stripQuotes(nextLine[col]));
                    col++; //2
                }
                if (nextLine.length > col) {
                    prod.setReferinta(stripQuotes(nextLine[col]));
                    col++;//3
                }
                if (nextLine.length > col) {
                    prod.setCategorie(stripQuotes(nextLine[col]));
                    col++; //4
                }
                if (nextLine.length > col) {
                    prod.setPretDeBaza(stripQuotes(nextLine[col]));
                    col++; //5
                }
                if (nextLine.length > col) {
                    prod.setPretFinal(stripQuotes(nextLine[col]));
                    col++; //6
                }
                if (nextLine.length > col) {
                    prod.setCantitate(stripQuotes(nextLine[col]));
                    col++; //7
                }
                if (nextLine.length > col) {
                    prod.setStare(stripQuotes(nextLine[col]));
                    col++; //8
                }
                //log.trace(prod.toString());
                resList.add(prod);
            }

        } catch (FileNotFoundException e) {
            log.info("Error while reading file: " + file + " with error: " + e);
        } catch (IOException e) {
            log.error(e);
        }

        log.info(resList.size() + " Products in file: " + file);
        return resList;
    }

    public static List processInputFileProdFeed(String inputFilePath) {
        List inputList = new ArrayList<>();
        try {
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapToItemProdFeed).collect(Collectors.toList());
            br.close();
            inputFS.close();
        } catch (IOException e) {
            log.error(e);
        }
        log.trace(inputList.size() + " readed from " + inputFilePath);
        return inputList;
    }

    public static List processInputFileProduct(String inputFilePath) {
        List inputList = new ArrayList<>();
        try {
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapToItemProduct).collect(Collectors.toList());
            br.close();
            inputFS.close();
        } catch (IOException e) {
            log.error(e);
        }
        log.trace(inputList.size() + " readed from " + inputFilePath);
        return inputList;
    }
}
