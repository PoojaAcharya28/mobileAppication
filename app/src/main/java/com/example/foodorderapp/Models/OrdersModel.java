package com.example.foodorderapp.Models;

public class OrdersModel {

    int orderImage;
    String soldItemName,price,orderNumber, itemQuantity;


    public OrdersModel(int orderImage, String soldItemName, String price, String orderNumber, int itemQuantity) {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
        this.itemQuantity = String.valueOf(itemQuantity);
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
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity){
        this.itemQuantity = String.valueOf(itemQuantity);
    }
}
