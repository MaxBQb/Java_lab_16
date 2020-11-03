package app.Controller;
import app.Model.ItemsRepository;
import app.View.AddDish;
import app.Model.Interfaces.IOrder;


public class cAddDish {
    public cAddDish(AddDish view, IOrder iOrder, cOrderPanel order_panel) {
        for (int i = 0; i < ItemsRepository.dishesLength(); i++) {
            view.chbx_dishes.addItem((ItemsRepository.getDish(i)).toString());
        }

        view.btn_submit.addActionListener(e -> {
            iOrder.add(ItemsRepository.getDish(view.chbx_dishes.getSelectedIndex()));
            if (order_panel != null)
                order_panel.updateOrderList();
            view.dispose();
        });
    }
}
