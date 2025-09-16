package biti.danilkup23.view;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.ExitMenuItem;
import biti.danilkup23.view.items.books_management.BookManager;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.items.entries_management.EntryManager;
import biti.danilkup23.view.items.users_management.UserManager;

public class MenuView extends AbstractMenuManager{
    private LibraryController libraryController;

    public MenuView(LibraryController libraryController) {
        this.libraryController = libraryController;

        menuItems.put(1, new BookManager(libraryController));
        menuItems.put(2, new UserManager(libraryController));
        menuItems.put(3, new EntryManager(libraryController));
        menuItems.put(0, new ExitMenuItem(this));
    }

	@Override
	public String getDescription() {
        return "Main Menu";
	}

}
