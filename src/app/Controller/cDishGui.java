package app.Controller;
import app.Classes.ItemsRepository;
import app.GUI.DishGui;
import app.Interfaces.IOrder;


public class cDishGui {
    public cDishGui(DishGui view, IOrder iOrder) {
        for (int i = 0; i < ItemsRepository.dishesLength(); i++) {
            view.jComboBox.addItem((ItemsRepository.getDish(i)).toString());
        }

        view.button_ok.addActionListener(e -> {
            //добавить добавление в заказ ору
            String a =(String) view.jComboBox.getSelectedItem();

            view.setVisible(false);
        });
    }
}
