package com.talks.springmodulith.sales.api;

import com.talks.springmodulith.shared.events.OrderPlaced;

/**
 * Public API of the Sales module. Exposed as a NamedInterface for other modules/adapters (like REST) to use.
 */
public interface OrderManagement {

  /**
   * Places an order and returns the published domain event.
   */
  OrderPlaced placeOrder(PlaceOrderRequest request);
}
