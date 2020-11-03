package app.View;

import app.Controller.cAuthorizationPanel;
import javax.swing.*;
import java.awt.*;

public class AuthorizationPanel extends JFrame{
    JLabel lbl_name = new JLabel("Имя: ", SwingConstants.CENTER);
    public JTextArea input_name = new JTextArea(1, 10);
    JLabel lbl_surname = new JLabel("Фамилия: ", SwingConstants.CENTER);
    public JTextArea input_surname = new JTextArea(1, 10);
    JLabel lbl_age = new JLabel("Возраст: ", SwingConstants.CENTER);
    public JTextArea input_age = new JTextArea(1, 10);
    public JButton btn_set_address = new JButton("Адрес доставки");
    public JButton btn_submit = new JButton("OK");
    public cAuthorizationPanel controller;

    public AuthorizationPanel(boolean is_online, int table_number) {
        super("Регистрация");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 1, 5));

        add(lbl_name);
        add(input_name);
        add(lbl_surname);
        add(input_surname);
        add(lbl_age);
        add(input_age);
        add(btn_set_address);
        add(btn_submit);

        pack(); // Ужать окно
        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cAuthorizationPanel(this, is_online, table_number); // Связь View-Controller
        setVisible(true);
    }

    public AuthorizationPanel(boolean online) {
        this(online, -1);
    }

    public AuthorizationPanel() {
        this(true);
    }
}
