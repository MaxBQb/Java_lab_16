package app.Controller;

import app.Model.MenuItem;
import app.View.DeliveryAddress;
import app.View.OrderView;
import app.Model.Interfaces.IOrder;

public class cOrderView {
    private DeliveryAddress deliveryAddress;
    public cOrderView(OrderView view, boolean online, IOrder iOrder, int table) {
       view.jLabel_name.setText("Заказал: " + iOrder.getCustomer().getSecondName()  + " " +iOrder.getCustomer().getFirstName());

       if (online) {
           view.button_address.setVisible(true);
           view.setTitle("Интернет-заказ");
           view.jLabel_send.setText("Номер заказа: " + iOrder.getCustomer().getAddress().getZipCode());
       } else {
           view.button_address.setVisible(false);
           view.setTitle("Столик №" + table);
           view.jLabel_send.setText("");
           view.remove(view.jPanel);
           view.add(view.jLabel_name);
       }

       view.orders_list.setText("");
       for (MenuItem item: iOrder.getItems())
           if (item != null)
               view.orders_list.append(item.getName() + ": " + item.getCost() + "₽\n");

       if (online)
           view.button_address.addActionListener(e -> {
               if (deliveryAddress == null || !deliveryAddress.isVisible())
                   deliveryAddress = new DeliveryAddress(iOrder.getCustomer());
           });
    }
}
