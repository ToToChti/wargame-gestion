import java.util.*;

public class MainActionsMenu extends SelectionMenu {
    private final ArrayList<Army> armies;

    public MainActionsMenu(Scanner scanner, ArrayList<Army> initialArmies) {
        super(scanner, "Menu Principal", createOptions());

        this.armies = initialArmies;
        this.openMenu(true);
    }

    private static ArrayList<String> createOptions() {
        return new ArrayList<>(
            Arrays.asList(
                "Créer une nouvelle armée",
                "Sélectionner une armée existante",
                "Afficher l'ensemble des armées"
            )
        );
    }

    protected void treatAnswer(int answer) {
        switch (answer) {
            case 0:
                System.out.println("Merci d'avoir utilisé Wargame Gestion ! A bientôt...");
                break;

            case 1:
                ArmyCreationMenu menu = new ArmyCreationMenu(scanner);
                if (menu.createArmy()) {
                    armies.add(menu.getArmy());
                    System.out.println("Armée ajouté avec succès");

                    // Preselect army created
                    new ArmyActionsMenu(scanner, armies, armies.size() - 1);
                }

                openMenu(true);
                break;

            case 2:
                new ArmySelection(scanner, armies);
                openMenu(true);
                break;

            case 3:
                for (Army army : armies) {
                    army.displayAll();
                }
                openMenu(true);
                break;

            default:
                throw new InputMismatchException("An error occurred while reading the answer.");
        }
    }
}
