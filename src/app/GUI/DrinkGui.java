package app.GUI;
import app.Controller.cDrinkGui;

import javax.swing.*;
import java.awt.*;

public class DrinkGui extends JFrame{
    JLabel jLabel_dishes = new JLabel("Напиток:", SwingConstants.CENTER);
    public JLabel jLabel_eight_control = new JLabel("Вам нет 18! Алкогольные напитки запрещены законом РФ", SwingConstants.CENTER);
    public JButton button_ok = new JButton("Ок");
    public String free_table[] = { "Напиток №1","Напиток №2", "Напиток №3"};

    public DrinkGui() {
        super("Выбор напитка");
        setLayout(new GridLayout(2, 2, 5, 5));
        setSize(800,200);

        add(jLabel_dishes);
        JComboBox jComboBox = new JComboBox(free_table);

        add(jComboBox);
        add(jLabel_eight_control);
        add(button_ok);

        setLocationRelativeTo(null); // отцентрировать окно
        new cDrinkGui(this); // Связь View-Controller
        setVisible(true);
    }
}
