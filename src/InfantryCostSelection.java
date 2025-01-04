import java.util.ArrayList;
import java.util.Scanner;

public class InfantryCostSelection extends CreationMenu {
    private int unitPoints;
    private final ArrayList<WargameInput> inputs;

    public InfantryCostSelection(Scanner scanner, int maxPoints) {
        super(scanner, "Création d'une unité");

        final ArrayList<WargameInput> constructInputs = new ArrayList<>();

        constructInputs.add(new WargameInput("Nombre de points de l'unité", input -> {
            try {
                int intInput = Integer.parseInt(input);

                if (intInput < 1) {
                    System.out.println("\nLe nombre de points doit être supérieur à 0");
                    return false;
                }

                if(intInput > maxPoints) {
                    System.out.println("\nLe coût est trop important pour l'ajouter à cette armée.");
                    return false;
                }

                this.unitPoints = intInput;
                return true;

            } catch (NumberFormatException e) {
                System.out.println("\nVeuillez entrer un nombre valide.");
                return false;
            }
        }));

        inputs = constructInputs;

        create(inputs);

    }

    public int getUnitPoints() {
        return unitPoints;
    }


}
