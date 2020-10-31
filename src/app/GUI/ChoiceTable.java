package app.GUI;

import javax.swing.*;
import java.awt.*;

public class ChoiceTable extends JFrame {
    JLabel jLabel_choice = new JLabel("Выберите столик из доступных:");
    JLabel jLabel_void = new JLabel("");
    JButton button_continue = new JButton("Далее");

    public ChoiceTable() {
        super("Выбор столика");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 5, 5));

        add(jLabel_choice);
        String free_table[] = { "Столик №1","Столик №3", "Столик №10"};
        JComboBox jComboBox = new JComboBox(free_table);

        //jComboBox.setBounds(40,40,90,20);
        add(jComboBox);
        add(jLabel_void);
        add(button_continue);

        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        setVisible(true);
    }
}
