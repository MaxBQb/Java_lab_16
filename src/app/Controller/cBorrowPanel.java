package app.Controller;
import app.GUI.BorrowPanel;
import app.GUI.OrderView;
import app.Interfaces.IOrder;

import javax.swing.*;

public class cBorrowPanel {
    private BorrowPanel view;
    private boolean online;
    public static final int MAX_VIEWERS_COUNT = 6;
    private static int openedOrderViewers = 0;

    public cBorrowPanel(BorrowPanel view, boolean online) {
        this.view = view;
        this.online = online;
        updateOrdersList();

        view.button_add.addActionListener(e -> {
            if (view.jList.getSelectedValue() == null)
                return;

            if (online) {
                IOrder[] iOrder = cOrder.getInternetOrdersManager().getOrders();
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
                        new OrderView(true, iOrder[i].getCustomer(), -1);
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
                new OrderView(false, cOrder.getTableOrdersManager().getOrder(table).getCustomer(), table);
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
                cOrder.getInternetOrdersManager().removeOrder();
            } else {
                int table = Integer.parseInt(view.jList.getSelectedValue().toString().split("№")[1]);
                cOrder.getTableOrdersManager().remove(table);
            }
            updateOrdersList();
        });

        view.button_sum.addActionListener(e -> {
            long sum = 0;
            if (online)
                sum = cOrder.getInternetOrdersManager().ordersCostSummary();
            else
                sum = cOrder.getTableOrdersManager().ordersCostSummary();

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
            IOrder[] iOrder = cOrder.getInternetOrdersManager().getOrders();
            for (int i = 0; i < iOrder.length; i++)
                if (iOrder[i] != null)
                    view.defaultListModel.addElement(iOrder[i].getCustomer().getAddress().getZipCode() + "");
        } else {
            IOrder[] iOrder = cOrder.getTableOrdersManager().getOrders();
            for (int i = 0; i < iOrder.length; i++)
                if (iOrder[i] != null)
                    view.defaultListModel.addElement("Столик №" + (i + 1));
        }
    }
}
