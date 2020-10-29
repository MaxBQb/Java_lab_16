package app.Classes;

import app.Exceptions.IllegalTableNumber;

// ОН ГОТОВ НЕ ТРОГАТЬ
public final class Dish extends MenuItem {

    Dish(String name, String description) throws IllegalTableNumber {
        this(0, name, description);
    }

    Dish(double cost, String name, String description) throws IllegalArgumentException {
        super(cost, name, description);
        if (super.getCost() < 0 || super.getName() == null ||
                super.getName().isBlank() || super.getName() == null ||
                super.getDescription().isBlank())
            throw new IllegalArgumentException("Ошибка в аргументе!");
    }

    public double getCost() {
        return super.getCost();
    }

    public Dish setCost(double cost) throws IllegalTableNumber {
        return new Dish(cost, super.getName(), super.getDescription());
    }

    public String getName() {
        return super.getName();
    }

    public Dish setName(String name) throws IllegalTableNumber {
        return new Dish(super.getCost(), name, super.getDescription());
    }

    public String getDescription() {
        return super.getDescription();
    }

    public Dish setDescription(String description) throws IllegalTableNumber {
        return new Dish(super.getCost(), super.getName(), description);
    }

    public String toString() {
        return "Блюдо " + super.getName() + ", " +
                "цена: " + super.getCost() + "₽, " +
                (!super.getDescription().equals("") ? "описание: " + super.getDescription() : "");
    }
}
