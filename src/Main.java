import presentation.MainMenu;

public class Main {

    public static void main(String[] args) {
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("GMT+7"));
        MainMenu menu = new MainMenu();

        menu.main(args);
    }
}