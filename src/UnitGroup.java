import java.util.ArrayList;

public class UnitGroup {
    private final String name;
    private int groupCost;
    private final ArrayList<Unit> units;

    public UnitGroup(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du groupe ne peut pas être vide.");
        }

        this.name = name;
        this.groupCost = 0;
        this.units = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public int getGroupCost() {
        return groupCost;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
        groupCost += unit.getCost();
    }

    public void removeUnit(int index) {
        if (units.isEmpty()) {
            throw new IllegalStateException("Le groupe est vide. Aucune unité ne peut être supprimée.");
        }

        if (index < 0 || index >= units.size()) {
            throw new IndexOutOfBoundsException("Index \"" + index + "\" invalide. Index maximal autorisé : " + (units.size() - 1));
        }

        Unit unitRemoved = units.remove(index);
        groupCost -= unitRemoved.getCost();
    }

    public void display() {
        System.out.println("- " + name);
        System.out.println("\tCoût total : " + groupCost);

        if (units.isEmpty()) {
            System.out.println("\tAucune unité enregistrée dans le groupe.");
        } else {
            System.out.println("\tListe des unités présentes :");
            for (Unit unit : units) {
                System.out.println("\t\t" + unit);
            }
        }
    }
}
