package app.Controller;

import app.Model.*;
import app.View.AddDish;
import app.View.AddDrink;
import app.View.OrderPanel;
import app.Model.Interfaces.IOrder;
import app.Model.Interfaces.OrdersManager;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class cOrderPanel {
    private static TableOrdersManager table_orders_manager = new TableOrdersManager(cApplication.TABLES_COUNT);
    private static InternetOrdersManager internet_orders_manager = new InternetOrdersManager();
    private int table_number;
    private IOrder current_order;
    private OrdersManager current_orders_manager;
    private boolean must_dispose;
    private OrderPanel view;

    public cOrderPanel(OrderPanel view, Customer client, int table_number) {
        this.table_number = table_number;
        this.view = view;
        must_dispose = true;

        if (table_number == -1) {
            current_orders_manager = internet_orders_manager;
            current_order = new InternetOrder(client);
        } else {
            current_orders_manager = table_orders_manager;
            current_order = new TableOrder(client);
        }

        view.lbl_total_sum.setText("");

        view.btn_add_item.addActionListener(e -> {
            switch (JOptionPane.showConfirmDialog(view,
                    "Добавить напиток?\n" +
                            "YES = Напиток\n" +
                            "NO = Блюдо",
                    "Выберите вариант:",
                    JOptionPane.YES_NO_CANCEL_OPTION)) {
                case JOptionPane.YES_OPTION:
                    new AddDrink(current_order, this);
                    break;

                case JOptionPane.NO_OPTION:
                    new AddDish(current_order, this);
                    break;

                case JOptionPane.CANCEL_OPTION:
                    return;
            }
        });
        view.btn_remove_item.addActionListener(e -> {
            MenuItem[] items = current_order.getItems();
            if (items.length == 0) {
                JOptionPane.showMessageDialog(view,
                    "Вы, пока ещё, ничего не заказали!",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            if (view.order_list_view.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(view,
                        "Не выбран ни один пункт заказа!",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            boolean error_flag = false;
            try {
                for (String name : view.order_list_view.getSelectedValuesList())
                    if (!current_order.remove(name))
                        error_flag = true;
            } catch (Throwable ignore) {
                error_flag = true;
            }
            if (error_flag)
                JOptionPane.showMessageDialog(view,
                        "При удалении возникла непредвиденная ошибка!",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
            updateOrderList();
        });

        view.btn_get_total_sum.addActionListener(e -> {
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

            view.btn_get_total_sum.setEnabled(false);
            view.btn_add_item.setEnabled(false);
            view.btn_remove_item.setEnabled(false);

            if (table_number == -1) {
                internet_orders_manager.addOrder(current_order);
                (new Timer()).schedule(new TimerTask() {
                      @Override
                      public void run() {
                          cOrderPanel.getInternetOrdersManager().removeOrder();
                          if (cApplication.manager_panel != null && cApplication.manager_panel.controller != null)
                              cApplication.manager_panel.controller.updateOrdersList();
                      }
                  }, 1000 * 60
                );
            } else {
                table_orders_manager.remove(table_number);
                table_orders_manager.add(current_order, table_number);
            }

            if (cApplication.manager_panel != null && cApplication.manager_panel.controller != null)
                cApplication.manager_panel.controller.updateOrdersList();
        });

        if (table_number != -1) {
            boolean table_occupied = true;
            Integer[] free_tables = table_orders_manager.freeTableNumbers();
            for (Integer free_table_number: free_tables)
                if (free_table_number == table_number) {
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

            view.setTitle("Столик №"+ table_number);
            table_orders_manager.add(current_order, table_number);
        }
        view.setVisible(true);
    }

    public void dispose() {
        if (!must_dispose)
            return;
        if (table_number != -1) {
            table_orders_manager.remove(table_number);
            if (cApplication.manager_panel != null && cApplication.manager_panel.controller != null)
                cApplication.manager_panel.controller.updateOrdersList();
        }
    }

    public void updateOrderList() {
        view.order_list_model.clear();
        for (String name: current_order.itemsNames())
            view.order_list_model.addElement(name);
        view.lbl_total_sum.setText("Итого: "+current_order.costTotal()+" руб.");
    }

    public static TableOrdersManager getTableOrdersManager() {
        return table_orders_manager;
    }

    public static InternetOrdersManager getInternetOrdersManager() {
        return internet_orders_manager;
    }
}
