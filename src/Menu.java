import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final String title;
    private final ArrayList<String> options;
    private final boolean isIntegerChoiceOnly;

    // Displaying a menu with its title and options
    public void displayMenu(Menu menu) {

        if(menu.options.isEmpty() ||menu.title.isEmpty()) {
            throw new IllegalArgumentException("The menu is not correctly defined and can't be displayed");
        }

        System.out.printf("\n\n-----> %s <------\n\n", menu.title);

        for(int i = 0; i < menu.options.size(); ++i) {
            System.out.printf("%d. %s\n", i+1, menu.options.get(i));
        }

        System.out.println();

        waitForAnswer();
    }

    private void treatChoice(String choice) {

    }

    private void treatChoice(int choice) {

    }

    private void waitForAnswer() {

        Scanner inputScan = null;

        if(isIntegerChoiceOnly) {

            Integer input = null;

            while (input == null) {
                System.out.print("> ");

                inputScan = new Scanner(System.in);

                if(inputScan.hasNextInt()) {
                    input = inputScan.nextInt();

                    if(input < 1 || input > this.options.size()) {
                        input = null;

                        System.out.println("Choix non valide... Veuillez réessayer");
                    }
                }

                else {
                    System.out.println("Choix non valide... Veuillez réessayer");
                }
            }
            inputScan.close();

            treatChoice(input);
        }

        else {

            String input = null;

            while (input == null) {
                System.out.print("> ");

                inputScan = new Scanner(System.in);

                input = inputScan.nextLine();

                if(input.isEmpty()) {
                    input = null;
                    System.out.println("Entrée non valide... Veuillez ressayer");
                }
            }
            inputScan.close();
            treatChoice(input);
        }
    }

    // Display its menu
    public void display() {
        displayMenu(this);
    }

    public Menu() {
        throw new IllegalArgumentException("Missing arguments to create a menu");
    }

    public Menu(String title, ArrayList<String> options, boolean isIntegerChoiceOnly) {
        if(title.isEmpty() || options.isEmpty()) {
            throw new IllegalArgumentException("Missing or empty arguments to create a menu");
        }

        this.title = title;
        this.options = options;
        this.isIntegerChoiceOnly = isIntegerChoiceOnly;
    }
}
