package app.View;
import app.Model.Customer;
import app.Model.InternetOrder;
import app.Controller.cAddDrink;
import app.Controller.cOrderPanel;
import app.Model.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class AddDrink extends JFrame{
    public JLabel jLabel_eight_control = new JLabel(
            "Вам нет 18! Алкогольные напитки до совершенолетия запрещены законом РФ",
            SwingConstants.CENTER
            );
    public JButton button_ok = new JButton("Ок");
    public JComboBox jComboBox = new JComboBox();
    JPanel jPanel = new JPanel(new GridLayout(1,2));
    public cAddDrink controller;

    public AddDrink(IOrder iOrder, cOrderPanel order_panel) {
        super("Выбор напитка");
        setLayout(new GridLayout(2, 1));
        setSize(1400,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(jComboBox);
        jLabel_eight_control.setFont(new Font("Tahoma", Font.BOLD, 14));
        jPanel.add(jLabel_eight_control);
        jPanel.add(button_ok);
        add(jPanel);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cAddDrink(this, iOrder, order_panel); // Связь View-Controller
        setVisible(true);
    }

    public AddDrink() {
        this(new InternetOrder(Customer.MATURE_UNKNOWN_CUSTOMER), null);
    }
}
