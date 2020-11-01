package app.Classes;

// ОН ГОТОВ НЕ ТРОГАТЬ
public final class Address {

    // Адрес не указан
    public static final Address EMPTY_ADDRESS = new Address("", 0, "", 0, ' ', 0);

    // Название города
    private final String cityName;

    // Код доставки
    private int zipCode;

    // Название улицы
    private final String streetName;

    // Название дома
    private final int buildingNumber;

    // Буква корпуса
    private final char buildingLetter;

    // Номер квартиры
    private final int apartmentNumber;

    public Address(String cityName, int zipCode,
                   String streetName, int buildingNumber,
                   char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
