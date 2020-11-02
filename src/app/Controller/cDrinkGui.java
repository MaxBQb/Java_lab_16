package app.Controller;
import app.Classes.ItemsRepository;
import app.GUI.DrinkGui;
import app.Interfaces.IOrder;

public class cDrinkGui {
    public cDrinkGui(DrinkGui view, IOrder iOrder, cOrder order_panel) {
        for (int i = 0; i < ItemsRepository.drinksLength(); i++) {
            if (iOrder.getCustomer().getAge() >= 18)
                view.jComboBox.addItem((ItemsRepository.getDrink(i)).toString());
            else if (ItemsRepository.getDrink(i).getAlcoholVol() < 18.0)
                view.jComboBox.addItem((ItemsRepository.getDrink(i)).toString());
        }

        if (iOrder.getCustomer().getAge() < 18)
            view.jLabel_eight_control.setText("Вам нет 18! Алкогольные напитки запрещены законом РФ");

        view.button_ok.addActionListener(e -> {
            iOrder.add(ItemsRepository.getDrink(view.jComboBox.getSelectedIndex()));

            //Вам нет 18! Алкогольные напитки запрещены законом РФ
            if (order_panel != null)
                order_panel.updateOrderList();
            view.dispose();
        });
    }
}
