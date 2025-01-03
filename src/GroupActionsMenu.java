import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GroupActionsMenu extends SelectionMenu {
    private final Army army;
    private final int selectedGroup;

    public GroupActionsMenu(Scanner scanner, Army army, int selectedGroup) {
        super(scanner, "Que souhaitez-vous faire sur votre groupe d'unité \"" + army.getGroup(selectedGroup).getName() + "\" ?", createOptions());

        this.army = army;
        this.selectedGroup = selectedGroup;
        this.openMenu();
    }

    private static ArrayList<String> createOptions() {
        return new ArrayList<>(
            Arrays.asList(
                "Ajouter une unité",
                "Sélectionner une unité à supprimer",
                "Afficher le groupe d'unité",
                "Supprimer le groupe d'unité"
            )
        );
    }

    protected void treatAnswer(int answer) {
        final UnitGroup group = army.getGroup(selectedGroup);

        switch (answer) {
            case 0:
                System.out.println("|> Retour au menu précédent <|");
                break;

            case 1:
                System.out.println("Cas 1");
                /*
                UnitCreationMenu menu = new UnitCreationMenu(scanner);
                if (menu.createUnit()) {
                    army.add(menu.getUnit());
                    System.out.println("Unitée ajoutée avec succès");
                }

                openMenu();
                */
                break;

            case 2:
                new UnitSelection(scanner, group);
                openMenu();
                break;

            case 3:
                group.display();
                openMenu();
                break;

            case 4:
                this.army.remove(selectedGroup);
                System.out.println("Groupe d'unité supprimé avec succès");
                break;

            default:
                throw new InputMismatchException("An error occurred while reading the answer.");
        }
    }
}
