package app.GUI;

import app.Classes.Customer;
import app.Controller.cOrder;

import javax.swing.*;
import java.awt.*;

public class Order extends JFrame {
    public JTextArea jTextArea_order = new JTextArea(3, 20);
    JScrollPane scrollBar;
    public JLabel lbl_total = new JLabel("Итого: 0 рублей", SwingConstants.CENTER);
    public JButton button_add = new JButton("Добавить"); //Добавление клиента
    public JButton button_remove = new JButton("Удалить"); //Добавление клиента
    public JButton button_score = new JButton("Счёт");
    JPanel jPanel = new JPanel(new GridLayout(2,2));
    public cOrder controller;

    public Order(Customer client) {
        super("Корзина");
        setLayout(new GridLayout(2, 1));
        setSize(520,340);

        jTextArea_order.setEditable(false);
        scrollBar = new JScrollPane(this.jTextArea_order);
        add(scrollBar);

        jPanel.add(button_remove);
        jPanel.add(lbl_total);

        jPanel.add(button_add);
        jPanel.add(button_score);
        add(jPanel);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cOrder(this); // Связь View-Controller
        setVisible(true);
    }

    public Order() {
        this(Customer.MATURE_UNKNOWN_CUSTOMER);
    }
}
