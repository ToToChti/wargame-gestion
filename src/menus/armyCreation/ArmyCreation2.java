package menus.armyCreation;

import menus.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class ArmyCreation2 extends Menu {

    private static final String title = "Création d'armée";
    private static ArrayList<String> options;
    private static final String askSentence = "Choisissez la faction ou donnez le nom de votre nouvelle faction si elle n'existe pas encore (q pour quitter) (2/3) : ";
    private final HashMap<String, Menu> menusList;


    private String armyName;



    public ArmyCreation2(HashMap<String, Menu> menusList, ArrayList<String> factions) {
        super(title, options, askSentence);

        this.menusList = menusList;
        options = factions;
    }


    public void openMenu(String armyName) {

        this.armyName = armyName;

        // Displaying the menu
        display();

        // Waiting for user answer
        String answer = waitForChoiceString();

        // Treat user answer
        treatAnswer(answer);

    }

    private void treatAnswer(String answer) {
        String finalFactionName = null;

        if(answer.equals("q")) {
            menusList.get("1").openMenu();
        }

        else {
            if (answer.matches("-?\\d+(\\.\\d+)?")) {
                if (Integer.parseInt(answer) >= 1 && Integer.parseInt(answer) <= options.size()) {
                    finalFactionName = options.get(Integer.parseInt(answer) - 1);
                } else {
                    finalFactionName = answer;
                    options.add(finalFactionName);
                }
            }

            else {
                finalFactionName = answer;
                options.add(finalFactionName);
            }

            menusList.get("2.3").openMenu(this.armyName, finalFactionName);
        }
    }


}
