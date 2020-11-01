package app.Classes;

// ОН ГОТОВ НЕ ТРОГАТЬ
public class Customer {

    // Неизвесный клиент в летах
    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(
            "Неизвесный", "покупатель", 100, Address.EMPTY_ADDRESS);

    // Неизвесный молодой клиент
    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(
            "Неизвесный", "покупатель", 0, Address.EMPTY_ADDRESS);

    // Имя
    private final String firstName;

    // Фамилия
    private final String secondName;

    // Возраст
    private final int age;

    // Адрес доставки
    private final Address address;

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
