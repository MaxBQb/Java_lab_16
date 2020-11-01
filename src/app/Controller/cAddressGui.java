package app.Controller;
import app.Classes.Address;
import app.Controller.Validators.hasContent;
import app.Controller.Validators.isNumber;
import app.GUI.AddressGui;

import javax.swing.*;

public class cAddressGui {
    private Address current_address;

    public cAddressGui(AddressGui view) {
        int zipCode = (int)(Math.random()*10000);
        view.jLabel_code.setText(
                view.jLabel_code.getText().replace(
                        "ХХХХ",
                        ""+zipCode
                ));
        view.jTextArea_flat.setInputVerifier(new isNumber());
        view.jTextArea_house.setInputVerifier(new isNumber());
        view.jTextArea_street.setInputVerifier(new hasContent());
        view.jTextArea_city.setInputVerifier(new hasContent());
        view.jTextArea_building.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextArea)input).getText();
                if (text.length() > 1) {
                    JOptionPane.showMessageDialog(null,
                            "Поле может быть пустым, или содержать ровно 1 символ!",
                            "Ошибка!",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return false;
                }
                return true;
            }
        });

        view.button_ok.addActionListener(e -> {
            JTextArea[] fields = {
                    view.jTextArea_city,
                    view.jTextArea_street,
                    view.jTextArea_building,
                    view.jTextArea_house,
                    view.jTextArea_flat
            };
            for (JTextArea field: fields)
                if (field.getInputVerifier() != null &&
                        !field.getInputVerifier().verify(field))
                    return;
            try {
                String city = view.jTextArea_city.getText().strip();
                String street = view.jTextArea_street.getText().strip();
                String building_ = view.jTextArea_building.getText().strip();
                char building;
                if (building_.isBlank())
                    building = ' ';
                else
                    building = building_.charAt(0);
                int house = Integer.parseInt(view.jTextArea_house.getText());
                int flat = Integer.parseInt(view.jTextArea_flat.getText());
                current_address = new Address(city, zipCode, street, house, building, flat);
            } catch (Throwable ignore) {
                return;
            }
            view.dispose();
        });
    }

    public Address getAddress() {
        return current_address;
    }
}

