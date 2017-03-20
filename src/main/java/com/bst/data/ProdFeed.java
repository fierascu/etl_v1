package com.bst.data;

public class ProdFeed {
    //id	name	code	warranty	warranty_type	product_category_id	product_category_name	manufacturer_id	manufacturer_name	min_quantity	stock_value	supplier_stock_value	supplier_stock_delivery_date	reserved_stock_value	price	special_price	catalog_price	green_stamp_value	currency	discount	vat_percent	has_resealed	description	ron_price	ron_catalog_price	promo_price	ron_promo_price	original_code	discount_rate

    private String id;
    private String name;
    private String code;
    private String warranty;
    private String warranty_type;
    private String product_category_id;
    private String product_category_name;
    private String manufacturer_id;
    private String manufacturer_name;
    private String min_quantity;
    private String stock_value;
    private String supplier_stock_value;
    private String supplier_stock_delivery_date;
    private String reserved_stock_value;
    private String price;
    private String special_price;
    private String catalog_price;
    private String green_stamp_value;
    private String currency;
    private String discount;
    private String vat_percent;
    private String has_resealed;
    private String description;
    private String ron_price;
    private String ron_catalog_price;
    private String promo_price;
    private String ron_promo_price;
    private String original_code;
    private String discount_rate;

    @Override
    public String toString() {
        return "ProdFeed{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", warranty='" + warranty + '\'' +
                ", warranty_type='" + warranty_type + '\'' +
                ", product_category_id='" + product_category_id + '\'' +
                ", product_category_name='" + product_category_name + '\'' +
                ", manufacturer_id='" + manufacturer_id + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", min_quantity='" + min_quantity + '\'' +
                ", stock_value='" + stock_value + '\'' +
                ", supplier_stock_value='" + supplier_stock_value + '\'' +
                ", supplier_stock_delivery_date='" + supplier_stock_delivery_date + '\'' +
                ", reserved_stock_value='" + reserved_stock_value + '\'' +
                ", price='" + price + '\'' +
                ", special_price='" + special_price + '\'' +
                ", catalog_price='" + catalog_price + '\'' +
                ", green_stamp_value='" + green_stamp_value + '\'' +
                ", currency='" + currency + '\'' +
                ", discount='" + discount + '\'' +
                ", vat_percent='" + vat_percent + '\'' +
                ", has_resealed='" + has_resealed + '\'' +
                ", description='" + description + '\'' +
                ", ron_price='" + ron_price + '\'' +
                ", ron_catalog_price='" + ron_catalog_price + '\'' +
                ", promo_price='" + promo_price + '\'' +
                ", ron_promo_price='" + ron_promo_price + '\'' +
                ", original_code='" + original_code + '\'' +
                ", discount_rate='" + discount_rate + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getWarranty_type() {
        return warranty_type;
    }

    public void setWarranty_type(String warranty_type) {
        this.warranty_type = warranty_type;
    }

    public String getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(String product_category_id) {
        this.product_category_id = product_category_id;
    }

    public String getProduct_category_name() {
        return product_category_name;
    }

    public void setProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
    }

    public String getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(String manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public String getMin_quantity() {
        return min_quantity;
    }

    public void setMin_quantity(String min_quantity) {
        this.min_quantity = min_quantity;
    }

    public String getStock_value() {
        return stock_value;
    }

    public void setStock_value(String stock_value) {
        this.stock_value = stock_value;
    }

    public String getSupplier_stock_value() {
        return supplier_stock_value;
    }

    public void setSupplier_stock_value(String supplier_stock_value) {
        this.supplier_stock_value = supplier_stock_value;
    }

    public String getSupplier_stock_delivery_date() {
        return supplier_stock_delivery_date;
    }

    public void setSupplier_stock_delivery_date(String supplier_stock_delivery_date) {
        this.supplier_stock_delivery_date = supplier_stock_delivery_date;
    }

    public String getReserved_stock_value() {
        return reserved_stock_value;
    }

    public void setReserved_stock_value(String reserved_stock_value) {
        this.reserved_stock_value = reserved_stock_value;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecial_price() {
        return special_price;
    }

    public void setSpecial_price(String special_price) {
        this.special_price = special_price;
    }

    public String getCatalog_price() {
        return catalog_price;
    }

    public void setCatalog_price(String catalog_price) {
        this.catalog_price = catalog_price;
    }

    public String getGreen_stamp_value() {
        return green_stamp_value;
    }

    public void setGreen_stamp_value(String green_stamp_value) {
        this.green_stamp_value = green_stamp_value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getVat_percent() {
        return vat_percent;
    }

    public void setVat_percent(String vat_percent) {
        this.vat_percent = vat_percent;
    }

    public String getHas_resealed() {
        return has_resealed;
    }

    public void setHas_resealed(String has_resealed) {
        this.has_resealed = has_resealed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRon_price() {
        return ron_price;
    }

    public void setRon_price(String ron_price) {
        this.ron_price = ron_price;
    }

    public String getRon_catalog_price() {
        return ron_catalog_price;
    }

    public void setRon_catalog_price(String ron_catalog_price) {
        this.ron_catalog_price = ron_catalog_price;
    }

    public String getPromo_price() {
        return promo_price;
    }

    public void setPromo_price(String promo_price) {
        this.promo_price = promo_price;
    }

    public String getRon_promo_price() {
        return ron_promo_price;
    }

    public void setRon_promo_price(String ron_promo_price) {
        this.ron_promo_price = ron_promo_price;
    }

    public String getOriginal_code() {
        return original_code;
    }

    public void setOriginal_code(String original_code) {
        this.original_code = original_code;
    }

    public String getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(String discount_rate) {
        this.discount_rate = discount_rate;
    }

}
