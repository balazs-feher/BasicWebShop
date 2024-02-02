package com.greenfoxacademy.basicwebshop.Model;

import java.util.ArrayList;
import java.util.List;

public class ShopItem {

    private List<ShopItem> listOfStock = new ArrayList<>();
    public ShopItem(String name, String description, int price, int quantityOfStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityOfStock = quantityOfStock;
    }

    public ShopItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityOfStock() {
        return quantityOfStock;
    }

    public void setQuantityOfStock(int quantityOfStock) {
        this.quantityOfStock = quantityOfStock;
    }

    private String name;
    private String description;
    private double price;
    private int quantityOfStock;

    public void addToList(ShopItem shopItem){
        listOfStock.add(shopItem);
    }

    public List<ShopItem> getListOfStock(){
        return listOfStock;
    }
}
