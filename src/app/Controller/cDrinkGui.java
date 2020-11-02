package app.Controller;
import app.Classes.ItemsRepository;
import app.GUI.DrinkGui;
import app.Interfaces.IOrder;

public class cDrinkGui {
    public cDrinkGui(DrinkGui view, IOrder iOrder, cOrder order_panel) {
        for (int i = 0; i < ItemsRepository.drinksLength(); i++) {
            view.jComboBox.addItem((ItemsRepository.getDrink(i)).toString());
        }

        view.button_ok.addActionListener(e -> {
            iOrder.add(ItemsRepository.getDrink(view.jComboBox.getSelectedIndex()));
            if (order_panel != null)
                order_panel.updateOrderList();
            view.dispose();
        });
    }
}
