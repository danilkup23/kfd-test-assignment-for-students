package biti.danilkup23.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import biti.danilkup23.view.utils.InputValidatorUtil;
import biti.danilkup23.view.items.MenuItem;

public abstract class AbstractMenuManager implements MenuItem {

    protected Map<Integer, MenuItem> menuItems = new HashMap<>();
    protected Boolean isStarting = true;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {

        isStarting = true;

        while (isStarting) {
            for (Map.Entry<Integer, MenuItem> menuItem : menuItems.entrySet()) {
                System.out.println(menuItem.getKey() + ". " + menuItem.getValue().getDescription());
            }

            int choice = InputValidatorUtil.getValidatedInteger("Please input a choice", "Choice", scanner);


            menuItems.get(choice).execute();
        }
    }

    public void setStartingFalse() {
        isStarting = false;
    }
}