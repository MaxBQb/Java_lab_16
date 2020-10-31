package app.GUI;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame{
    JLabel jLabel_name = new JLabel("Имя: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_name = new JTextArea(1, 10);
    JLabel jLabel_surname = new JLabel("Фамилия: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_surname = new JTextArea(1, 10);
    JLabel jLabel_age = new JLabel("Возраст: ", SwingConstants.CENTER);//, SwingConstants.CENTER
    JTextArea jTextArea_age = new JTextArea(1, 10);
    JButton button_address = new JButton("Адрес доставки");
    JButton button_ok = new JButton("OK");

    public LogIn() {
        super("Регистрация");
        setLayout(new GridLayout(4, 2, 1, 5));

        add(jLabel_name);
        add(jTextArea_name);
        add(jLabel_surname);
        add(jTextArea_surname);
        add(jLabel_age);
        add(jTextArea_age);
        add(button_address);
        add(button_ok);

        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        setVisible(true);
    }
}
