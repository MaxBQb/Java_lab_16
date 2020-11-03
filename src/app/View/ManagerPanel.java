package app.View;

import app.Controller.cManagerPanel;

import javax.swing.*;
import java.awt.*;

public class ManagerPanel extends JFrame {
    public DefaultListModel selection_list_model = new DefaultListModel();
    public JList selection_list_view = new JList(selection_list_model);
    public JButton btn_view = new JButton("Перейти к заказу"); //Добавление клиента
    public JButton btn_remove_order = new JButton("Удалить заказ");
    public JButton btn_get_summary = new JButton("Суммарная прибыль");
    public cManagerPanel controller;

    public ManagerPanel(boolean is_online) {
        super("Панель управления");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(btn_view);
        buttonPanel.add(btn_remove_order);
        buttonPanel.add(btn_get_summary);

        JPanel east_panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH; //установка местоположения кнопок
        gbc.weighty = 1; //Указывает, как распределить дополнительное вертикальное пространство
        east_panel.add(buttonPanel, gbc);

        add(east_panel, BorderLayout.EAST);

        selection_list_view.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(selection_list_view));
        setLocationRelativeTo(null); // отцентрировать окно

        controller = new cManagerPanel(this, is_online); // Связь View-Controller
        setVisible(true);
    }

    public ManagerPanel() {
        this(false);
    }
}

