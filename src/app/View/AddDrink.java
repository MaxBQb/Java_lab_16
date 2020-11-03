package app.View;
import app.Model.Customer;
import app.Model.InternetOrder;
import app.Controller.cAddDrink;
import app.Controller.cOrderPanel;
import app.Model.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class AddDrink extends JFrame{
    public JLabel lbl_age_restriction = new JLabel(
            "Вам нет 18! Алкогольные напитки до совершенолетия запрещены законом РФ",
            SwingConstants.CENTER
            );
    public JButton btn_submit = new JButton("Ок");
    public JComboBox chbx_drinks = new JComboBox();
    JPanel pnl_subgrid = new JPanel(new GridLayout(1,2));
    public cAddDrink controller;

    public AddDrink(IOrder order, cOrderPanel order_panel) {
        super("Выбор напитка");
        setLayout(new GridLayout(2, 1));
        setSize(1400,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(chbx_drinks);
        lbl_age_restriction.setFont(new Font("Tahoma", Font.BOLD, 14));
        pnl_subgrid.add(lbl_age_restriction);
        pnl_subgrid.add(btn_submit);
        add(pnl_subgrid);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cAddDrink(this, order, order_panel); // Связь View-Controller
        setVisible(true);
    }

    public AddDrink() {
        this(new InternetOrder(Customer.MATURE_UNKNOWN_CUSTOMER), null);
    }
}
