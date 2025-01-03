import java.util.ArrayList;

public class Army {
    private final String name;
    private final String faction;
    private final int maxPoint;
    private final ArrayList<UnitGroup> group;

    public Army(String name, String faction, int maxPoint) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'armée ne peut pas être vide.");
        }
        if (faction.trim().isEmpty()) {
            throw new IllegalArgumentException("La faction de l'armée ne peut pas être vide.");
        }
        if (maxPoint <= 0) {
            throw new IllegalArgumentException("Le nombre maximal de points doit être strictement positif.");
        }

        this.name = name;
        this.faction = faction;
        this.maxPoint = maxPoint;
        this.group = new ArrayList<>();
    }

    public void add(UnitGroup group) {
        this.group.add(group);
    }

    public void remove(int index) {
        if (group.isEmpty()) {
            throw new IllegalStateException("Aucun groupe d'unités à supprimer.");
        }
        if (index < 0 || index >= group.size()) {
            throw new IndexOutOfBoundsException("Index invalide : " + index + ". Les indices valides sont entre 0 et " + (group.size() - 1) + ".");
        }

        group.remove(index);
    }

    public int getTotalCost() {
        int usedPoint = 0;
        for (UnitGroup group : group) {
            usedPoint += group.getGroupCost();
        }
        return usedPoint;
    }

    public String getName() {
        return name;
    }

    public ArrayList<UnitGroup> getGroups() {
        return group;
    }

    public UnitGroup getGroup(int index) {
        if (group.isEmpty()) {
            throw new IllegalStateException("Aucun groupe d'unités à sélectionner");
        }
        if (index < 0 || index >= group.size()) {
            throw new IndexOutOfBoundsException("Index invalide : " + index + ". Les indices valides sont entre 0 et " + (group.size() - 1) + ".");
        }

        return group.get(index);
    }

    public void displayGroups() {
        for (UnitGroup group : group) {
            group.display();
        }
    }

    public void displayAll() {
        String separator = "";
        for (int i = 0; i < 20; i++) {
            separator = separator.concat("-");
        }

        System.out.println(separator);
        System.out.println(name);
        System.out.println("Fait partie de la faction : " + faction);
        System.out.println("Point" + (maxPoint > 1 ? "s" : "") + " max : " + maxPoint);
        final int totalCost = getTotalCost();
        System.out.println("Point" + (totalCost > 1 ? "s" : "") + " utilisés : " + totalCost + "\n");

        if (group.isEmpty()) {
            System.out.println("Aucun groupe d'unités enregistré.");
        } else {
            System.out.println("Est constitué de : ");
            displayGroups();
        }

        System.out.println(separator);
    }
}
