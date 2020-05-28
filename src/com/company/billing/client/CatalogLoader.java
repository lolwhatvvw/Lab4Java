package com.company.billing.client;

import com.company.warehouse.ItemCatalog;

public interface CatalogLoader {
    void load(ItemCatalog itemCatalog);
}