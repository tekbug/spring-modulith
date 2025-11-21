package com.talks.springmodulith.inventory.web;

import com.talks.springmodulith.inventory.api.InventoryFacade;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
class InventoryController {

  private final InventoryFacade inventory;

  InventoryController(InventoryFacade inventory) {
    this.inventory = inventory;
  }

  record AddStockRequest(String sku, int quantity) {}

  @PostMapping("/stock")
  ResponseEntity<Void> add(@RequestBody AddStockRequest request) {
    inventory.addStock(request.sku(), request.quantity());
    return ResponseEntity.accepted().build();
  }

  @GetMapping("/stock/{sku}")
  ResponseEntity<Integer> get(@PathVariable String sku) {
    return ResponseEntity.ok(inventory.getStock(sku));
  }

  @GetMapping("/stock")
  ResponseEntity<Map<String, Integer>> all() {
    return ResponseEntity.ok(inventory.allStock());
  }
}
