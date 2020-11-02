package app.Controller;
import app.Classes.ItemsRepository;
import app.GUI.DrinkGui;
import app.Interfaces.IOrder;

public class cDrinkGui {
    public cDrinkGui(DrinkGui view, IOrder iOrder) {
        for (int i = 0; i < ItemsRepository.drinksLength(); i++) {
            view.jComboBox.addItem((ItemsRepository.getDrink(i)).toString());
        }

        view.button_ok.addActionListener(e -> {
            //добавить добавление в заказ ору
            view.setVisible(false);
        });
    }
}
