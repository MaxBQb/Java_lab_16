package app.Model;

// ОН ГОТОВ НЕ ТРОГАТЬ
public class MenuItem {

    // Цена
    private final double cost;

    // Название пункта заказа
    private final String name;

    // описание пункта заказа
    private final String description;

    public MenuItem(double cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
