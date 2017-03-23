package com.bst.data;

public class ProdFeedImage {
    private String prodFeedId;
    private String prodFeedCode;
    private String prodPojoImage;
    private String imageThumb;


    public ProdFeedImage() {
    }

    public ProdFeedImage(String img) {
        setProdPojoImage(img);
    }

    @Override
    public String toString() {
        return "ProdFeedImage{" +
                "prodFeedId='" + prodFeedId + '\'' +
                ", prodFeedCode='" + prodFeedCode + '\'' +
                ", prodPojoImage='" + prodPojoImage + '\'' +
                ", imageThumb='" + imageThumb + '\'' +
                '}';
    }

    public String getProdFeedId() {
        return prodFeedId;
    }

    public void setProdFeedId(String prodFeedId) {
        this.prodFeedId = prodFeedId;
    }

    public String getProdFeedCode() {
        return prodFeedCode;
    }

    public void setProdFeedCode(String prodFeedCode) {
        this.prodFeedCode = prodFeedCode;
    }

    public String getProdPojoImage() {
        return prodPojoImage;
    }

    public void setProdPojoImage(String prodPojoImage) {
        this.prodPojoImage = prodPojoImage;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }
}
