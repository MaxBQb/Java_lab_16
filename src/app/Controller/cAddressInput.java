package app.Controller;
import app.Model.Address;
import app.Controller.Validators.hasContent;
import app.Controller.Validators.isNumber;
import app.View.AddressInput;

import javax.swing.*;

public class cAddressInput {
    private Address current_address;

    public cAddressInput(AddressInput view) {
        int zip_code = (int)(Math.random()*10000);
        view.lbl_zip_code.setText(
                view.lbl_zip_code.getText().replace(
                        "ХХХХ",
                        ""+zip_code
                ));
        view.input_flat.setInputVerifier(new isNumber());
        view.input_building.setInputVerifier(new isNumber());
        view.input_street.setInputVerifier(new hasContent());
        view.input_city.setInputVerifier(new hasContent());
        view.input_building_letter.setInputVerifier(new InputVerifier() {
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

        view.btn_submit.addActionListener(e -> {
            JTextArea[] fields = {
                    view.input_city,
                    view.input_street,
                    view.input_building_letter,
                    view.input_building,
                    view.input_flat
            };
            for (JTextArea field: fields)
                if (field.getInputVerifier() != null &&
                        !field.getInputVerifier().verify(field))
                    return;
            try {
                String city = view.input_city.getText().strip();
                String street = view.input_street.getText().strip();
                String building_letter_buffer = view.input_building_letter.getText().strip();
                char building_letter;
                if (building_letter_buffer.isBlank())
                    building_letter = ' ';
                else
                    building_letter = building_letter_buffer.charAt(0);
                int building = Integer.parseInt(view.input_building.getText());
                int flat = Integer.parseInt(view.input_flat.getText());
                current_address = new Address(city, zip_code, street, building, building_letter, flat);
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

