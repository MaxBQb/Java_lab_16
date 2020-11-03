package app.Controller;
import app.View.TableReservationPanel;
import app.View.AuthorizationPanel;

import javax.swing.*;

public class cTableReservationPanel {
    public cTableReservationPanel(TableReservationPanel view) {
        updateTables(view);
        view.button_continue.addActionListener(e -> {
            int table = Integer.parseInt(view.jComboBox.getSelectedItem().toString().split("№")[1]);
            Integer[] free_tables = cOrderPanel.getTableOrdersManager().freeTableNumbers();
            for (Integer i: free_tables)
                if (i == table) {
                    new AuthorizationPanel(false, table);
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
        view.jComboBox.removeAllItems();
        for (Integer i: free_tables) {
            view.jComboBox.addItem("Столик №"+i);
        }
    }
}
