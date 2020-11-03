package app.View;

import app.Model.Customer;
import app.Model.InternetOrder;
import app.Controller.cManagerPanel;
import app.Controller.cOrderView;
import app.Model.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class OrderView extends JFrame {
    public JTextArea orders_list = new JTextArea(3, 20);
    JScrollPane scrollBar;
    public JLabel jLabel_name = new JLabel("Заказал: ", SwingConstants.CENTER);
    public JButton button_address = new JButton("Адрес");
    public JLabel jLabel_send = new JLabel("Доставить: ", SwingConstants.CENTER);
    public JPanel jPanel;
    public cOrderView controller;

    public OrderView(boolean online, IOrder iOrder, int table) {
        super("Заказ");
        setMinimumSize(new Dimension(600,300));
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        controller = new cOrderView(this, online, iOrder, table); // Связь View-Controller
        setVisible(true);
    }

    public OrderView() {
        this(true, new InternetOrder(Customer.MATURE_UNKNOWN_CUSTOMER), -1);
    }

    public void dispose() {
        cManagerPanel.disposeListener();
        super.dispose();
    }
}
