
import restourant.UI.User;
import restourant.hall.Menu;

public class Main {
    public static void main(String[] args) {
        Menu sharedMenu = new Menu();

        new User(sharedMenu);
    }
}