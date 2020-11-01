package app.GUI;

import app.Controller.cDishGui;

import javax.swing.*;
import java.awt.*;

public class DishGui extends JFrame {
    JLabel jLabel_void = new JLabel("");
    public JComboBox jComboBox = new JComboBox();
    public JButton button_ok = new JButton("Ок");
    JPanel jPanel = new JPanel(new GridLayout(1,2));

    public DishGui() {
        super("Выбор блюда");
        setLayout(new GridLayout(2, 1));
        setSize(800,200);

        add(jComboBox);
        jPanel.add(jLabel_void);
        jPanel.add(button_ok);
        add(jPanel);

        setLocationRelativeTo(null); // отцентрировать окно
        new cDishGui(this); // Связь View-Controller
        setVisible(true);
    }
}
