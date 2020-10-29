/*

import java.util.ArrayList;

public class InternetOrdersManager implements Interfaces.OrdersManager {
    private ArrayList<Interfaces.IOrder> arrayList = new ArrayList<Interfaces.IOrder>();

    private QueueNode tail;

    private int size;

    public boolean add(Interfaces.IOrder order) {
        return arrayList.add(order);
    }

    public Interfaces.IOrder remove() {
        return arrayList.remove(0);
    }

    public Interfaces.IOrder order;

    @Override
    public int itemsQuantity(String itemName) {
        return 0;
    }

    @Override
    public int itemsQuantity(MenuItem itemName) {
        return 0;
    }

    @Override
    public Interfaces.IOrder[] getOrders() {
        return new Interfaces.IOrder[0];
    }

    @Override
    public int ordersCostSummary() {
        return 0;
    }

    @Override
    public int ordersQuantity() {
        return 0;
    }
}

public class QueueNode {
    public QueueNode next;
    public QueueNode previous;
    public Interfaces.IOrder value;

}
*/