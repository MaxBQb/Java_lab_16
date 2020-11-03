package app.View;

import app.Model.Customer;
import app.Model.InternetOrder;
import app.Controller.cManagerPanel;
import app.Controller.cOrderView;
import app.Model.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class OrderView extends JFrame {
    public JTextArea output_orders_list = new JTextArea(3, 20);
    public JLabel lbl_customer_name = new JLabel("Заказал: ", SwingConstants.CENTER);
    public JButton btn_show_address = new JButton("Адрес");
    public JLabel lbl_zipcode = new JLabel("Доставить: ", SwingConstants.CENTER);
    public JPanel pnl_subgrid = new JPanel(new GridLayout(2, 2));;
    public cOrderView controller;

    public OrderView(boolean is_online, IOrder order, int table_number) {
        super("Заказ");
        setMinimumSize(new Dimension(600,300));
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        output_orders_list.setEditable(false);

        pnl_subgrid.add(lbl_customer_name);
        pnl_subgrid.add(btn_show_address);
        pnl_subgrid.add(lbl_zipcode);

        add(new JScrollPane(output_orders_list));
        add(pnl_subgrid);

        pack();
        setLocationRelativeTo(null); // отцентрировать окно

        controller = new cOrderView(this, is_online, order, table_number); // Связь View-Controller
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
