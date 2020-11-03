package app.Controller;
import app.Classes.Drink;
import app.Classes.ItemsRepository;
import app.GUI.DrinkGui;
import app.Interfaces.IOrder;

public class cDrinkGui {
    public cDrinkGui(DrinkGui view, IOrder iOrder, cOrder order_panel) {
        for (int i = 0; i < ItemsRepository.drinksLength(); i++)
            view.jComboBox.addItem((ItemsRepository.getDrink(i)).toString());

        view.jLabel_eight_control.setVisible(false);

        view.button_ok.addActionListener(e -> {
            view.jLabel_eight_control.setVisible(false);
            Drink new_drink = ItemsRepository.getDrink(view.jComboBox.getSelectedIndex());
            if (new_drink.isAlcoholicDrink() && iOrder.getCustomer().getAge() < 18) {
                view.jLabel_eight_control.setVisible(true);
                return;
            }

            iOrder.add(new_drink);
            if (order_panel != null)
                order_panel.updateOrderList();
            view.dispose();
        });
    }
}
