package app.GUI;

import app.Classes.Customer;
import app.Controller.cBorrowPanel;
import app.Controller.cOrderView;

import javax.swing.*;
import java.awt.*;

public class OrderView extends JFrame {
    public JTextArea orders_list = new JTextArea(3, 20);
    JScrollPane scrollBar;
    public JLabel jLabel_name = new JLabel("Заказал: ");
    public JButton button_address = new JButton("Адрес");
    public JLabel jLabel_send = new JLabel("Доставить: ");
    JPanel jPanel;
    public cOrderView controller;

    public OrderView(boolean online, Customer client, int table) {
        super("Заказ");
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        orders_list.setText("");
        orders_list.setEditable(false);
        scrollBar = new JScrollPane(orders_list);

        jPanel = new JPanel(new GridLayout(2, 2));
        jPanel.add(jLabel_name);
        jPanel.add(button_address);
        jPanel.add(jLabel_send);

        add(scrollBar);
        add(jPanel);

        pack();
        setLocationRelativeTo(null); // отцентрировать окно

        controller = new cOrderView(this, online, client, table); // Связь View-Controller
        setVisible(true);
    }

    public OrderView() {
        this(true, Customer.MATURE_UNKNOWN_CUSTOMER, -1);
    }

    public void dispose() {
        cBorrowPanel.disposeListener();
        super.dispose();
    }
}
