package app.Controller;
import app.Classes.ItemsRepository;
import app.GUI.DishGui;


public class cDishGui {
    public cDishGui(DishGui view) {
        for (int i = 0; i < ItemsRepository.dishesLength(); i++) {
            view.jComboBox.addItem((ItemsRepository.getDish(i)).toString());
        }

        view.button_ok.addActionListener(e -> {
            //добавить добавление в заказ ору
            view.setVisible(false);
        });
    }
}
