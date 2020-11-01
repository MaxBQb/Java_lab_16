package app.GUI;

import app.Controller.cApplication;
import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    JLabel greetings = new JLabel("Приветствуем вас в ресторане у Максима и Ильи!", SwingConstants.CENTER);
    public JButton button_table = new JButton("Забронировать столик");
    public JButton button_online = new JButton("Онлайн-заказ");

    public Application() {
        super("Ресторан");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 0, 5));

        add(greetings);
        JPanel grid = new JPanel();
        grid.add(button_table);
        grid.add(button_online);

        getContentPane().add(grid);

        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        new cApplication(this); // Связь View-Controller
        setVisible(true);
    }
}

