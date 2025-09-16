package biti.danilkup23.view.items.users_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.items.books_management.GetAllBooksItem;

public class GetAllUsersItem implements MenuItem {
    private LibraryController libraryController;

    public GetAllUsersItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        libraryController.getUserController().getAllUsers();
    }

    @Override
    public String getDescription() {
        return "Print information of all users";
    }
}
