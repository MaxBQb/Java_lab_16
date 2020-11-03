package app.Controller;
import app.View.TableReservationPanel;
import app.View.AuthorizationPanel;

import javax.swing.*;

public class cTableReservationPanel {
    public cTableReservationPanel(TableReservationPanel view) {
        updateTables(view);
        view.btn_continue.addActionListener(e -> {
            int table_number = Integer.parseInt(view.chbx_available_tables.getSelectedItem().toString().split("№")[1]);
            Integer[] free_tables = cOrderPanel.getTableOrdersManager().freeTableNumbers();
            for (Integer free_table_number: free_tables)
                if (free_table_number == table_number) {
                    new AuthorizationPanel(false, table_number);
                    view.dispose();
                    return;
                }
            JOptionPane.showMessageDialog(null,
                    "К сожалению, этот столик недавно заняли!",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE
            );
            if (free_tables.length == 0) {
                view.dispose();
                return;
            }
            updateTables(view);
        });
    }

    private void updateTables(TableReservationPanel view) {
        Integer[] free_tables = cOrderPanel.getTableOrdersManager().freeTableNumbers();
        view.chbx_available_tables.removeAllItems();
        for (Integer i: free_tables) {
            view.chbx_available_tables.addItem("Столик №"+i);
        }
    }
}
