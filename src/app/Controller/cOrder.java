package app.Controller;
import app.Classes.Customer;
import app.Classes.InternetOrdersManager;
import app.Classes.TableOrder;
import app.Classes.TableOrdersManager;
import app.GUI.LogIn;
import app.GUI.Order;

import javax.swing.*;

public class cOrder {
    private static TableOrdersManager tableOrdersManager = new TableOrdersManager(16);
    private static InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
    private int table;
    private boolean must_dispose;

    public cOrder(Order view, Customer client, int table) {
        this.table = table;
        must_dispose = true;

        boolean table_occupied = true;
        Integer[] free_tables = tableOrdersManager.freeTableNumbers();
        for (Integer i: free_tables)
            if (i == table)
                table_occupied = false;

        if (table_occupied) {
            must_dispose = false;
            view.dispose();
            JOptionPane.showMessageDialog(null,
                    "К сожалению, этот столик недавно заняли!",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (table != -1) {
            view.setTitle("Столик №"+table);
            tableOrdersManager.add(new TableOrder(client), table);
        }

        view.setVisible(true);
    }

    public void dispose() {
        if (table != -1 && must_dispose)
            tableOrdersManager.remove(table);
    }

    public static TableOrdersManager getTableOrdersManager() {
        return tableOrdersManager;
    }

    public static InternetOrdersManager getInternetOrdersManager() {
        return internetOrdersManager;
    }
}
