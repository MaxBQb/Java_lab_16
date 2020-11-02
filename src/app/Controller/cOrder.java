package app.Controller;

import app.Classes.*;
import app.GUI.DishGui;
import app.GUI.DrinkGui;
import app.GUI.Order;
import app.Interfaces.IOrder;
import app.Interfaces.OrdersManager;

import javax.swing.*;

public class cOrder {
    private static TableOrdersManager tableOrdersManager = new TableOrdersManager(16);
    private static InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
    private int table;
    private IOrder current_order;
    private OrdersManager current_orders_manager;
    private boolean must_dispose;

    public cOrder(Order view, Customer client, int table) {
        this.table = table;
        must_dispose = true;

        if (table == -1) {
            current_orders_manager = internetOrdersManager;
            current_order = new InternetOrder(client);
        } else {
            current_orders_manager = tableOrdersManager;
            current_order = new TableOrder(client);
        }

        view.lbl_total.setText("");

        view.button_add.addActionListener(e -> {
            switch (JOptionPane.showConfirmDialog(view,
                    "Добавить напиток?\n" +
                            "YES = Напиток\n" +
                            "NO = Блюдо",
                    "Выберите вариант:",
                    JOptionPane.YES_NO_CANCEL_OPTION)) {
                case JOptionPane.YES_OPTION:
                    new DrinkGui(current_order);
                    break;

                case JOptionPane.NO_OPTION:
                    new DishGui(current_order);
                    break;

                case JOptionPane.CANCEL_OPTION:
                    return;
            }
        });


        if (table != -1) {
            boolean table_occupied = true;
            Integer[] free_tables = tableOrdersManager.freeTableNumbers();
            for (Integer i: free_tables)
                if (i == table) {
                    table_occupied = false;
                    break;
                }

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

            view.setTitle("Столик №"+table);
            tableOrdersManager.add(current_order, table);
        }
        else {

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
