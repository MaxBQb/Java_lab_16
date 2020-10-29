package app.Classes;

import app.Interfaces.IOrder;

// ОН ГОТОВ НЕ ТРОГАТЬ
public class TableOrder implements IOrder {

    // Заказчик
    private Customer customer;

    // Пункты заказа 
    private final List<MenuItem> items = new List<MenuItem>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean add(MenuItem item) {
        items.add(item);
        return true;
    }

    public String[] itemsNames() {
        String[] names = new String[items.size()];
        for (int i = 0; i < items.size(); i++)
            names[i] = items.get(i).getName();
        return names;
    }

    public int itemsQuantity() {
        return items.size();
    }

    public int itemQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < items.size(); i++)
            if (itemName.equals(items.get(i).getName()))
                count++;
        return count;
    }

    public int itemQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < items.size(); i++)
            if (item == items.get(i))
                count++;
        return count;
    }

    public MenuItem[] getItems() {
        return (MenuItem[]) items.toArray();
    }

    public boolean remove(String itemName) {
        for (int i = items.size() - 1; i >= 0; i--)
            if (items.get(i).getName().equals(itemName)) {
                items.remove(i);
                return true;
            }
        return false;
    }

    public boolean remove(MenuItem item) {
        return items.remove(item);
    }

    public int removeAll(String itemName) {
        int count = 0;
        while (remove(itemName))
            count++;
        return count;
    }

    public int removeAll(MenuItem item) {
        return items.removeAll(item);
    }

    public MenuItem[] sortedItemsByCostDescending() {
        List<MenuItem> tmp = new List<MenuItem>();
        tmp.sort(new java.util.Comparator<MenuItem>() {
            public int compare(MenuItem o1, MenuItem o2) {
                return -Double.compare(o1.getCost(), o2.getCost());
            }
        });
        return (MenuItem[]) tmp.toArray();
    }

    public int costTotal() {
        double sum = 0;
        for (int i = 0; i < items.size(); i++)
            sum += items.get(i).getCost();
        return (int) sum;
    }
}
