import javax.lang.model.UnknownEntityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GroupActionsMenu extends SelectionMenu {
    private final ArrayList<Army> armies;
    private final int selectedArmy;
    private final int selectedGroup;

    public GroupActionsMenu(Scanner scanner, ArrayList<Army> armies, int selectedArmy, int selectedGroup) {
        super(scanner, "Que souhaitez-vous faire sur votre groupe d'unité \"" + armies.get(selectedArmy).getGroup(selectedGroup).getName() + "\" ?", createOptions());

        this.armies = armies;
        this.selectedArmy = selectedArmy;
        this.selectedGroup = selectedGroup;
        this.openMenu();
    }

    private static ArrayList<String> createOptions() {
        return new ArrayList<>(
            Arrays.asList(
                "Ajouter une unité",
                "Sélectionner une unité à supprimer",
                "Afficher le groupe d'unité",
                "Supprimer le groupe d'unité"
            )
        );
    }

    protected void treatAnswer(int answer) {
        final UnitGroup group = armies.get(selectedArmy).getGroup(selectedGroup);

        switch (answer) {
            case 0:
                System.out.println("|> Retour au menu précédent <|");
                break;

            case 1:

                // Getting unit type
                UnitTypeSelection menuTypeSelection = new UnitTypeSelection(scanner);
                UnitType unitType = menuTypeSelection.getUnitType();

                if(unitType == null) break;

                // Getting unit specific type
                SpecificTypeSelection menuSpecificTypeSelection = new SpecificTypeSelection(scanner, unitType);

                InfantryType specificTypeInfantry = null;
                VehicleType specificTypeVehicle = null;

                switch (unitType) {
                    case Infantry:
                        specificTypeInfantry = InfantryType.valueOf(menuSpecificTypeSelection.getSpecificType());
                        break;
                    case Vehicle:
                        specificTypeVehicle = VehicleType.valueOf(menuSpecificTypeSelection.getSpecificType());
                        break;
                    default:
                        throw new InputMismatchException("Unrecognized specific type for unit");
                }


                UnitCreation menuCreationUnit = new UnitCreation(scanner, armies.get(selectedArmy).getMaxPoint() - armies.get(selectedArmy).getTotalCost(), unitType, specificTypeInfantry, specificTypeVehicle);
                Unit newUnit = menuCreationUnit.getUnit();

                if (newUnit != null) {
                    armies.get(selectedArmy).getGroup(selectedGroup).addUnit(newUnit);
                    System.out.println("Unité ajouté avec succès");
                }

                else {
                    throw new IllegalArgumentException("Error while creating the unit.");
                }

                openMenu();

                break;

            case 2:
                new UnitSelection(scanner, group);
                openMenu();
                break;

            case 3:
                group.display();
                openMenu();
                break;

            case 4:
                this.armies.get(selectedArmy).remove(selectedGroup);
                System.out.println("Groupe d'unité supprimé avec succès");
                break;

            default:
                throw new InputMismatchException("An error occurred while reading the answer.");
        }
    }
}
