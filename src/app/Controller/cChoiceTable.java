package app.Controller;
import app.GUI.ChoiceTable;
import app.GUI.LogIn;
import app.GUI.Order;

import javax.swing.*;

public class cChoiceTable {
    public cChoiceTable(ChoiceTable view) {
        updateTables(view);
        view.button_continue.addActionListener(e -> {
            int table = Integer.parseInt(view.jComboBox.getSelectedItem().toString().split("№")[1]);
            Integer[] free_tables = cOrder.getTableOrdersManager().freeTableNumbers();
            for (Integer i: free_tables)
                if (i == table) {
                    new LogIn(false, table);
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

    private void updateTables(ChoiceTable view) {
        Integer[] free_tables = cOrder.getTableOrdersManager().freeTableNumbers();
        view.jComboBox.removeAllItems();
        for (Integer i: free_tables) {
            view.jComboBox.addItem("Столик №"+i);
        }
    }
}
