import java.util.*;

public class UnitCreation extends CreationMenu {
    private String unitName;
    private int unitCost;
    private int transportCapacity;
    private final UnitType unitType;
    private final VehicleType vehicleType;
    private final InfantryType infantryType;

    public UnitCreation(Scanner scanner, int maxPoints, UnitType unitType, InfantryType infantryType, VehicleType vehicleType) {
        super(scanner, "Création d'unité");

        this.unitType       = unitType;
        this.vehicleType    = vehicleType;
        this.infantryType   = infantryType;

        final ArrayList<WargameInput> constructInputs = new ArrayList<>();

        constructInputs.add(new WargameInput("Choisissez un nom pour votre unité", input -> {
            this.unitName = input;
            return true;
        }));

        constructInputs.add(new WargameInput("Nombre de points maximal de l'armée", input -> {
            try {
                int intInput = Integer.parseInt(input);

                if (intInput < 1) {
                    System.out.println("\nLe nombre de points doit être supérieur à 0");
                    return false;
                }

                if (intInput > maxPoints) {
                    System.out.println("\nLe cout est trop élevé pour entrer dans l'armée (max " + maxPoints + " points)");
                    return false;
                }

                this.unitCost = intInput;
                return true;

            } catch (NumberFormatException e) {
                System.out.println("\nVeuillez entrer un nombre valide.");
                return false;
            }
        }));

        if(unitType == UnitType.Vehicle && vehicleType == VehicleType.TRANSPORT) {
            constructInputs.add(new WargameInput("Capacité de transport", input -> {
                try {
                    int intInput = Integer.parseInt(input);

                    if (intInput < 1) {
                        System.out.println("\nLa capacité de transport doit être supérieur à 0");
                        return false;
                    }

                    this.transportCapacity = intInput;
                    return true;

                } catch (NumberFormatException e) {
                    System.out.println("\nVeuillez entrer un nombre valide.");
                    return false;
                }
            }));
        }

        create(constructInputs);
    }

    public Unit getUnit() {
        if(unitType.equals(UnitType.Vehicle) && vehicleType.equals(VehicleType.TRANSPORT)) {
            return new Vehicle(unitName, unitCost, transportCapacity);
        }
        else if(unitType == UnitType.Vehicle) {
            return new Vehicle(unitName, unitCost, vehicleType);
        }
        else if(unitType == UnitType.Infantry) {
            return new Infantry(unitName, unitCost, infantryType);
        }

        return null;
    }
}
