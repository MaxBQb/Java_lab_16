package app.Controller.Validators;

import javax.swing.*;

public class isNumber extends InputVerifier {
    int maximum;
    int minimum;

    public isNumber(int min_value, int max_value) {
        super();
        maximum = max_value;
        minimum = min_value;
    }

    public isNumber() {
        this(1, Integer.MAX_VALUE);
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextArea)input).getText();
        try {
            int value = Integer.parseInt(text);
            if (value < minimum || value > maximum)
                throw new Exception();
            return true;
        } catch (Throwable ignore) {
            String message = "Поле должно содержать ";
            if (minimum == 1)
                message += "натуральное число";
            else
                message += "целое число, больше "+minimum;

            if (maximum != Integer.MAX_VALUE)
                message += ", меньше "+maximum;

            message += '!';
            JOptionPane.showMessageDialog(null,
                    message,
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        return false;
    }
}
