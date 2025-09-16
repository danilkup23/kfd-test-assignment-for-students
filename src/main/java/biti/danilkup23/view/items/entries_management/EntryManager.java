package biti.danilkup23.view.items.entries_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.AbstractMenuManager;
import biti.danilkup23.view.items.ExitMenuItem;
import biti.danilkup23.view.items.users_management.AddUserItem;

public class EntryManager extends AbstractMenuManager {
    private LibraryController libraryController;

    public EntryManager(LibraryController libraryController) {
        this.libraryController = libraryController;

        menuItems.put(0, new ExitMenuItem(this));
        menuItems.put(1, new GetAllEntriesItem(libraryController));
        menuItems.put(2, new GetEntryByIdItem(libraryController));
        menuItems.put(3, new AddEntryItem(libraryController));
    }


    @Override
    public String getDescription() {
        return "The entry management";
    }
}
