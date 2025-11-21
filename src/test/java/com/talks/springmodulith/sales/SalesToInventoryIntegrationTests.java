package com.talks.springmodulith.sales;

import com.talks.springmodulith.inventory.api.InventoryFacade;
import com.talks.springmodulith.sales.api.OrderManagement;
import com.talks.springmodulith.sales.api.PlaceOrderRequest;
import com.talks.springmodulith.shared.events.OrderPlaced;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SalesToInventoryIntegrationTests {

  @Autowired InventoryFacade inventory;
  @Autowired OrderManagement orders;

  @Test
  void placing_order_reduces_inventory() {
    inventory.addStock("SKU-1", 10);

    orders.placeOrder(new PlaceOrderRequest(
        "order-1",
        List.of(new OrderPlaced.OrderLine("SKU-1", 3))
    ));

    assertThat(inventory.getStock("SKU-1")).isEqualTo(7);
  }
}
