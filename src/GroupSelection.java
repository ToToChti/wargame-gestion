import java.util.ArrayList;
import java.util.Scanner;

public class GroupSelection extends SelectionMenu {
    private final Army army;

    public GroupSelection(Scanner scanner, Army army) {
        super(scanner, "Sélection de du groupe d'unité", createOptions(army)        );
        this.army = army;

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
        new GroupActionsMenu(scanner, army, answer - 1);
    }
}