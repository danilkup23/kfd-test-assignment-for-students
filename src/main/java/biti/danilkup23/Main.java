package biti.danilkup23;
import biti.danilkup23.controller.LibraryController;
import biti.danilkup23.view.MenuView;


public class Main {
    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();
        MenuView menu = new MenuView(libraryController);
        menu.execute();
    }
}