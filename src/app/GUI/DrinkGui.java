package app.GUI;
import app.Classes.Customer;
import app.Classes.InternetOrder;
import app.Controller.cDrinkGui;
import app.Controller.cOrder;
import app.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class DrinkGui extends JFrame{
    public JLabel jLabel_eight_control = new JLabel("Вам нет 18! Алкогольные напитки запрещены законом РФ", SwingConstants.CENTER);
    public JButton button_ok = new JButton("Ок");
    public JComboBox jComboBox = new JComboBox();
    JPanel jPanel = new JPanel(new GridLayout(1,2));
    public cDrinkGui controller;

    public DrinkGui(IOrder iOrder, cOrder order_panel) {
        super("Выбор напитка");
        setLayout(new GridLayout(2, 1));
        setSize(1400,200);

        add(jComboBox);
        jPanel.add(jLabel_eight_control);
        jPanel.add(button_ok);
        add(jPanel);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cDrinkGui(this, iOrder, order_panel); // Связь View-Controller
        setVisible(true);
    }

    public DrinkGui() {
        this(new InternetOrder(Customer.MATURE_UNKNOWN_CUSTOMER), null);
    }
}
