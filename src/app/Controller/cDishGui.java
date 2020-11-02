package app.Controller;
import app.Classes.ItemsRepository;
import app.GUI.DishGui;
import app.Interfaces.IOrder;


public class cDishGui {
    public cDishGui(DishGui view, IOrder iOrder, cOrder order_panel) {
        for (int i = 0; i < ItemsRepository.dishesLength(); i++) {
            view.jComboBox.addItem((ItemsRepository.getDish(i)).toString());
        }

        view.button_ok.addActionListener(e -> {
            iOrder.add(ItemsRepository.getDish(view.jComboBox.getSelectedIndex()));
            if (order_panel != null)
                order_panel.updateOrderList();
            view.dispose();
        });
    }
}
