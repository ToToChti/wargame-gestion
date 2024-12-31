package menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

public class MainMenu extends Menu {

    private static final String title = "Menu Principal";
    private static final ArrayList<String> options = new ArrayList<>(
            Arrays.asList(
                    "Créer une nouvelle armée",
                    "Afficher/Modifier une armée existante",
                    "Afficher l'ensemble des armées",
                    "Quitter"
            )
    );
    private static final String askSentence = ">";
    private HashMap<String, Menu> menusList;



    public MainMenu(HashMap<String, Menu> menusList) {
        super(title, options, askSentence);

        this.menusList = menusList;
    }


    public void openMenu() {

        // Displaying the menu
        display();

        // Waiting for user answer
        int answer = waitForChoiceInt();

        // Treat user answer
        treatAnswer(answer);

    }

    private void treatAnswer(int answer) {
        switch (answer) {
            case 1:
                menusList.get("2.1").openMenu();
                break;

            case 2:
                menusList.get("3").openMenu(); // TODO: Change menu id
                break;

            case 3:
                menusList.get("4").openMenu();  // TODO: Change menu id
                break;

            case 4:
                System.out.println("Merci d'avoir utilisé Wargame Gestion ! A bientôt...");
                System.exit(0);
                break;

            default:
                throw new InputMismatchException("An error occurred while reading the answer.");
        }
    }


}
