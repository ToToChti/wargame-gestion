import java.util.ArrayList;
import java.util.Scanner;

public abstract class SelectionMenu {
    public final Scanner scanner;
    private final String title;
    private final ArrayList<String> options;

    public SelectionMenu(Scanner scanner, String title, ArrayList<String> options) {
        this.scanner = scanner;
        this.title = title;
        this.options = options;
    }
    public abstract void openMenu();

    public void display() {
        // Displaying title
        System.out.printf("\n\n-----> %s <------\n\n", this.title);

        // Displaying options
        System.out.println("0. Retour au menu précédent");
        for (int i = 0; i < this.options.size(); ++i) {
            System.out.printf("%d. %s\n", i + 1, this.options.get(i));
        }
    }

    public int waitSelection() {
        int choice = 0;
        boolean correct = false;

        while (!correct) {
            // Ask for user input
            System.out.print("\n> ");

            if (!scanner.hasNextInt()) {
                System.out.println("Choix non valide, veuillez entrer un nombre.");
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
}
