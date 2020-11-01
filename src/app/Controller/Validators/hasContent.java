package app.Controller.Validators;

import javax.swing.*;

public class hasContent extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextArea)input).getText();
        if (text.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Поле не может быть пустым!",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        return true;
    }
}
