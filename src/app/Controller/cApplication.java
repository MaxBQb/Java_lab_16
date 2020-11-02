package app.Controller;

import app.GUI.Application;
import app.GUI.BorrowPanel;
import app.GUI.ChoiceTable;
import app.GUI.LogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class cApplication {
    private ChoiceTable choiceTable_panel;
    private LogIn login_panel;
    private static BorrowPanel borrowPanel;

    private static Timer timer = new Timer();

    public cApplication(Application view) {

        view.button_table.addActionListener(e -> {
            if (choiceTable_panel != null &&
                choiceTable_panel.isVisible())
                return;

            if (cOrder.getTableOrdersManager().freeTableNumber() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Сейчас все столики заняты, попробуйте обратиться позже.\n" +
                                "Или сделайте заказ онлайн.",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            choiceTable_panel = new ChoiceTable();
        });

        view.button_online.addActionListener(e -> {
            if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1) {
                if (borrowPanel != null &&
                        borrowPanel.isVisible()
                ) return;
                borrowPanel = new BorrowPanel();
                return;
            }
            if (login_panel != null &&
                login_panel.isVisible()
            ) return;
            login_panel = new LogIn(true);
        });

        timer.scheduleAtFixedRate(new TimerTask() {
              @Override
              public void run() {
                  cOrder.getInternetOrdersManager().removeOrder();
              }
          }, 0, 1000 * 60
        );
    }
}
