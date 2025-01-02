import java.util.*;

public class MainMenu extends SelectionMenu {
    private final ArrayList<Army> armies;

    public MainMenu(Scanner scanner, ArrayList<Army> initialArmies) {
        super(scanner, "Menu Principal", createOptions());

        this.armies = initialArmies;
        this.openMenu();
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

    public void openMenu() {
        // Displaying the menu
        display();

        // Waiting for user answer
        int answer = waitSelection();

        // Treat user answer
        treatAnswer(answer);
    }

    private void treatAnswer(int answer) {
        switch (answer) {
            case 0:
                System.out.println("Merci d'avoir utilisé Wargame Gestion ! A bientôt...");
                break;
            case 1:
                CreateArmyMenu menu = new CreateArmyMenu(scanner);
                if (menu.createArmy()) armies.add(menu.getArmy());
                openMenu();
                break;

            case 2:
                // menusList.get("3").openMenu(); // TODO: Change menu id
                new ArmySelection(scanner, armies);
                openMenu();
                break;

            case 3:
                for (Army army : armies) {
                    army.displayAll();
                }
                openMenu();
                break;

            default:
                throw new InputMismatchException("An error occurred while reading the answer.");
        }
    }


}
