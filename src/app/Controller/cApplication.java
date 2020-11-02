package app.Controller;
import app.GUI.AddressGui;
import app.GUI.Application;
import app.GUI.ChoiceTable;
import app.GUI.LogIn;

import javax.swing.*;

public class cApplication {
    private ChoiceTable choiceTable_panel;
    private LogIn login_panel;
    public cApplication(Application view) {

        view.button_table.addActionListener(e -> {
            if (choiceTable_panel != null &&
                choiceTable_panel.isVisible()
            ) return;
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
            if (login_panel != null &&
                login_panel.isVisible()
            ) return;
            login_panel = new LogIn(true);
        });
    }
}
