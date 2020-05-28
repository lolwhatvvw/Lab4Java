package com.company.billing.client;

import com.company.billing.stockList.Category;
import com.company.billing.stockList.FoodItem;
import com.company.billing.stockList.GenericItem;
import com.company.billing.stockList.TechnicalItem;
import com.company.warehouse.ItemCatalog;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ItemCatalog itemCatalog = new ItemCatalog();
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(itemCatalog);
        itemCatalog.printItems();
        GenericItem genericItem1 = new GenericItem("Headphones", 5000.0f, Category.GENERAL);
        GenericItem genericItem2 = new GenericItem("Iphone", 10000000000.00f, Category.GENERAL);
        GenericItem genericItem3 = new GenericItem("Great Xiaomi", 1.0f, Category.GENERAL);

        Date date = new Date();
        short expires = 10;
        short warrantyTime = 25;

        FoodItem foodItem1 = new FoodItem("milk", 10.0f, null, Category.FOOD, date, expires);
        FoodItem foodItem2 = new FoodItem("bread", 5.0f, foodItem1, Category.FOOD, date, expires);
        TechnicalItem technicalItem1 = new TechnicalItem(11, "technic", 1000.0f, null, Category.GENERAL, warrantyTime);
        FoodItem foodItem3 = new FoodItem("lime", 5.0f, expires);
        FoodItem foodItem4 = new FoodItem("orange", 5.0f, expires);
        FoodItem foodItem5 = new FoodItem("apple", 5.0f, expires);
        GenericItem genericItem = new GenericItem("Eggs", 5050.0f, Category.GENERAL);
        itemCatalog.addItem(genericItem1);
        itemCatalog.addItem(genericItem2);
        itemCatalog.addItem(genericItem3);
        itemCatalog.addItem(foodItem1);
        itemCatalog.addItem(foodItem2);
        itemCatalog.addItem(technicalItem1);
        itemCatalog.addItem(foodItem3);
        itemCatalog.addItem(foodItem4);
        itemCatalog.addItem(foodItem5);
        itemCatalog.addItem(genericItem);

        long begin = new Date().getTime();

        for(int i=0; i<100000;i++)
            itemCatalog.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end - begin));
        begin = new Date().getTime();
        for(int i=0; i<100000;i++)
            itemCatalog.findItemByIDInArrayList(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end - begin));

    }
}