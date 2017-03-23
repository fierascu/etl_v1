package com.bst.data;

import java.util.Random;

import static com.bst.utils.Utils.OTHERS_DEFAULT_CATEGORY_NAME;

public class CatPojo {
    //id;Active (0/1);Name*;Parent Category;Root category (0/1);Description;Meta-title;Meta-keywords;Meta-description;URL rewritten;Image URL;ID ou nom de la boutique
    public String id = "";
    public String active = "1";
    public String name;
    public String parentCategory;
    public String rootCategory;
    public String description;
    public String metaTitle;
    public String metaKeywords;
    public String metaDescription;
    public String urlRewritten;
    public String imageUrl = "";
    public String storeId = "1";

    public CatPojo() {
        id = "" + new Random().nextInt(1000000);
    }

    public CatPojo(String idC, String nameC, String parentCategoryC, String rootCategoryC) {
        id = idC;
        name = nameC;
        parentCategory = parentCategoryC;
        rootCategory = rootCategoryC;
    }

    public static String getCategoryOrDefaultCat(String category) {
        return category.isEmpty() ? OTHERS_DEFAULT_CATEGORY_NAME : category;
    }

    @Override
    public String toString() {
        return name;
    }
}
