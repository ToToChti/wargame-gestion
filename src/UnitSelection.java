import java.util.ArrayList;
import java.util.Scanner;

public class UnitSelection extends SelectionMenu {
    private final UnitGroup group;

    public UnitSelection(Scanner scanner, UnitGroup group) {
        super(scanner, "Sélection de l'unité à supprimer", createOptions(group)        );
        this.group = group;

        this.openMenu();
    }

    private static ArrayList<String> createOptions(UnitGroup group) {
        ArrayList<String> options = new ArrayList<>();
        for (Unit unit : group.getUnits()) {
            options.add(unit.getName());
        }
        return options;
    }

    protected void treatAnswer(int answer) {
        if (answer == 0) {
            System.out.println("|> Retour au menu précédent <|");
            return;
        }
        group.removeUnit(answer - 1);
        System.out.println("Unité supprimé avec succès");
    }
}