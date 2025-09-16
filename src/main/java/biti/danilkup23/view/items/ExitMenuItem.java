package biti.danilkup23.view.items;

import biti.danilkup23.view.AbstractMenuManager;
import biti.danilkup23.view.MenuView;

public class ExitMenuItem implements MenuItem {
    private final AbstractMenuManager menu;

    public ExitMenuItem(AbstractMenuManager abstractMenuManager) {
        this.menu = abstractMenuManager;
    }

    @Override
    public void execute() {
        menu.setStartingFalse();
    }

    @Override
    public String getDescription() {
        if (menu instanceof MenuView) return "Exit from application";
        else return "Back to the previous menu";
    }
}
