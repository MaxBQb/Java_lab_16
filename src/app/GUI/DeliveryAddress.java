package app.GUI;

import app.Classes.Customer;
import app.Controller.cDeliveryAddress;

import javax.swing.*;
import java.awt.*;

public class DeliveryAddress extends JFrame {
    JLabel jLabel_city = new JLabel("Название города: ", SwingConstants.CENTER);
    public JTextArea jTextArea_city  = new JTextArea(1, 10);
    JLabel jLabel_street = new JLabel("Название улицы: ", SwingConstants.CENTER);
    public JTextArea jTextArea_street  = new JTextArea(1, 10);
    JLabel jLabel_house = new JLabel("Дом: ", SwingConstants.CENTER);
    public JTextArea jTextArea_house  = new JTextArea(1, 10);
    JLabel jLabel_building = new JLabel("Корпус: ", SwingConstants.CENTER);
    public JTextArea jTextArea_building  = new JTextArea(1, 10);
    JLabel jLabel_flat = new JLabel("Квартира: ", SwingConstants.CENTER);
    public JTextArea jTextArea_flat = new JTextArea(1, 10);
    JLabel jLabel_void = new JLabel("");
    public JButton button_ok = new JButton("OK");
    public cDeliveryAddress controller;

    public DeliveryAddress(Customer client) {
        super("Адрес доставки");
        setMinimumSize(new Dimension(300,220));
        setLayout(new GridLayout(6, 2, 1, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(jLabel_city);
        jTextArea_city.setEditable(false);
        add(jTextArea_city);

        add(jLabel_street);
        jTextArea_street.setEditable(false);
        add(jTextArea_street);

        add(jLabel_house);
        jTextArea_house.setEditable(false);
        add(jTextArea_house);

        add(jLabel_building);
        jTextArea_building.setEditable(false);
        add(jTextArea_building);

        add(jLabel_building);
        jTextArea_building.setEditable(false);
        add(jTextArea_building);

        add(jLabel_flat);
        jTextArea_flat.setEditable(false);
        add(jTextArea_flat);

        add(jLabel_void);
        add(button_ok);
        setLocationRelativeTo(null); // отцентрировать окно

        controller = new cDeliveryAddress(this, client); // Связь View-Controller
        setVisible(true);
    }

    public DeliveryAddress() {
        this(Customer.MATURE_UNKNOWN_CUSTOMER);
    }
}
