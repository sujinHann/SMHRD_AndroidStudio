package com.example.ex0414;

public class ProductVO {
    private int image;
    private int pro_name;
    private String pro_count;

    public ProductVO(int image, int pro_name, String pro_count) {
        this.image = image;
        this.pro_name = pro_name;
        this.pro_count = pro_count;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPro_name() {
        return pro_name;
    }

    public void setPro_name(int pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_count() {
        return pro_count;
    }

    public void setPro_count(String pro_count) {
        this.pro_count = pro_count;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "image=" + image +
                ", pro_name='" + pro_name + '\'' +
                ", pro_count='" + pro_count + '\'' +
                '}';
    }
}
