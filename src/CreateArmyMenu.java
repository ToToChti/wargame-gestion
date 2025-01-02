import java.util.ArrayList;
import java.util.Scanner;

public class CreateArmyMenu {
    private String armyName;
    private String armyFaction;
    private int armyMaxPoints;
    private final CreationMenu creationMenu;

    public CreateArmyMenu(Scanner scanner) {
        final ArrayList<WargameInput> inputs = new ArrayList<>();

        inputs.add(new WargameInput("Choisissez un nom pour votre armée", input -> {
            this.armyName = input;
            return true;
        }));

        inputs.add(new WargameInput("Choisissez la faction ou donnez le nom de votre nouvelle faction si elle n'existe pas encore", input -> {
            this.armyFaction = input;
            return true;
        }));

        inputs.add(new WargameInput("Nombre de points maximal de l'armée", input -> {
            try {
                int intInput = Integer.parseInt(input);

                if (intInput < 1) {
                    System.out.println("\nLe nombre de points doit être supérieur à 0");
                    return false;
                }

                this.armyMaxPoints = intInput;
                return true;

            } catch (NumberFormatException e) {
                System.out.println("\nVeuillez entrer un nombre valide.");
                return false;
            }
        }));

        creationMenu = new CreationMenu(scanner, "Menu création armée", inputs);
    }

    public boolean createArmy() {
        return creationMenu.create();
    }

    public Army getArmy() {
        return new Army(armyName, armyFaction, armyMaxPoints);
    }
}
