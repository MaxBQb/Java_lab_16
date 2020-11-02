package app.GUI;

import app.Controller.cChoiceTable;
import javax.swing.*;
import java.awt.*;

public class ChoiceTable extends JFrame {
    JLabel jLabel_choice = new JLabel("Выберите столик из доступных:");
    JLabel jLabel_void = new JLabel("");
    public JButton button_continue = new JButton("Далее");
    public JComboBox jComboBox = new JComboBox();
    public cChoiceTable controller;

    public ChoiceTable() {
        super("Выбор столика");
        setLayout(new GridLayout(2, 2, 5, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(jLabel_choice);

        //jComboBox.setBounds(40,40,90,20);
        add(jComboBox);
        add(jLabel_void);
        add(button_continue);

        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cChoiceTable(this); // Связь View-Controller
        setVisible(true);
    }
}
