package app.Classes;

import app.Interfaces.IOrder;
import app.Interfaces.OrdersManager;

// ОН ГОТОВ НЕ ТРОГАТЬ
public class TableOrdersManager implements OrdersManager {

    // Список заказов 1 заказ на 1 столик
    private final List<IOrder> orders;

    public TableOrdersManager(int size) {
        orders = new List(size, true);
    }

    public void add(IOrder order, int tableNumber) {
        orders.set(tableNumber, order);
    }

    public void addItem(MenuItem item, int tableNumber) {
        if (orders.get(tableNumber) == null)
            throw new RuntimeException("Столик свободен, невозможно добавить пункт заказа");
        orders.get(tableNumber).add(item);
    }

    public int freeTableNumber() {
        for (int i = 0; i < orders.size(); i++)
            if (orders.get(i) == null)
                return i;
        return -1;
    }

    public Integer[] freeTableNumbers() {
        List<Integer> countTable = new List<Integer>();
        for (int i = 0; i < orders.size(); i++)
            if (orders.get(i) == null)
                countTable.add(i);
        return (Integer[]) countTable.toArray();
    }

    public IOrder getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public void remove(int tableNumber) {
        orders.remove(tableNumber);
    }

    public int remove(IOrder order) {
        for (int i = 0; i < orders.size(); i++)
            if (orders.get(i) == order) {
                orders.remove(order);
                return i;
            }
        return -1;
    }

    public int removeAll(IOrder order) {
        return orders.removeAll(order);
    }


    public int itemsQuantity(String itemName) {
        int sum = 0;
        for (int i = 0; i < orders.size(); i++)
            sum += orders.get(i).itemQuantity(itemName);
        return sum;
    }


    public int itemsQuantity(MenuItem item) {
        int sum = 0;
        for (int i = 0; i < orders.size(); i++)
            sum += orders.get(i).itemQuantity(item);
        return sum;
    }

    public IOrder[] getOrders() {
        return (IOrder[]) orders.toArray();
    }

    public int ordersCostSummary() {
        int sum = 0;
        for (int i = 0; i < orders.size(); i++)
            sum += orders.get(i).costTotal();
        return sum;
    }

    public int ordersQuantity() {
        int count = 0;
        for (int i = 0; i < orders.size(); i++)
            if (orders.get(i) != null)
                count++;
        return count;
    }
}
