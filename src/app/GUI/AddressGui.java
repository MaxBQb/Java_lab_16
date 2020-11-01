package app.GUI;

import app.Controller.cAddressGui;
import javax.swing.*;
import java.awt.*;

public class AddressGui extends JFrame{
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
    public JLabel jLabel_code = new JLabel("Ваш код доставки: ХХХХ");
    public JButton button_ok = new JButton("OK");

    public AddressGui() {
        super("Адрес доставки");
        setLayout(new GridLayout(6, 2, 1, 5));

        add(jLabel_city);
        add(jTextArea_city);

        add(jLabel_street);
        add(jTextArea_street);

        add(jLabel_house);
        add(jTextArea_house);

        add(jLabel_building);
        add(jTextArea_building);

        add(jLabel_building);
        add(jTextArea_building);

        add(jLabel_flat);
        add(jTextArea_flat);

        add(jLabel_code);
        add(button_ok);

        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        new cAddressGui(this); // Связь View-Controller
        setVisible(true);
    }
}
