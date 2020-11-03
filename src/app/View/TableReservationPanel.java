package app.View;

import app.Controller.cTableReservationPanel;
import javax.swing.*;
import java.awt.*;

public class TableReservationPanel extends JFrame {
    JLabel lbl_available_tables = new JLabel("Выберите столик из доступных:");
    public JButton btn_continue = new JButton("Далее");
    public JComboBox chbx_available_tables = new JComboBox();
    public cTableReservationPanel controller;

    public TableReservationPanel() {
        super("Выбор столика");
        setLayout(new GridLayout(2, 2, 5, 5));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(lbl_available_tables);

        add(chbx_available_tables);
        add(new JLabel()); // Skip cell
        add(btn_continue);

        pack(); // Ужать окно
        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cTableReservationPanel(this); // Связь View-Controller
        setVisible(true);
    }
}
