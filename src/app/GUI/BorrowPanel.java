package app.GUI;

import javax.swing.*;
import java.awt.*;

public class BorrowPanel extends JFrame {
    JLabel lbl_occupation_info = new JLabel("Список занятых столиков: ");
    JLabel lbl_send_order = new JLabel("Заказ выбранного столика: ");
    JTextArea info_list = new JTextArea(3, 20);
    JTextArea orders_list = new JTextArea(3, 20);
    JScrollPane scrollBar;

    JButton button_add = new JButton("Добавить"); //Добавление клиента
    JButton button_search = new JButton("Найти заказ");
    JButton button_remove = new JButton("Удалить");

    public BorrowPanel() {
        final JFrame frame = new JFrame("Оформление заказа в ресторане");
        //frame.setSize(900,600);
        //setLayout(new GridBagLayout());

        scrollBar = new JScrollPane(this.info_list);

/*
        button_add.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Ничего не найдено!",
                    "Результаты поиска",
                    JOptionPane.QUESTION_MESSAGE
            );
        });

        button_add.setSize(1,1);
        button_add.setPreferredSize(new Dimension( 1, 1));
        button_add.setMaximumSize(new Dimension(1,1));
        button_add.setMinimumSize(new Dimension(1,1));
        add(button_add);

        button_search.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Ничего не найдено!",
                    "Результаты поиска",
                    JOptionPane.QUESTION_MESSAGE
            );
        });
        add(button_search);

        button_remove.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Ничего не найдено!",
                    "Результаты поиска",
                    JOptionPane.QUESTION_MESSAGE
            );
        });
        add(button_remove);
*/

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(button_add);
        buttonPanel.add(button_search);
        buttonPanel.add(button_remove);

        JPanel east = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH; //установка местоположения кнопок
        gbc.weighty = 1; //Указывает, как распределить дополнительное вертикальное пространство
        east.add(buttonPanel, gbc);


        JPanel west = new JPanel(new GridLayout(2, 2, 0, 10));
        west.add(lbl_occupation_info);
        west.add(scrollBar);
        west.add(lbl_send_order );
        west.add(orders_list );
        west.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frame.add(east, BorderLayout.EAST);
        frame.add(west);
        frame.setLocationRelativeTo(null); // отцентрировать окно
        frame.pack();

        frame.setVisible(true);
    }

}
/*
{
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };
 */
