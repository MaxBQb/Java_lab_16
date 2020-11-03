package app.View;
import app.Controller.cApplication;
import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public cApplication controller;
    JLabel lbl_greetings = new JLabel("Приветствуем вас в ресторане у Максима и Ильи!", SwingConstants.CENTER);
    public JButton btn_choose_table = new JButton("Забронировать столик");
    public JButton btn_make_online_order = new JButton("Онлайн-заказ");

    public Application() {
        super("Ресторан");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 0, 5));

        lbl_greetings.setToolTipText("Здесь притаился Павел");
        add(lbl_greetings);
        JPanel grid = new JPanel();
        btn_make_online_order.setToolTipText("Shift + ЛКМ для входа в качестве менеджера");
        btn_choose_table.setToolTipText("Shift + ЛКМ для входа в качестве менеджера");
        grid.add(btn_choose_table);
        grid.add(btn_make_online_order);

        getContentPane().add(grid);

        pack(); // Ужать окно
        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cApplication(this); // Связь View-Controller
        setVisible(true);
    }
}

