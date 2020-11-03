package app.Controller;
import app.Model.Address;
import app.Model.Customer;
import app.Controller.Validators.hasContent;
import app.Controller.Validators.isNumber;
import app.View.AddressInput;
import app.View.AuthorizationPanel;
import app.View.OrderPanel;

import javax.swing.*;

public class cAuthorizationPanel {
    private AddressInput get_address_panel;

    public cAuthorizationPanel(AuthorizationPanel view, boolean online, int table) {
        view.button_address.setVisible(online);
        view.jTextArea_age.setInputVerifier(new isNumber(1, 120));
        view.jTextArea_name.setInputVerifier(new hasContent());
        view.jTextArea_surname.setInputVerifier(new hasContent());
        view.button_ok.addActionListener(e -> {
            JTextArea[] fields = {
                    view.jTextArea_name,
                    view.jTextArea_surname,
                    view.jTextArea_age
            };
            for (JTextArea field : fields)
                if (field.getInputVerifier() != null &&
                        !field.getInputVerifier().verify(field))
                    return;

            if (online && (get_address_panel == null ||
                    get_address_panel.controller == null ||
                    get_address_panel.controller.getAddress() == null
            )) {
                JOptionPane.showMessageDialog(null,
                        "Акажите адрес доставки!",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                String name = view.jTextArea_name.getText().strip();
                String surname = view.jTextArea_surname.getText().strip();
                int age = Integer.parseInt(view.jTextArea_age.getText());
                if (online) {
                    get_address_panel.dispose();
                    new OrderPanel(new Customer(name, surname, age, get_address_panel.controller.getAddress()));
                } else
                    new OrderPanel(new Customer(name, surname, age, Address.EMPTY_ADDRESS), table);
            } catch (Throwable ignore) {
                return;
            }
            view.dispose();
        });
        view.button_address.addActionListener(e -> {
            if (get_address_panel != null &&
                    get_address_panel.isVisible()
            ) return;
            get_address_panel = new AddressInput();
        });
    }
}
