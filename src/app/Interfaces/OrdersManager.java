package app.Interfaces;

import app.Classes.MenuItem;

// ОН ГОТОВ НЕ ТРОГАТЬ
public interface OrdersManager {
    int itemsQuantity(String itemName);

    int itemsQuantity(MenuItem itemName);

    IOrder[] getOrders();

    int ordersCostSummary();

    int ordersQuantity();
}
