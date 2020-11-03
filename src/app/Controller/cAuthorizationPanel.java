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

    public cAuthorizationPanel(AuthorizationPanel view, boolean is_online, int table_number) {
        view.btn_set_address.setVisible(is_online);
        view.input_age.setInputVerifier(new isNumber(1, 120));
        view.input_name.setInputVerifier(new hasContent());
        view.input_surname.setInputVerifier(new hasContent());
        view.btn_submit.addActionListener(e -> {
            JTextArea[] fields = {
                    view.input_name,
                    view.input_surname,
                    view.input_age
            };
            for (JTextArea field : fields)
                if (field.getInputVerifier() != null &&
                    !field.getInputVerifier().verify(field))
                    return;

            if (is_online && (get_address_panel == null ||
                get_address_panel.controller == null ||
                get_address_panel.controller.getAddress() == null)) {
                JOptionPane.showMessageDialog(null,
                        "Акажите адрес доставки!",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                String name = view.input_name.getText().strip();
                String surname = view.input_surname.getText().strip();
                int age = Integer.parseInt(view.input_age.getText());
                if (is_online) {
                    get_address_panel.dispose();
                    new OrderPanel(new Customer(name, surname, age, get_address_panel.controller.getAddress()));
                } else
                    new OrderPanel(new Customer(name, surname, age, Address.EMPTY_ADDRESS), table_number);
            } catch (Throwable ignore) {
                return;
            }
            view.dispose();
        });
        view.btn_set_address.addActionListener(e -> {
            if (get_address_panel != null && get_address_panel.isVisible())
                return;
            get_address_panel = new AddressInput();
        });
    }
}
