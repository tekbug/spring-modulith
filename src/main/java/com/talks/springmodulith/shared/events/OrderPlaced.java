package com.talks.springmodulith.shared.events;

import java.time.Instant;
import java.util.List;

/**
 * Shared domain event published by the Sales module and consumed by other modules.
 */
public record OrderPlaced(String orderId, List<OrderLine> lines, Instant placedAt) {

  public record OrderLine(String sku, int quantity) {}
}
