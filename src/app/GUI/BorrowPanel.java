package app.GUI;

import javax.swing.*;
import java.awt.*;

public class BorrowPanel extends JFrame {
    JLabel lbl_occupation_info = new JLabel("Список занятых столиков: ");
    JLabel lbl_send_order = new JLabel("Заказ выбранного столика: ");
    JTextField orders_list = new JTextField(20);

    JButton button_add = new JButton("Добавить"); //Добавление клиента
    JButton button_search = new JButton("Найти заказ");
    JButton button_remove = new JButton("Удалить");

    public BorrowPanel() {
        super("Оформление заказа");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        button_add.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Ничего не найдено!",
                    "Результаты поиска",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        add(button_add);


        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        setVisible(true);
    }

}

