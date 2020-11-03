package app.View;

import app.Controller.cTableReservationPanel;
import javax.swing.*;
import java.awt.*;

public class TableReservationPanel extends JFrame {
    JLabel jLabel_choice = new JLabel("Выберите столик из доступных:");
    public JButton button_continue = new JButton("Далее");
    public JComboBox jComboBox = new JComboBox();
    public cTableReservationPanel controller;

    public TableReservationPanel() {
        super("Выбор столика");
        setLayout(new GridLayout(2, 2, 5, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(jLabel_choice);

        //jComboBox.setBounds(40,40,90,20);
        add(jComboBox);
        add(new JLabel()); // Skip cell
        add(button_continue);

        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cTableReservationPanel(this); // Связь View-Controller
        setVisible(true);
    }
}
