import java.util.*;

public class UnitTypeSelection extends SelectionMenu {
    private UnitType unitType;

    public UnitTypeSelection(Scanner scanner) {
        super(scanner, "Sélection du type de l'unité", createOptions());

        this.openMenu();
    }

    private static ArrayList<String> createOptions() {
        ArrayList<String> options = new ArrayList<>();

        for(UnitType type : UnitType.values()) {
            options.add(type.name());
        }
        return options;
    }

    protected void treatAnswer(int answer) {
        if (answer == 0) {
            unitType = null;
        }
        else {
            unitType = UnitType.values()[answer - 1];
        }
    }

    public UnitType getUnitType() {
        return unitType;
    }
}
