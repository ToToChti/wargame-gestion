import java.util.*;

public abstract class SelectionMenu {
    public final Scanner scanner;
    private final String title;
    private final ArrayList<String> options;

    public SelectionMenu(Scanner scanner, String title, ArrayList<String> options) {
        this.scanner = scanner;
        this.title = title;
        this.options = options;
    }


    private void display(boolean isMainMenu) {
        if(isMainMenu) {
            System.out.println("\n" +
                    " __    __                                         ___          _   _             \n" +
                    "/ / /\\ \\ \\__ _ _ __ __ _  __ _ _ __ ___   ___    / _ \\___  ___| |_(_) ___  _ __  \n" +
                    "\\ \\/  \\/ / _` | '__/ _` |/ _` | '_ ` _ \\ / _ \\  / /_\\/ _ \\/ __| __| |/ _ \\| '_ \\ \n" +
                    " \\  /\\  / (_| | | | (_| | (_| | | | | | |  __/ / /_\\\\  __/\\__ \\ |_| | (_) | | | |\n" +
                    "  \\/  \\/ \\__,_|_|  \\__, |\\__,_|_| |_| |_|\\___| \\____/\\___||___/\\__|_|\\___/|_| |_|\n" +
                    "                   |___/                                                         \n");
        }

        // Displaying title
        System.out.printf("\n\n䷀䷀䷀䷀䷀䷀ %s ䷀䷀䷀䷀䷀䷀\n\n", this.title);

        if (this.options.isEmpty()) {
            System.out.println("Aucune donnée disponible, veuillez créer avant de sélectionner");
            return;
        }

        // Displaying options
        if(isMainMenu) {
            System.out.println("䷀ 0. Quitter");
        } else {
            System.out.println("䷀ 0. Retour au menu précédent");
        }

        for (int i = 0; i < this.options.size(); ++i) {
            System.out.printf("䷀ %d. %s\n", i + 1, this.options.get(i));
        }
    }

    private int waitSelection() {
        int choice = 0;
        boolean correct = false;

        while (!correct) {
            // Ask for user input
            System.out.print("\n> ");

            if (!scanner.hasNextInt()) {
                System.out.println("Choix non valide, veuillez entrer un nombre.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 0 || choice > options.size()) {
                System.out.printf("Choix non valide, veuillez réessayer (choix entre %d et %d).\n", 0, options.size());
                continue;
            }

            correct = true;
        }

        return choice;
    }

    protected abstract void treatAnswer(int answer);

    public void openMenu() {
        openMenu(false);
    }

    public void openMenu(boolean isMainMenu) {
        // Displaying the menu
        display(isMainMenu);

        if (this.options.isEmpty()) return;

        // Waiting for user answer
        int answer = waitSelection();

        // Treat user answer
        treatAnswer(answer);
    }
}
