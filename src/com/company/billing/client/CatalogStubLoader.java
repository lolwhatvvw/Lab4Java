package com.company.billing.client;

import com.company.exceptions.CatalogLoadException;
import com.company.exceptions.ItemAlreadyExistsException;
import com.company.billing.stockList.Category;
import com.company.billing.stockList.FoodItem;
import com.company.billing.stockList.GenericItem;
import com.company.warehouse.ItemCatalog;

import java.util.Date;

public class CatalogStubLoader implements CatalogLoader {
    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV",23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread",12,null,new Date(),(short)10);
        try {
            catalog.addItem(item1);
            catalog.addItem(item2);
        }
        catch (ItemAlreadyExistsException ex) {
            throw new CatalogLoadException(ex);
        }

    }
}