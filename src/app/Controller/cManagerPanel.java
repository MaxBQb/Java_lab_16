package app.Controller;
import app.View.ManagerPanel;
import app.View.OrderView;
import app.Model.Interfaces.IOrder;

import javax.swing.*;

public class cManagerPanel {
    private ManagerPanel view;
    private boolean online;
    public static final int MAX_VIEWERS_COUNT = 6;
    private static int openedOrderViewers = 0;

    public cManagerPanel(ManagerPanel view, boolean online) {
        this.view = view;
        this.online = online;
        updateOrdersList();

        view.button_add.addActionListener(e -> {
            if (view.jList.getSelectedValue() == null)
                return;

            if (online) {
                IOrder[] iOrder = cOrderPanel.getInternetOrdersManager().getOrders();
                int code = Integer.parseInt(view.jList.getSelectedValue().toString());

                for (int i = 0; i < iOrder.length; i++)
                    if (code == iOrder[i].getCustomer().getAddress().getZipCode()) {
                        if (openedOrderViewers >= MAX_VIEWERS_COUNT) {
                            JOptionPane.showMessageDialog(view,
                                    "Невозможно создать более "+MAX_VIEWERS_COUNT+
                                            " окон(-а) этого типа.",
                                    "Ограничение",
                                    JOptionPane.ERROR_MESSAGE
                            );
                            return;
                        }
                        new OrderView(true, iOrder[i], -1);
                        openedOrderViewers++;
                        break;
                    }
            } else {
                int table = Integer.parseInt(view.jList.getSelectedValue().toString().split("№")[1]);
                if (openedOrderViewers >= MAX_VIEWERS_COUNT) {
                    JOptionPane.showMessageDialog(view,
                            "Невозможно создать более "+MAX_VIEWERS_COUNT+
                                    " окон(-а) этого типа.",
                            "Ограничение",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                new OrderView(false, cOrderPanel.getTableOrdersManager().getOrder(table), table);
                openedOrderViewers++;
            }
        });

        view.button_remove.addActionListener(e -> {
            if (view.jList.getSelectedValue() == null)
                return;

            if (online) {
                if (view.jList.getMaxSelectionIndex() != 0) {
                    view.jList.setSelectedIndex(0);
                    return;
                }
                cOrderPanel.getInternetOrdersManager().removeOrder();
            } else {
                int table = Integer.parseInt(view.jList.getSelectedValue().toString().split("№")[1]);
                cOrderPanel.getTableOrdersManager().remove(table);
            }
            updateOrdersList();
        });

        view.button_sum.addActionListener(e -> {
            long sum = 0;
            if (online)
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
        if (openedOrderViewers > 0)
            openedOrderViewers--;
        else
            System.exit(1);
    }

    public void updateOrdersList() {
        view.defaultListModel.clear();
        if (online) {
            IOrder[] iOrder = cOrderPanel.getInternetOrdersManager().getOrders();
            for (int i = 0; i < iOrder.length; i++)
                if (iOrder[i] != null)
                    view.defaultListModel.addElement(iOrder[i].getCustomer().getAddress().getZipCode() + "");
        } else {
            IOrder[] iOrder = cOrderPanel.getTableOrdersManager().getOrders();
            for (int i = 0; i < iOrder.length; i++)
                if (iOrder[i] != null)
                    view.defaultListModel.addElement("Столик №" + (i + 1));
        }
    }
}
