package com.talks.springmodulith.inventory.internal;

import com.talks.springmodulith.inventory.api.InventoryFacade;
import com.talks.springmodulith.shared.events.OrderPlaced;
import com.talks.springmodulith.sales.api.OrderManagement; // intentional dependency to create cycle with sales
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
class InventoryService implements InventoryFacade {

  private final Map<String, Integer> stock = new ConcurrentHashMap<>();

  // private OrderManagement orders;

  @Override
  public void addStock(String sku, int quantity) {
    stock.merge(sku, quantity, Integer::sum);
  }

  @Override
  public int getStock(String sku) {
    return stock.getOrDefault(sku, 0);
  }

  @Override
  public Map<String, Integer> allStock() {
    return Collections.unmodifiableMap(stock);
  }

  @EventListener
  void on(OrderPlaced event) {
    for (var line : event.lines()) {
      stock.merge(line.sku(), -line.quantity(), Integer::sum);
    }
  }
}
