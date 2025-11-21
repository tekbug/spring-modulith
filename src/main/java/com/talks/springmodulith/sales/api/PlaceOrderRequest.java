package com.talks.springmodulith.sales.api;

import com.talks.springmodulith.shared.events.OrderPlaced;
import java.util.List;

public record PlaceOrderRequest(String orderId, List<OrderPlaced.OrderLine> lines) {
}
