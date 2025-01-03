import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateArmyMenu extends CreationMenu {
    private String armyName;
    private String armyFaction;
    private int armyMaxPoints;
    private final ArrayList<WargameInput> inputs;

    public CreateArmyMenu(Scanner scanner) {

        super(scanner, "Menu création armée");

        final ArrayList<WargameInput> constructInputs = new ArrayList<>();

        constructInputs.add(new WargameInput("Choisissez un nom pour votre armée", input -> {
            this.armyName = input;
            return true;
        }));

        constructInputs.add(new WargameInput("Choisissez la faction ou donnez le nom de votre nouvelle faction si elle n'existe pas encore", input -> {
            this.armyFaction = input;
            return true;
        }));

        constructInputs.add(new WargameInput("Nombre de points maximal de l'armée", input -> {
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

        inputs = constructInputs;
    }

    public boolean createArmy() {
        return create(inputs);
    }

    public Army getArmy() {
        return new Army(armyName, armyFaction, armyMaxPoints);
    }
}
