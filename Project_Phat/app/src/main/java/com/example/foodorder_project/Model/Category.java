package com.example.foodorder_project.Model;


public class Category {
    public String nameCategory;

    public Category() {
    }

    public Category(String nameCategory) {
//        this.image = image;
        this.nameCategory = nameCategory;
    }
//    public int getImage(){
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
