package app.Controller;

import app.View.Application;
import app.View.ManagerPanel;
import app.View.TableReservationPanel;
import app.View.AuthorizationPanel;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class cApplication {
    private TableReservationPanel table_reservation_panel;
    private AuthorizationPanel login_panel;
    public static ManagerPanel manager_panel;
    public static final int TABLES_COUNT = 16;

    public cApplication(Application view) {

        view.btn_choose_table.addActionListener(e -> {
            if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1) {
                if (manager_panel != null &&
                        manager_panel.isVisible()
                ) return;
                manager_panel = new ManagerPanel();
                return;
            }

            if (table_reservation_panel != null &&
                table_reservation_panel.isVisible())
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
            table_reservation_panel = new TableReservationPanel();
        });

        view.btn_make_online_order.addActionListener(e -> {
            if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1) {
                if (manager_panel != null &&
                        manager_panel.isVisible()
                ) return;
                manager_panel = new ManagerPanel(true);
                return;
            }
            if (login_panel != null &&
                login_panel.isVisible()
            ) return;
            login_panel = new AuthorizationPanel(true);
        });
    }
}
