package biti.danilkup23.view.items.entries_management;

import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.items.MenuItem;
import biti.danilkup23.view.utils.InputValidatorUtil;

import java.util.Scanner;

public class GetEntryByIdItem implements MenuItem {
    private LibraryController libraryController;
    private final Scanner scanner = new Scanner(System.in);

    public GetEntryByIdItem(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    @Override
    public void execute() {
        int id = InputValidatorUtil.getValidatedInteger("Please enter a entry id", "Entry id", scanner);
        libraryController.getEntryController().getEntryById(id);
    }

    @Override
    public String getDescription() {
        return "Print information by entry id";
    }
}
