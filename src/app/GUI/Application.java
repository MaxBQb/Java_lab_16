package app.GUI;

import javax.swing.*;

public class Application extends JFrame {

    Application() {
        super("Бар");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        pack(); // Уважать окно
        setLocationRelativeTo(null); // отцентрировать окно
        setVisible(true);
    }

    //Где на вынос или в помещение
}

