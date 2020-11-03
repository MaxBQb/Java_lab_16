package app.View;

import app.Controller.cAuthorizationPanel;
import javax.swing.*;
import java.awt.*;

public class AuthorizationPanel extends JFrame{
    JLabel jLabel_name = new JLabel("Имя: ", SwingConstants.CENTER);
    public JTextArea jTextArea_name = new JTextArea(1, 10);
    JLabel jLabel_surname = new JLabel("Фамилия: ", SwingConstants.CENTER);
    public JTextArea jTextArea_surname = new JTextArea(1, 10);
    JLabel jLabel_age = new JLabel("Возраст: ", SwingConstants.CENTER);
    public JTextArea jTextArea_age = new JTextArea(1, 10);
    public JButton button_address = new JButton("Адрес доставки");
    public JButton button_ok = new JButton("OK");
    public cAuthorizationPanel controller;

    public AuthorizationPanel(boolean online, int table) {
        super("Регистрация");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        controller = new cAuthorizationPanel(this, online, table); // Связь View-Controller
        setVisible(true);
    }

    public AuthorizationPanel(boolean online) {
        this(online, -1);
    }

    public AuthorizationPanel() {
        this(true);
    }
}
