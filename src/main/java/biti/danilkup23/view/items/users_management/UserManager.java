package biti.danilkup23.view.items.users_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.AbstractMenuManager;
import biti.danilkup23.view.items.ExitMenuItem;

public class UserManager extends AbstractMenuManager {
    private LibraryController libraryController;

    public UserManager(LibraryController libraryController) {
        this.libraryController = libraryController;

        menuItems.put(1, new GetAllUsersItem(libraryController));
        menuItems.put(2, new GetUserByIdItem(libraryController));
        menuItems.put(3, new AddUserItem(libraryController));
        menuItems.put(4, new RemoveUserByIdItem(libraryController));
        menuItems.put(5, new GetUserByFullNameItem(libraryController));
        menuItems.put(0, new ExitMenuItem(this));
    }

    @Override
    public String getDescription() {
        return "The user management";
    }
}
