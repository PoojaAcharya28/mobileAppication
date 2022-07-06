package com.example.foodorderapp.Models;

public class OrdersModel {

    int orderImage;
    String soldItemName,price,orderNumber, itemCount;


    public OrdersModel(int orderImage, String soldItemName, String price, String orderNumber, int itemCount) {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
        this.itemCount = String.valueOf(itemCount);
    }

    public OrdersModel() {

    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemQuantity(){
        return itemCount;
    }

    public void setItemQuantity(int itemCount){
        this.itemCount = String.valueOf(itemCount);
    }
}
