package app.Controller;
import app.Classes.Address;
import app.Classes.Customer;
import app.Controller.Validators.hasContent;
import app.Controller.Validators.isNumber;
import app.GUI.AddressGui;
import app.GUI.ChoiceTable;
import app.GUI.LogIn;
import app.GUI.Order;

import javax.swing.*;

public class cLogIn {
    private AddressGui get_address_panel;

    public cLogIn(LogIn view, boolean online) {
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
                    new Order(new Customer(name, surname, age, get_address_panel.controller.getAddress()));
                } else
                    new Order(new Customer(name, surname, age, Address.EMPTY_ADDRESS));
            } catch (Throwable ignore) {
                return;
            }
            view.dispose();
        });
        view.button_address.addActionListener(e -> {
            if (get_address_panel != null &&
                    get_address_panel.isVisible()
            ) return;
            get_address_panel = new AddressGui();
        });
    }
}
