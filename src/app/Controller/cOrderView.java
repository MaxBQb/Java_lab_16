package app.Controller;

import app.Classes.Customer;
import app.GUI.DeliveryAddress;
import app.GUI.OrderView;

public class cOrderView {
    private DeliveryAddress deliveryAddress;
    public cOrderView(OrderView view, boolean online, Customer client, int table) {
       view.jLabel_name.setText("Заказал: " + client.getFirstName() + " " + client.getSecondName());

       if (online) {
           view.setTitle("Интернет-заказ");
           view.jLabel_send.setText("Номер заказа: " + client.getAddress().getZipCode());
       }
       else {
           view.setTitle("Столик №" + table);
           view.jLabel_send.setText("");
       }

        if (online)
            view.button_address.addActionListener(e -> {
                deliveryAddress = new DeliveryAddress(client);
            });
    }
}
