package app.View;

import app.Model.Customer;
import app.Controller.cDeliveryAddress;

import javax.swing.*;
import java.awt.*;

public class DeliveryAddress extends JFrame {
    JLabel lbl_city = new JLabel("Название города: ", SwingConstants.CENTER);
    public JTextArea output_city = new JTextArea(1, 10);
    JLabel lbl_street = new JLabel("Название улицы: ", SwingConstants.CENTER);
    public JTextArea output_street = new JTextArea(1, 10);
    JLabel lbl_house = new JLabel("Дом: ", SwingConstants.CENTER);
    public JTextArea output_house = new JTextArea(1, 10);
    JLabel lbl_building = new JLabel("Корпус: ", SwingConstants.CENTER);
    public JTextArea output_building = new JTextArea(1, 10);
    JLabel lbl_flat = new JLabel("Квартира: ", SwingConstants.CENTER);
    public JTextArea output_flat = new JTextArea(1, 10);
    public JButton btn_submit = new JButton("OK");
    public cDeliveryAddress controller;

    public DeliveryAddress(Customer client) {
        super("Адрес доставки");
        setMinimumSize(new Dimension(300,220));
        setLayout(new GridLayout(6, 2, 1, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(lbl_city);
        output_city.setEditable(false);
        add(output_city);

        add(lbl_street);
        output_street.setEditable(false);
        add(output_street);

        add(lbl_house);
        output_house.setEditable(false);
        add(output_house);

        add(lbl_building);
        output_building.setEditable(false);
        add(output_building);

        add(lbl_building);
        output_building.setEditable(false);
        add(output_building);

        add(lbl_flat);
        output_flat.setEditable(false);
        add(output_flat);

        add(new JLabel()); // Skip cell
        add(btn_submit);
        setLocationRelativeTo(null); // отцентрировать окно

        controller = new cDeliveryAddress(this, client); // Связь View-Controller
        setVisible(true);
    }

    public DeliveryAddress() {
        this(Customer.MATURE_UNKNOWN_CUSTOMER);
    }
}
