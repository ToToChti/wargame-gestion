package menus.armyCreation;

import menus.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmyCreation3 extends Menu {

    private static final String title = "Création d'armée";
    private static final ArrayList<String> options = null;
    private static final String askSentence = "Choisissez la faction ou donnez le nom de votre nouvelle faction si elle n'existe pas encore (q pour quitter) (2/3) : ";
    private final HashMap<String, Menu> menusList;


    private String armyName;
    private String faction;



    public ArmyCreation3(HashMap<String, Menu> menusList) {
        super(title, options, askSentence);

        this.menusList = menusList;
    }


    public void openMenu(String armyName, String faction) {

        this.armyName = armyName;
        this.faction = faction;

        // Displaying the menu
        display();

        // Waiting for user answer
        String answer = waitForChoiceString();

        // Treat user answer
        treatAnswer(answer);

    }

    private void treatAnswer(String answer) {
        if(answer.equals("q")) {
            menusList.get("1").openMenu();
        }
        else {
            menusList.get("1").openMenu();

            //menusList.get("2.4").openMenu(this.armyName, answer);
        }
    }


}
