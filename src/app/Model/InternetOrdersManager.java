package app.Model;
import app.Model.Interfaces.IOrder;
import app.Model.Interfaces.OrdersManager;

public class InternetOrdersManager implements OrdersManager {

    // Начало списка заказов
    private QueueNode head;

    // Конец списка заказов
    private QueueNode tail;

    // Размер списка
    private int size;

    public InternetOrdersManager() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean addOrder(IOrder order) {
        size++;
        if (tail == null) {
            tail = new QueueNode(order);
            head = tail;
            return true;
        }
        tail.next = new QueueNode(order, tail, null);
        tail = tail.next;
        return true;
    }

    public IOrder removeOrder() {
        if (head == null)
            return null;
        size--;
        IOrder value = head.value;
        head = head.next;
        return value;
    }

    public IOrder order() {
        if (head == null)
            return null;
        return head.value;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        QueueNode current = head;
        while (current != null) {
            count += current.value.itemQuantity(itemName);
            current = current.next;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        QueueNode current = head;
        while (current != null) {
            count += current.value.itemQuantity(item);
            current = current.next;
        }
        return count;
    }

    @Override
    public IOrder[] getOrders() {
        IOrder[] array = new IOrder[size];
        QueueNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public int ordersCostSummary() {
        int sum = 0;
        QueueNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            sum += current.value.costTotal();
            current = current.next;
        }
        return sum;
    }

    @Override
    public int ordersQuantity() {
        int count = 0;
        QueueNode current = head;
        for (int i = 0; current != null && i < size; i++) {
            count += current.value.itemsQuantity();
            current = current.next;
        }
        return count;
    }

    class QueueNode {
        public QueueNode next;
        public QueueNode previous;
        public IOrder value;

        public QueueNode(IOrder value, QueueNode previous, QueueNode next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public QueueNode(IOrder value) {
            this(value, null, null);
        }
    }
}
