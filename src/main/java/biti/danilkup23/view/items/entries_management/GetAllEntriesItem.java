package biti.danilkup23.view.items.entries_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;

public class GetAllEntriesItem implements MenuItem {
    private LibraryController libraryController;

    public GetAllEntriesItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        libraryController.getEntryController().getAll();
    }

    @Override
    public String getDescription() {
        return "Print information of all entries";
    }
}
