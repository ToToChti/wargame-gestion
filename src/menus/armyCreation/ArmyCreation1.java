package menus.armyCreation;

import menus.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

public class ArmyCreation1 extends Menu {

    private static final String title = "Création d'armée";
    private static final ArrayList<String> options = null;
    private static final String askSentence = "Choisissez un nom pour votre armée (q pour annuler) (1/3) :";
    private final HashMap<String, Menu> menusList;



    public ArmyCreation1(HashMap<String, Menu> menusList) {
        super(title, options, askSentence);

        this.menusList = menusList;
    }


    public void openMenu() {

        // Displaying the menu
        display();

        // Waiting for user answer
        String answer = waitForChoiceString();

        // Treat user answer
        treatAnswer(answer);

    }

    private void treatAnswer(String answer) {
        if (answer.equals("q")) {
            menusList.get("1").openMenu();
        }
        else {
            menusList.get("2.2").openMenu(answer);
        }
    }
}
