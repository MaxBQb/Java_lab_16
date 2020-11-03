package app.Model.Interfaces;

import app.Model.MenuItem;

// ОН ГОТОВ НЕ ТРОГАТЬ
public interface OrdersManager {
    int itemsQuantity(String itemName);

    int itemsQuantity(MenuItem itemName);

    IOrder[] getOrders();

    int ordersCostSummary();

    int ordersQuantity();
}
