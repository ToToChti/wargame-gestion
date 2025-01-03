import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArmyActionsMenu extends SelectionMenu {
    private final ArrayList<Army> armies;
    private final int selectedArmy;

    public ArmyActionsMenu(Scanner scanner, ArrayList<Army> armies, int selectedArmy) {
        super(scanner, "Que souhaitez-vous faire sur votre armée " + armies.get(selectedArmy).getName() + " ?", createOptions());

        this.armies = armies;
        this.selectedArmy = selectedArmy;
        this.openMenu();
    }

    private static ArrayList<String> createOptions() {
        return new ArrayList<>(
                Arrays.asList(
                        "Ajouter un groupe d'unité",
                        "Sélectionner un groupe d'unité",
                        "Afficher un groupe d'unité"
                )
        );
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
        switch (answer) {
            case 0:
                System.out.println("|> Retour au menu principal <|");
                break;

            case 1:
                System.out.println("Cas 1");
                // GroupCreationMenu groupMenu = new GroupCreationMenu(scanner);
                // if (menu.createGroup()) armies.get(selectedArmy).add(groupMenu.getGroup());
                openMenu();
                break;

            case 2:
                System.out.println("Cas 2");
                //new GroupSelection(scanner, armies, selectedArmy);
                openMenu();
                break;

            case 3:
                for (UnitGroup unitGroup : armies.get(selectedArmy).getGroups()) {
                    unitGroup.display();
                }
                openMenu();
                break;

            default:
                throw new InputMismatchException("An error occurred while reading the answer.");
        }
    }
}
