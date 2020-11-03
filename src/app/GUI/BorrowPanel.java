package app.GUI;

import app.Controller.cBorrowPanel;

import javax.swing.*;
import java.awt.*;

public class BorrowPanel extends JFrame {
    public DefaultListModel defaultListModel = new DefaultListModel();
    public JList jList = new JList(defaultListModel);
    public JButton button_add = new JButton("Перейти к заказу"); //Добавление клиента
    public JButton button_remove = new JButton("Удалить заказ");
    public JButton button_sum = new JButton("Суммарная прибыль");
    public cBorrowPanel controller;

    public BorrowPanel(boolean online) {
        super("Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));


        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(button_add);
        buttonPanel.add(button_remove);
        buttonPanel.add(button_sum);

        JPanel east = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH; //установка местоположения кнопок
        gbc.weighty = 1; //Указывает, как распределить дополнительное вертикальное пространство
        east.add(buttonPanel, gbc);

        add(east, BorderLayout.EAST);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(jList));
        setLocationRelativeTo(null); // отцентрировать окно

        controller = new cBorrowPanel(this, online); // Связь View-Controller
        setVisible(true);
    }

    public BorrowPanel() {
        this(false);
    }
}

