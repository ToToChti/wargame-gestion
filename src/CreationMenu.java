import java.util.*;
import java.util.function.*;

public class CreationMenu {
    public final Scanner scanner;
    private final String title;

    public CreationMenu(Scanner scanner, String title) {
        this.scanner = scanner;
        this.title = title;
    }

    protected boolean create(ArrayList<WargameInput> inputs) {
        for (int i = 0; i < inputs.size(); i++) {
            if(i == 0) {
                // Displaying title
                System.out.printf("\n\n䷀䷀䷀䷀䷀䷀ %s ䷀䷀䷀䷀䷀䷀\n", this.title);
            }

            // Displaying inputs
            final WargameInput wargameInput = inputs.get(i);
            System.out.printf("\n%s (q pour quitter) (%d/%d) :", wargameInput.content, i + 1, inputs.size());

            // Request input
            if (!waitInputString(wargameInput.treatInput)) return false;
        }
        return true;
    }

    private boolean waitInputString(Function<String, Boolean> treatInput) {
        String input;
        boolean correct = false;

        while (!correct) {
            System.out.print("\n> ");
            if (!scanner.hasNextLine()) {
                System.out.println("Choix non valide, veuillez réessayer");
                continue;
            }

            input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Choix non valide, veuillez réessayer");
                continue;
            }

            if (input.equals("q")) {
                System.out.println("Vous avez annulé la création");
                return false;
            }

            // Apply lambda function to save & check if the input is correct
            correct = treatInput.apply(input);
        }

        return true;
    }
}
