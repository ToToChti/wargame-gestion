public class Vehicle extends Unit {
    private final int transportCapacity;
    private final VehicleType type;

    // Attack vehicles
    public Vehicle(String name, int cost, VehicleType type) {
        super(name, cost);

        if (type == VehicleType.TRANSPORT) {
            throw new IllegalArgumentException("Use the transport constructor for transport vehicles.");
        }

        this.type = type;
        this.transportCapacity = 0; // Default value for non-transport vehicles
    }

    // Transport vehicles
    public Vehicle(String name, int cost, int transportCapacity) {
        super(name, cost);

        if (transportCapacity <= 0) {
            throw new IllegalArgumentException("La capacité de transport doit être strictement positive.");
        }

        this.type = VehicleType.TRANSPORT;
        this.transportCapacity = transportCapacity;
    }

    public String getVehicleName() {
        return switch(type) {
            case TRANSPORT -> "de transport";
            case ATTACK -> "d'attaque";
        };
    }

    @Override
    public String toString() {
        String content = "Le véhicule " + getVehicleName() + " \"" + super.getName() + "\" : " + super.getCost() + " point" + (super.getCost() > 0 ? "s" : "");
        if (type == VehicleType.TRANSPORT) {
            content += ", capacité de transport : " + transportCapacity;
        }
        return content;
    }
}
