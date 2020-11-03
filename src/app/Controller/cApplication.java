package app.Controller;

import app.View.Application;
import app.View.ManagerPanel;
import app.View.TableReservationPanel;
import app.View.AuthorizationPanel;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class cApplication {
    private TableReservationPanel table_ReservationPanel_panel;
    private AuthorizationPanel login_panel;
    public static ManagerPanel managerPanel;
    public static final int TABLES_COUNT = 16;

    public cApplication(Application view) {

        view.button_table.addActionListener(e -> {
            if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1) {
                if (managerPanel != null &&
                        managerPanel.isVisible()
                ) return;
                managerPanel = new ManagerPanel();
                return;
            }

            if (table_ReservationPanel_panel != null &&
                table_ReservationPanel_panel.isVisible())
                return;

            if (cOrderPanel.getTableOrdersManager().freeTableNumber() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Сейчас все столики заняты, попробуйте обратиться позже.\n" +
                                "Или сделайте заказ онлайн.",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            table_ReservationPanel_panel = new TableReservationPanel();
        });

        view.button_online.addActionListener(e -> {
            if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1) {
                if (managerPanel != null &&
                        managerPanel.isVisible()
                ) return;
                managerPanel = new ManagerPanel(true);
                return;
            }
            if (login_panel != null &&
                login_panel.isVisible()
            ) return;
            login_panel = new AuthorizationPanel(true);
        });
    }
}
