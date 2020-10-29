package app.Exceptions;

// ОН ГОТОВ НЕ ТРОГАТЬ
public class OrderAlreadyAddedException extends Exception {
    OrderAlreadyAddedException(String message) {
        super(message);
    }
}

