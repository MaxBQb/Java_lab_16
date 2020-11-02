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
    private Order view;

    public cOrder(Order view, Customer client, int table) {
        this.table = table;
        this.view = view;
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
                    new DrinkGui(current_order, this);
                    break;

                case JOptionPane.NO_OPTION:
                    new DishGui(current_order, this);
                    break;

                case JOptionPane.CANCEL_OPTION:
                    return;
            }
        });
        view.button_remove.addActionListener(e -> {
            MenuItem[] items = current_order.getItems();
            if (items.length == 0) {
                JOptionPane.showMessageDialog(view,
                    "Вы, пока ещё, ничего не заказали!",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String name = JOptionPane.showInputDialog(view,
                    "Введите название удаляемой позиции: ",
                            items[0].getName()
            );
            if (!current_order.remove(name))
                JOptionPane.showMessageDialog(view,
                        "Ничего не найдено!",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
            updateOrderList();
        });
        view.button_score.addActionListener(e -> {
            if (current_order.itemsQuantity() == 0) {
                JOptionPane.showMessageDialog(view,
                        "Вы, пока ещё, ничего не заказали!",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (JOptionPane.showConfirmDialog(view,
                    "Вы уверены, что хотите закрыть заказ?",
                    "Выберите вариант:",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                return;

            view.button_score.setEnabled(false);
            view.button_add.setEnabled(false);
            view.button_remove.setEnabled(false);
            if (table == -1) {
                internetOrdersManager.addOrder(current_order);
            } else {
                tableOrdersManager.remove(table);
                tableOrdersManager.add(current_order, table);
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
                JOptionPane.showMessageDialog(view,
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
        if (!must_dispose)
            return;
        if (table != -1)
            tableOrdersManager.remove(table);
    }

    public void updateOrderList() {
        view.jTextArea_order.setText("");
        for (String name: current_order.itemsNames())
            view.jTextArea_order.append(name+"\n");
        view.lbl_total.setText("Итого: "+current_order.costTotal()+" руб.");
    }

    public static TableOrdersManager getTableOrdersManager() {
        return tableOrdersManager;
    }

    public static InternetOrdersManager getInternetOrdersManager() {
        return internetOrdersManager;
    }
}
