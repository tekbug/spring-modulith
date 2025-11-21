package com.talks.springmodulith.sales.web;

import com.talks.springmodulith.sales.api.OrderManagement;
import com.talks.springmodulith.sales.api.PlaceOrderRequest;
import com.talks.springmodulith.shared.events.OrderPlaced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
class SalesController {

  private final OrderManagement orders;

  SalesController(OrderManagement orders) {
    this.orders = orders;
  }

  @PostMapping("/orders")
  ResponseEntity<OrderPlaced> place(@RequestBody PlaceOrderRequest request) {
    return ResponseEntity.ok(orders.placeOrder(request));
  }
}
