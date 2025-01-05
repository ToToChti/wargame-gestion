import java.util.*;

public class ArmyCreationMenu extends CreationMenu {
    private String armyName;
    private String armyFaction;
    private int armyMaxPoints;
    private final ArrayList<WargameInput> inputs;

    public ArmyCreationMenu(Scanner scanner, ArrayList<Army> armies) {
        super(scanner, "Création d'une nouvelle armée");

        final ArrayList<WargameInput> constructInputs = new ArrayList<>();

        constructInputs.add(new WargameInput("Choisissez un nom pour votre armée", input -> {
            boolean alreadyExists = armies.stream().anyMatch(army -> army.getName().equalsIgnoreCase(input));
            if (alreadyExists) {
                System.out.println("Une armée portant ce nom existe déjà");
                return false;
            }

            this.armyName = input;
            return true;
        }));

        constructInputs.add(new WargameInput("Nom de la faction de votre armée", input -> {
            this.armyFaction = input;
            return true;
        }));

        constructInputs.add(new WargameInput("Nombre de points maximal de votre armée", input -> {
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
