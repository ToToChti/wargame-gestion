import java.util.*;

public class SpecificTypeSelection extends SelectionMenu {
    private final UnitType unitType;
    private InfantryType infantryType;
    private VehicleType vehicleType;

    public SpecificTypeSelection(Scanner scanner, UnitType unitType) {
        super(scanner, "Sélection du type spécifique de l'unité", createOptions(unitType));

        this.unitType = unitType;
        this.openMenu();
    }

    private static ArrayList<String> createOptions(UnitType unitType) {
        ArrayList<String> options = new ArrayList<>();

        if(unitType == UnitType.Vehicle) {
            for(VehicleType type : VehicleType.values()) {
                options.add(type.name());
            }
        }

        else if(unitType == UnitType.Infantry) {
            for(InfantryType type : InfantryType.values()) {
                options.add(type.name());
            }
        }

        return options;
    }

    protected void treatAnswer(int answer) {
        if (answer == 0) {
            vehicleType = null;
            infantryType = null;
        }
        else {
            switch (unitType) {
                case Vehicle:
                    vehicleType = VehicleType.values()[answer - 1];
                    break;

                case Infantry:
                    infantryType = InfantryType.values()[answer - 1];
                    break;
            }
        }
    }

    public String getSpecificType() {
        return switch (unitType) {
            case Vehicle -> vehicleType.name();
            case Infantry -> infantryType.name();
        };

    }
}
