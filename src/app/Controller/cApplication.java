package app.Controller;
import app.GUI.AddressGui;
import app.GUI.Application;
import app.GUI.ChoiceTable;

public class cApplication {
    public cApplication(Application view) {

        view.button_table.addActionListener(e -> {
            new ChoiceTable();
            view.button_table.setEnabled(false);
        });

        view.button_online.addActionListener(e -> {
            new AddressGui();
            view.button_online.setEnabled(false);
        });
    }
}
