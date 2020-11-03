package app.Controller;

import app.Model.MenuItem;
import app.View.DeliveryAddress;
import app.View.OrderView;
import app.Model.Interfaces.IOrder;

public class cOrderView {
    private DeliveryAddress delivery_address;
    public cOrderView(OrderView view, boolean is_online, IOrder order, int table_number) {
       view.lbl_customer_name.setText("Заказал: " + order.getCustomer().getSecondName()  + " " +order.getCustomer().getFirstName());

       if (is_online) {
           view.btn_show_address.setVisible(true);
           view.setTitle("Интернет-заказ");
           view.lbl_zipcode.setText("Номер заказа: " + order.getCustomer().getAddress().getZipCode());
       } else {
           view.btn_show_address.setVisible(false);
           view.setTitle("Столик №" + table_number);
           view.lbl_zipcode.setText("");
           view.remove(view.pnl_subgrid);
           view.add(view.lbl_customer_name);
       }

       view.output_orders_list.setText("");
       for (MenuItem item: order.getItems())
           if (item != null)
               view.output_orders_list.append(item.getName() + ": " + item.getCost() + "₽\n");

       if (is_online)
           view.btn_show_address.addActionListener(e -> {
               if (delivery_address == null || !delivery_address.isVisible())
                   delivery_address = new DeliveryAddress(order.getCustomer());
           });
    }
}
