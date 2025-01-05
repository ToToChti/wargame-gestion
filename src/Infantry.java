public class Infantry extends Unit {
    private final InfantryType infantryType;

    public Infantry(String name, int cost, InfantryType infantryType) {
        super(name, cost);
        this.infantryType = infantryType;
    }

    public String getInfantryName() {
        return switch (infantryType) {
            case SOLDIER    -> "Soldat";
            case HEAVY      -> "Lourd";
            case SPECIAL    -> "Spécial";
            case LEADER     -> "Chef";
        };
    }

    public void print() {
        System.out.println("L'infanterie de type " + getInfantryName() + " \"" + super.getName() + "\" : " + super.getCost() + " point" + (super.getCost() > 1 ? "s" : ""));
    }
}
