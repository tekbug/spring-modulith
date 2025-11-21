package com.talks.springmodulith.sales.internal;

import com.talks.springmodulith.sales.api.OrderManagement;
import com.talks.springmodulith.sales.api.PlaceOrderRequest;
import com.talks.springmodulith.shared.events.OrderPlaced;
import com.talks.springmodulith.inventory.api.InventoryFacade; // intentional dependency to create cycle with inventory
import java.time.Instant;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
class SalesOrderService implements OrderManagement {

  private final ApplicationEventPublisher events;

  // private InventoryFacade inventory;

  SalesOrderService(ApplicationEventPublisher events) {
    this.events = events;
  }

  @Override
  public OrderPlaced placeOrder(PlaceOrderRequest request) {
    var event = new OrderPlaced(request.orderId(), request.lines(), Instant.now());
    events.publishEvent(event);
    return event;
  }
}
