package com.talks.springmodulith.inventory.api;

import java.util.Map;

public interface InventoryFacade {
  void addStock(String sku, int quantity);
  int getStock(String sku);
  Map<String, Integer> allStock();
}
