public abstract class Unit {
    private final String name;
    private final int cost;

    public Unit(String name, int cost) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'unité ne peut pas être vide.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Le coût de l'unité ne peut pas être négatif.");
        }

        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public abstract String toString();

    public void print() {
        System.out.print(this.toString());
    }
}