import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class CreationMenu {
    public final Scanner scanner;
    private final String title;
    private final ArrayList<WargameInput> inputs;

    public CreationMenu(Scanner scanner, String title, ArrayList<WargameInput> inputs) {
        this.scanner = scanner;
        this.title = title;
        this.inputs = inputs;
    }

    public boolean create() {
        for (int i = 0; i < this.inputs.size(); i++) {
            // Displaying title
            System.out.printf("\n\n-----> %s <------\n\n", this.title);

            // Displaying inputs
            final WargameInput wargameInput = this.inputs.get(i);
            System.out.printf("%s (q pour quitter) (%d/%d) :\n", wargameInput.content, i + 1, this.inputs.size());

            // Request input

            if (!waitInputString(wargameInput.treatInput)) return false;
        }
        return true;
    }

    public boolean waitInputString(Function<String, Boolean> treatInput) {
        String input = null;
        boolean correct = false;

        while (!correct) {
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
