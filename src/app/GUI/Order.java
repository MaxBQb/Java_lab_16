package app.GUI;

import app.Controller.cOrder;

import javax.swing.*;
import java.awt.*;

public class Order extends JFrame {
    JLabel lbl_order = new JLabel("Ваш заказ: ");
    JTextArea jTextArea_order = new JTextArea(3, 20);
    JScrollPane scrollBar;
    JLabel jLabel_void = new JLabel("");
    JLabel lbl_total = new JLabel("Итого: 0 рублей");
    JButton button_add = new JButton("Добавить"); //Добавление клиента
    JButton button_score = new JButton("Счёт");

    public Order() {
        super("Корзина");
        setLayout(new GridLayout(3, 2, 1, 5));

        scrollBar = new JScrollPane(this.jTextArea_order);

        add(lbl_order);
        add(scrollBar);

        add(jLabel_void);
        add(lbl_total);

        add(button_add);
        add(button_score);

        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        new cOrder(this); // Связь View-Controller
        setVisible(true);
    }
}
