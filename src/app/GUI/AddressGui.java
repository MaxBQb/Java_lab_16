package app.GUI;

import javax.swing.*;
import java.awt.*;

public class AddressGui extends JFrame{
    JLabel jLabel_city = new JLabel("Название города: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_city  = new JTextArea(1, 10);
    JLabel jLabel_street = new JLabel("Название улицы: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_street  = new JTextArea(1, 10);
    JLabel jLabel_house = new JLabel("Дом: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_house  = new JTextArea(1, 10);
    JLabel jLabel_building = new JLabel("Корпус: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_building  = new JTextArea(1, 10);
    JLabel jLabel_flat = new JLabel("Квартира: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_flat = new JTextArea(1, 10);
    JLabel jLabel_code = new JLabel("Ваш код доставки: ХХХХ");//, SwingConstants.CENTER
    JButton button_ok = new JButton("OK");

    public AddressGui() {
        super("Укажите адрес доставки");
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
        setVisible(true);
    }
}
