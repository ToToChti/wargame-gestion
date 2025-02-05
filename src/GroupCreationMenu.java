import java.util.*;

public class GroupCreationMenu extends CreationMenu {
    private String groupName;
    private final ArrayList<WargameInput> inputs;

    public GroupCreationMenu(Scanner scanner, ArrayList<UnitGroup> groups) {
        super(scanner, "Menu création armée");

        final ArrayList<WargameInput> constructInputs = new ArrayList<>();

        constructInputs.add(new WargameInput("Choisissez un nom pour votre groupe d'unité", input -> {
            boolean alreadyExists = groups.stream().anyMatch(group -> group.getName().equalsIgnoreCase(input));
            if (alreadyExists) {
                System.out.println("Un groupe d'unité portant ce nom existe déjà");
                return false;
            }

            this.groupName = input;
            return true;
        }));

        inputs = constructInputs;
    }

    public boolean createGroup() {
        return create(inputs);
    }

    public UnitGroup getGroup() {
        return new UnitGroup(groupName);
    }
}
