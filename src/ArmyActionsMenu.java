import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArmyActionsMenu extends SelectionMenu {
    private final ArrayList<Army> armies;
    private final int selectedArmy;

    public ArmyActionsMenu(Scanner scanner, ArrayList<Army> armies, int selectedArmy) {
        super(scanner, "Que souhaitez-vous faire sur votre armée \"" + armies.get(selectedArmy).getName() + "\" ?", createOptions());

        this.armies = armies;
        this.selectedArmy = selectedArmy;
        this.openMenu();
    }

    private static ArrayList<String> createOptions() {
        return new ArrayList<>(
            Arrays.asList(
                "Ajouter un groupe d'unité",
                "Sélectionner un groupe d'unité",
                "Afficher l'armée",
                "Supprimer l'armée sélectionné"
            )
        );
    }

    protected void treatAnswer(int answer) {
        final Army army = armies.get(selectedArmy);

        switch (answer) {
            case 0:
                System.out.println("|> Retour au menu principal <|");
                break;

            case 1:
                GroupCreationMenu menu = new GroupCreationMenu(scanner);
                if (menu.createGroup()) {
                    army.add(menu.getGroup());
                    System.out.println("Groupe d'unité ajoutée avec succès");

                    // Preselect created UnitGroup
                    new GroupActionsMenu(scanner, armies, selectedArmy, army.getGroups().size() - 1);
                }

                openMenu();
                break;

            case 2:
                new GroupSelection(scanner, armies, selectedArmy);

                openMenu();
                break;

            case 3:
                army.displayAll();

                openMenu();
                break;

            case 4:
                armies.remove(selectedArmy);
                System.out.println("Armée supprimé avec succès");
                break;

            default:
                throw new InputMismatchException("An error occurred while reading the answer.");
        }
    }
}
