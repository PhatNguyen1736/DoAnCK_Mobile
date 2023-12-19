package com.example.foodorder_project.Model;

public class MenuChitiet {
    private String evaluation;
    private int imgheart;
    private int imgfood;
    private String foodname;
    private String price;

    public MenuChitiet(String evaluation, int imgheart, int imgfood, String foodname, String price) {
        this.evaluation = evaluation;
        this.imgheart = imgheart;
        this.imgfood = imgfood;
        this.foodname = foodname;
        this.price = price;
    }

    public String getEveluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
    public int getImgheart() {
        return imgheart;
    }

    public void setImgheart(int imgheart) {
        this.imgheart = imgheart;
    }

    public int getImgfood() {
        return imgfood;
    }

    public void setImgfood(int imgfood) {
        this.imgfood = imgfood;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
