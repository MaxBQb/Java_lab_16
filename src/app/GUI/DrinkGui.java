package app.GUI;
import app.Controller.cDrinkGui;

import javax.swing.*;
import java.awt.*;

public class DrinkGui extends JFrame{
    public JLabel jLabel_eight_control = new JLabel("Вам нет 18! Алкогольные напитки запрещены законом РФ", SwingConstants.CENTER);
    public JButton button_ok = new JButton("Ок");
    public JComboBox jComboBox = new JComboBox();
    JPanel jPanel = new JPanel(new GridLayout(1,2));

    public DrinkGui() {
        super("Выбор напитка");
        setLayout(new GridLayout(2, 1));
        setSize(800,200);

        add(jComboBox);
        jPanel.add(jLabel_eight_control);
        jPanel.add(button_ok);
        add(jPanel);

        setLocationRelativeTo(null); // отцентрировать окно
        new cDrinkGui(this); // Связь View-Controller
        setVisible(true);
    }
}
