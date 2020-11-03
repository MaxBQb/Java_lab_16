package app.Controller;

import app.Model.Customer;
import app.View.DeliveryAddress;

public class cDeliveryAddress {
    public cDeliveryAddress(DeliveryAddress view, Customer client){
        view.jTextArea_city.setText(client.getAddress().getCityName());
        view.jTextArea_street.setText(client.getAddress().getStreetName());
        view.jTextArea_house.setText(client.getAddress().getBuildingNumber() + "");
        view.jTextArea_building.setText(client.getAddress().getBuildingLetter() + "");
        view.jTextArea_flat.setText(client.getAddress().getApartmentNumber() + "");

        view.button_ok.addActionListener(e -> {
            view.dispose();
        });
    }
}
