package app.View;

import app.Model.Customer;
import app.Model.InternetOrder;
import app.Controller.cAddDish;
import app.Controller.cOrderPanel;
import app.Model.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class AddDish extends JFrame {
    JLabel jLabel_void = new JLabel("");
    public JComboBox jComboBox = new JComboBox();
    public JButton button_ok = new JButton("Ок");
    JPanel jPanel = new JPanel(new GridLayout(1,2));
    public cAddDish controller;

    public AddDish(IOrder iOrder, cOrderPanel order_panel) {
        super("Выбор блюда");
        setLayout(new GridLayout(2, 1));
        setSize(1400,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(jComboBox);
        jPanel.add(jLabel_void);
        jPanel.add(button_ok);
        add(jPanel);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cAddDish(this, iOrder, order_panel); // Связь View-Controller
        setVisible(true);
    }

    public AddDish() {
        this(new InternetOrder(Customer.MATURE_UNKNOWN_CUSTOMER), null);
    }
}
