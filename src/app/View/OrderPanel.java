package app.View;

import app.Model.Customer;
import app.Controller.cOrderPanel;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JFrame {
    public DefaultListModel<String> order_list_model = new DefaultListModel<>();
    public JList<String> order_list_view = new JList<>(order_list_model);
    public JLabel lbl_total_sum = new JLabel("Итого: 0 руб.", SwingConstants.CENTER);
    public JButton btn_add_item = new JButton("Добавить"); //Добавление клиента
    public JButton btn_remove_item = new JButton("Удалить"); //Добавление клиента
    public JButton btn_get_total_sum = new JButton("Счёт");
    JPanel pnl_subgrid = new JPanel(new GridLayout(2,2));
    public cOrderPanel controller;

    public OrderPanel(Customer client, int table_number) {
        super("Корзина");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setSize(520,340);

        add(new JScrollPane(order_list_view));

        pnl_subgrid.add(btn_remove_item);
        pnl_subgrid.add(lbl_total_sum);

        pnl_subgrid.add(btn_add_item);
        pnl_subgrid.add(btn_get_total_sum);
        add(pnl_subgrid);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cOrderPanel(this, client, table_number); // Связь View-Controller
    }

    public OrderPanel(Customer client) {
        this(client, -1);
    }

    public OrderPanel() {
        this(Customer.MATURE_UNKNOWN_CUSTOMER);
    }

    @Override
    public void dispose() {
        if (controller != null)
            controller.dispose();
        super.dispose();
    }
}
