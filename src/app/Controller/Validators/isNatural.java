package app.Controller.Validators;

import javax.swing.*;

public class isNatural extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextArea)input).getText();
        try {
            if (Integer.parseInt(text) <= 0)
                throw new Exception();
            return true;
        } catch (Throwable ignore) {
            JOptionPane.showMessageDialog(null,
                    "Поле должно содержать натуральное число!",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        return false;
    }
}
