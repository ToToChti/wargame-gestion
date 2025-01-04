import java.util.ArrayList;
import java.util.Scanner;

public class GroupSelection extends SelectionMenu {
    private final int selectedArmy;
    private final ArrayList<Army> armies;

    public GroupSelection(Scanner scanner, ArrayList<Army> armies, int selectedArmy) {
        super(scanner, "Sélection de du groupe d'unité", createOptions(armies.get(selectedArmy))        );
        this.selectedArmy = selectedArmy;
        this.armies = armies;

        this.openMenu();
    }

    private static ArrayList<String> createOptions(Army army) {
        ArrayList<String> options = new ArrayList<>();
        for (UnitGroup unitGroup : army.getGroups()) {
            options.add(unitGroup.getName());
        }
        return options;
    }

    protected void treatAnswer(int answer) {
        if (answer == 0) {
            System.out.println("|> Retour au menu précédent <|");
            return;
        }
        new GroupActionsMenu(scanner, armies, selectedArmy, answer - 1);
    }
}