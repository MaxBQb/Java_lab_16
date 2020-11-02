package app.Classes;

import app.Exceptions.IllegalTableNumber;
import app.Interfaces.Alcoholable;

// ОН ГОТОВ НЕ ТРОГАТЬ
public final class Drink extends MenuItem implements Alcoholable {

    // Содержание спирта в напитке
    private final double alcoholVol;

    // Тип напитка
    private final DrinkTypeEnum type;

    public Drink(String name, String description, DrinkTypeEnum type) throws IllegalTableNumber {
        this(0, name, description, 0, type);
    }

    public Drink(double cost,
          String name,
          String description,
          double alcoholVol,
          DrinkTypeEnum type) throws IllegalArgumentException {
        super(cost, name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
        if (super.getCost() < 0 || alcoholVol < 0 || type == null ||
                super.getName() == null || super.getName().isBlank() ||
                super.getDescription() == null || super.getDescription().isBlank())
            throw new IllegalArgumentException("Ошибка в аргументе!");
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    public double getAlcoholVol() {
        return alcoholVol;
    }

    public boolean isAlcoholicDrink() {
        return alcoholVol > 0;
    }

    public String toString() {
        return "Название: " + super.getName() + ", " +
                "цена: " + super.getCost() + "₽, " +
                (!super.getDescription().equals("") ? "описание: " + super.getDescription() : "") +
                "Напиток: " + type + ", " + "Содержание алкоголя в одном литре: " + alcoholVol + "";
    }
}
