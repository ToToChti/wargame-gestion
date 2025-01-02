import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArmySelection extends SelectionMenu {
    private final ArrayList<Army> armies;

    public ArmySelection(Scanner scanner, ArrayList<Army> armies) {
        super(scanner, "Sélection de l'armée", createOptions(armies)        );
        this.armies = armies;

        this.openMenu();
    }

    private static ArrayList<String> createOptions(ArrayList<Army> armies) {
        ArrayList<String> options = new ArrayList<>();
        for (Army army : armies) {
            options.add(army.getName());
        }
        return options;
    }

    public void openMenu() {
        // Displaying the menu
        display();

        // Waiting for user answer
        int answer = waitSelection();

        // 0 mean cancel to previous
        if (answer == 0) return;

        // Treat user answer
        treatAnswer(answer);
    }

    private void treatAnswer(int answer) {
        final Army army = armies.get(answer - 1);
        army.displayAll();
        // TODO : Menu pour une armée spécifique
    }
}
