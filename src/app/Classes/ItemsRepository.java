package app.Classes;

public final class ItemsRepository {
    private static Dish[] dishes = new Dish[] {
            new Dish(90, "Афганское печенье", "После одного укуса ловишь флэшбеки *флэшбэки включены в стоимость"),
            new Dish(300, "Баклажанная икра", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Банановый торт", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Баурсак", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Блины", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Бублик", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Буррито", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Бутерброд", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Бэлиш", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Вареники", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Ватрушка", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Голубцы", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Гренки", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Греческий салат", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Борщ", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Щи", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Плов", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Лазанья", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Пицца", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Винегрет", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Оливье", "После одного укуса ловишь флэшбеки"),
            new Dish(324, "Дынная булочка", "После одного укуса ловишь флэшбеки")
    };

    private static Drink[] drinks = new Drink[] {
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Beer),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Wine),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Vodka),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Brandy),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Champagne),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Whiskey),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Tequila),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Rum),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Vermuth),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Liquor),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Jagermeister),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Juice),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Juice),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Juice),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Coffee),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Coffee),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Green_tea),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Black_tea),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Milk),
            new Drink(1000, "Пиво от Михалыча", "Пиво недорого! ", 10, DrinkTypeEnum.Water),
            new Drink(1000, "Pepsi", "Пиво недорого! ", 10, DrinkTypeEnum.Soda),
            new Drink(1000, "Fanta", "Пиво недорого! ", 10, DrinkTypeEnum.Soda)
    };

    public static int dishesLength() {
        return dishes.length;
    }

    public static int drinksLength() {
        return drinks.length;
    }

    public static Dish getDish(int index) {
        return dishes[index];
    }

    public static Drink getDrink(int index) {
        return drinks[index];
    }
}
