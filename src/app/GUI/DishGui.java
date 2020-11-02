package app.GUI;

import app.Classes.Customer;
import app.Classes.InternetOrder;
import app.Controller.cDishGui;
import app.Controller.cOrder;
import app.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class DishGui extends JFrame {
    JLabel jLabel_void = new JLabel("");
    public JComboBox jComboBox = new JComboBox();
    public JButton button_ok = new JButton("Ок");
    JPanel jPanel = new JPanel(new GridLayout(1,2));
    public cDishGui controller;

    public DishGui(IOrder iOrder, cOrder order_panel) {
        super("Выбор блюда");
        setLayout(new GridLayout(2, 1));
        setSize(1400,200);

        add(jComboBox);
        jPanel.add(jLabel_void);
        jPanel.add(button_ok);
        add(jPanel);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cDishGui(this, iOrder, order_panel); // Связь View-Controller
        setVisible(true);
    }

    public DishGui() {
        this(new InternetOrder(Customer.MATURE_UNKNOWN_CUSTOMER), null);
    }
}
