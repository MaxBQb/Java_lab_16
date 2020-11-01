package app.GUI;

import app.Controller.cDishGui;

import javax.swing.*;
import java.awt.*;

public class DishGui extends JFrame {
    JLabel jLabel_dishes = new JLabel("Блюдо:", SwingConstants.CENTER);
    JLabel jLabel_void = new JLabel("");
    public JButton button_ok = new JButton("Ок");
    public String free_table[] = { "Блюдо №1","Блюдо №2", "Блюдо №3"};

    public DishGui() {
        super("Выбор блюда");
        setLayout(new GridLayout(2, 2, 5, 5));
        setSize(800,200);

        add(jLabel_dishes);
        JComboBox jComboBox = new JComboBox(free_table);

        add(jComboBox);
        add(jLabel_void);
        add(button_ok);

        setLocationRelativeTo(null); // отцентрировать окно
        new cDishGui(this); // Связь View-Controller
        setVisible(true);
    }
}
