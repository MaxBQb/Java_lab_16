package app.Controller;
import app.GUI.AddressGui;
import app.GUI.Application;
import app.GUI.ChoiceTable;
import app.GUI.LogIn;

public class cApplication {
    private ChoiceTable choiceTable_panel;
    private LogIn login_panel;
    public cApplication(Application view) {

        view.button_table.addActionListener(e -> {
            if (choiceTable_panel != null &&
                choiceTable_panel.isVisible()
            ) return;
            choiceTable_panel = new ChoiceTable();
        });

        view.button_online.addActionListener(e -> {
            if (login_panel != null &&
                login_panel.isVisible()
            ) return;
            login_panel = new LogIn();
        });
    }
}
