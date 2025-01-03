import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Army> initialArmies = new ArrayList<>();

        // Création de l'armée du Mordor
        Army mordorArmy = new Army("L'armée du Mordor", "Mordor", 100);

        // Groupes et unités du Mordor
        UnitGroup cavalryGroup = new UnitGroup("Cavalerie d'Olog-haïs");
        mordorArmy.add(cavalryGroup);
        cavalryGroup.addUnit(new Vehicle("Mûmakil de guerre", 10, 5));
        cavalryGroup.addUnit(new Infantry("Archers orques", 2, InfantryType.SOLDIER));

        UnitGroup trollGroup = new UnitGroup("Trolls des montagnes");
        mordorArmy.add(trollGroup);
        trollGroup.addUnit(new Infantry("Trolls de Pierre", 5, InfantryType.SOLDIER));
        trollGroup.addUnit(new Infantry("Trolls à plusieurs têtes", 10, InfantryType.SPECIAL));
        trollGroup.addUnit(new Infantry("Trolls des Neiges", 12, InfantryType.HEAVY));

        // Création de l'armée du Rohan
        Army rohanArmy = new Army("Les Cavaliers du Rohan", "Rohan", 100);

        // Groupes et unités du Rohan
        UnitGroup ridersGroup = new UnitGroup("Cavaliers d'élite");
        rohanArmy.add(ridersGroup);
        ridersGroup.addUnit(new Vehicle("Cheval de guerre du Rohan", 8, 1));
        ridersGroup.addUnit(new Infantry("Riders of the Mark", 3, InfantryType.SOLDIER));
        ridersGroup.addUnit(new Infantry("Capitaine Eorlingas", 7, InfantryType.LEADER));

        UnitGroup infantryGroup = new UnitGroup("Infanterie légère");
        rohanArmy.add(infantryGroup);
        infantryGroup.addUnit(new Infantry("Lanciers du Rohan", 4, InfantryType.SOLDIER));
        infantryGroup.addUnit(new Infantry("Archers de la vallée", 3, InfantryType.SOLDIER));

        // Création de l'armée du Gondor
        Army gondorArmy = new Army("L'armée du Gondor", "Gondor", 100);

        // Groupes et unités du Gondor
        UnitGroup guardsGroup = new UnitGroup("Gardes de la Citadelle");
        gondorArmy.add(guardsGroup);
        guardsGroup.addUnit(new Infantry("Gardes de Minas Tirith", 6, InfantryType.HEAVY));
        guardsGroup.addUnit(new Infantry("Commandant de la Citadelle", 10, InfantryType.LEADER));

        UnitGroup siegeGroup = new UnitGroup("Machines de siège");
        gondorArmy.add(siegeGroup);
        siegeGroup.addUnit(new Vehicle("Trébuchet du Gondor", 15, VehicleType.ATTACK));
        siegeGroup.addUnit(new Infantry("Équipe de maintenance", 4, InfantryType.SPECIAL));

        // Ajout des armées dans la liste initiale
        initialArmies.add(mordorArmy);
        initialArmies.add(rohanArmy);
        initialArmies.add(gondorArmy);

        Scanner scanner = new Scanner(System.in);

        new MainActionsMenu(scanner, initialArmies);

        scanner.close();
    }
}