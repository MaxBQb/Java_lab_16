package app.Controller;
import app.View.ManagerPanel;
import app.View.OrderView;
import app.Model.Interfaces.IOrder;

import javax.swing.*;

public class cManagerPanel {
    private ManagerPanel view;
    private boolean is_online;
    public static final int MAX_VIEWERS_COUNT = 6;
    private static int opened_order_viewers = 0;

    public cManagerPanel(ManagerPanel view, boolean is_online) {
        this.view = view;
        this.is_online = is_online;
        updateOrdersList();

        view.btn_view.addActionListener(e -> {
            if (view.selection_list_view.getSelectedValue() == null)
                return;

            if (is_online) {
                IOrder[] orders = cOrderPanel.getInternetOrdersManager().getOrders();
                int zip_code = Integer.parseInt(view.selection_list_view.getSelectedValue().toString());

                for (int i = 0; i < orders.length; i++)
                    if (zip_code == orders[i].getCustomer().getAddress().getZipCode()) {
                        if (opened_order_viewers >= MAX_VIEWERS_COUNT) {
                            JOptionPane.showMessageDialog(view,
                                    "Невозможно создать более "+MAX_VIEWERS_COUNT+
                                            " окон(-а) этого типа.",
                                    "Ограничение",
                                    JOptionPane.ERROR_MESSAGE
                            );
                            return;
                        }
                        new OrderView(true, orders[i], -1);
                        opened_order_viewers++;
                        break;
                    }
            } else {
                int table = Integer.parseInt(view.selection_list_view.getSelectedValue().toString().split("№")[1]);
                if (opened_order_viewers >= MAX_VIEWERS_COUNT) {
                    JOptionPane.showMessageDialog(view,
                            "Невозможно создать более "+MAX_VIEWERS_COUNT+
                                    " окон(-а) этого типа.",
                            "Ограничение",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                new OrderView(false, cOrderPanel.getTableOrdersManager().getOrder(table), table);
                opened_order_viewers++;
            }
        });

        view.btn_remove_order.addActionListener(e -> {
            if (view.selection_list_view.getSelectedValue() == null)
                return;

            if (is_online) {
                if (view.selection_list_view.getMaxSelectionIndex() != 0) {
                    view.selection_list_view.setSelectedIndex(0);
                    return;
                }
                cOrderPanel.getInternetOrdersManager().removeOrder();
            } else {
                int table = Integer.parseInt(view.selection_list_view.getSelectedValue().toString().split("№")[1]);
                cOrderPanel.getTableOrdersManager().remove(table);
            }
            updateOrdersList();
        });

        view.btn_get_summary.addActionListener(e -> {
            long sum = 0;
            if (is_online)
                sum = cOrderPanel.getInternetOrdersManager().ordersCostSummary();
            else
                sum = cOrderPanel.getTableOrdersManager().ordersCostSummary();

            JOptionPane.showMessageDialog(null,
                    "Выручка составляет: " + sum + "₽",
                    "Выручка",
                    JOptionPane.PLAIN_MESSAGE
            );
        });

    }

    public static void disposeListener() {
        if (opened_order_viewers > 0)
            opened_order_viewers--;
        else
            System.exit(1);
    }

    public void updateOrdersList() {
        view.selection_list_model.clear();
        if (is_online) {
            IOrder[] iOrder = cOrderPanel.getInternetOrdersManager().getOrders();
            for (int i = 0; i < iOrder.length; i++)
                if (iOrder[i] != null)
                    view.selection_list_model.addElement(iOrder[i].getCustomer().getAddress().getZipCode() + "");
        } else {
            IOrder[] iOrder = cOrderPanel.getTableOrdersManager().getOrders();
            for (int i = 0; i < iOrder.length; i++)
                if (iOrder[i] != null)
                    view.selection_list_model.addElement("Столик №" + (i + 1));
        }
    }
}
