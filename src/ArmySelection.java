import java.util.*;

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

    protected void treatAnswer(int answer) {
        if (answer == 0) {
            System.out.println("|> Retour au menu principal <|");
            return;
        }
        new ArmyActionsMenu(scanner, armies, answer - 1);
    }
}