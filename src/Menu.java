import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

public class Menu {

    private final String title;
    private final ArrayList<String> options;
    private final boolean isIntegerChoiceOnly;
    private final String choiceSentence;
    private final boolean isConfirmationMenu;

    // Displaying a menu with its title and options
    public void displayMenu(Menu menu) {

        if(menu.title.isEmpty()) {
            throw new IllegalArgumentException("The menu is not correctly defined and can't be displayed");
        }

        System.out.printf("\n\n-----> %s <------\n\n", menu.title);

        if(menu.options != null && !menu.options.isEmpty()) {
            for (int i = 0; i < menu.options.size(); ++i) {
                System.out.printf("%d. %s\n", i + 1, menu.options.get(i));
            }
        }
        System.out.println();

        waitForAnswer();
    }

    public Consumer<String>  treatChoiceString = choice -> {};
    public Consumer<Integer> treatChoiceInt    = choice -> {};

    public void waitForAnswer() {

        Scanner inputScan = new Scanner(System.in);

        if(isConfirmationMenu) {

            String input = null;

            while (input == null) {
                System.out.print(this.choiceSentence);

                input = inputScan.nextLine();
            }

            treatChoiceString.accept(input);

        }

        else {

            if (isIntegerChoiceOnly) {

                Integer input = null;

                while (input == null) {
                    System.out.print(this.choiceSentence);

                    if (inputScan.hasNextInt()) {
                        input = inputScan.nextInt();

                        if (options != null && !options.isEmpty() && (input < 1 || input > this.options.size())) {
                            input = null;

                            System.out.println("Choix non valide... Veuillez réessayer");
                        }
                    } else {
                        System.out.println("Choix non valide... Veuillez réessayer");
                    }
                }

                treatChoiceInt.accept(input);

            } else {

                String input = null;

                while (input == null) {
                    System.out.print(this.choiceSentence);

                    input = inputScan.nextLine();

                    if (input.isEmpty()) {
                        input = null;
                        System.out.println("Entrée non valide... Veuillez ressayer");
                    }
                }

                treatChoiceString.accept(input);
            }
        }
    }

    // Display its menu
    public void display() {
        displayMenu(this);
    }

    public Menu() {
        throw new IllegalArgumentException("Missing arguments to create a menu");
    }

    public Menu(String title, ArrayList<String> options, String choiceSentence, boolean isIntegerChoiceOnly, boolean isConfirmationMenu) {
        if(title.isEmpty()) {
            throw new IllegalArgumentException("Missing or empty arguments to create a menu");
        }

        this.title = title;
        this.options = options;
        this.isIntegerChoiceOnly = isIntegerChoiceOnly;
        this.choiceSentence = choiceSentence == null ? "> " : choiceSentence + " ";
        this.isConfirmationMenu = isConfirmationMenu;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public boolean isIntegerChoiceOnly() {
        return isIntegerChoiceOnly;
    }

    public String getChoiceSentence() {
        return choiceSentence;
    }

    public boolean isConfirmationMenu() {
        return isConfirmationMenu;
    }
}
