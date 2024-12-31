import java.util.ArrayList;
import java.util.HashMap;

import menus.*;
import menus.armyCreation.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Army> armyList = new ArrayList<>();
        ArrayList<String> factions = new ArrayList<>();

        // Army creation
        Army mordorArmy = new Army("L'armée du Mordor", "Mordor", 100);

        // Group unit creation
        UnitGroup myGroup = new UnitGroup("Archée montée");
        mordorArmy.add(myGroup);
        myGroup.addUnit(new Vehicle("Elephant de guerre", 10, 5));
        myGroup.addUnit(new Infantry("Archée", 2, InfantryType.SOLDIER));

        UnitGroup myGroup2 = new UnitGroup("Troll des montagnes");
        mordorArmy.add(myGroup2);
        myGroup2.addUnit(new Infantry("Trolls de Pierre", 5, InfantryType.SOLDIER));
        myGroup2.addUnit(new Infantry("Trolls à plusieurs têtes", 10, InfantryType.SPECIAL));
        myGroup2.addUnit(new Infantry("Trolls des Neiges", 12, InfantryType.HEAVY));

        mordorArmy.displayAll();

        myGroup2.removeUnit(0);
        myGroup2.display();

        mordorArmy.remove(1);
        mordorArmy.displayAll();

        try {
            myGroup2.removeUnit(1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        Army humanArmy = new Army("Les Royaumes des Hommes", "Humain", 100);

        armyList.add(mordorArmy);
        armyList.add(humanArmy);



        // Menus list
        HashMap<String, Menu> menusList = new HashMap<>();

        // Default menu
        menusList.put("1", new MainMenu(menusList));

        // Army creation menus
        menusList.put("2.1", new ArmyCreation1(menusList));
        menusList.put("2.2", new ArmyCreation2(menusList, factions));
        menusList.put("2.3", new ArmyCreation3(menusList));
        // menusList.put("2.4", new ArmyCreation4(menusList, armyList, factions));


        // Opening main menu on start
        menusList.get("1").openMenu();


    }
}