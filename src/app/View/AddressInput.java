package app.View;

import app.Controller.cAddressInput;
import javax.swing.*;
import java.awt.*;

public class AddressInput extends JFrame{
    JLabel lbl_city = new JLabel("Название города: ", SwingConstants.CENTER);
    public JTextArea input_city = new JTextArea(1, 10);
    JLabel lbl_street = new JLabel("Название улицы: ", SwingConstants.CENTER);
    public JTextArea input_street = new JTextArea(1, 10);
    JLabel lbl_building = new JLabel("Дом: ", SwingConstants.CENTER);
    public JTextArea input_building = new JTextArea(1, 10);
    JLabel lbl_building_letter = new JLabel("Корпус: ", SwingConstants.CENTER);
    public JTextArea input_building_letter = new JTextArea(1, 10);
    JLabel lbl_flat = new JLabel("Квартира: ", SwingConstants.CENTER);
    public JTextArea input_flat = new JTextArea(1, 10);
    public JLabel lbl_zip_code = new JLabel("Ваш код доставки: ХХХХ");
    public JButton btn_submit = new JButton("OK");
    public cAddressInput controller;

    public AddressInput() {
        super("Адрес доставки");
        setLayout(new GridLayout(6, 2, 1, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(lbl_city);
        add(input_city);

        add(lbl_street);
        add(input_street);

        add(lbl_building);
        add(input_building);

        add(lbl_building_letter);
        add(input_building_letter);

        add(lbl_building_letter);
        add(input_building_letter);

        add(lbl_flat);
        add(input_flat);

        add(lbl_zip_code);
        add(btn_submit);

        pack(); // Ужать окно
        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cAddressInput(this); // Связь View-Controller
        setVisible(true);
    }
}
