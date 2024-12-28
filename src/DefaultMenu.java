import java.util.ArrayList;
import java.util.Arrays;

public class DefaultMenu {

    public Menu menu = new Menu(
            "Menu principal",
            new ArrayList<String>(Arrays.asList(
                    "Créer une nouvelle armée",
                    "Modifier une armée existante",
                    "Modifier une faction",
                    "Quitter"
            )),
            "> ",
            true,
            false
    );

    public DefaultMenu() {

        CreateArmyMenu createArmyMenu   = new CreateArmyMenu();
        // EditArmyMenu editArmyMenu       = new CreateArmyMenu();
        // EditGroupMenu editGroupMenu     = new CreateArmyMenu();

        // Menu 1 de création d'armée


        menu.treatChoiceInt = choice -> {

            switch (choice) {
                case 1 : {
                    createArmyMenu.open();
                    break;
                }
                case 2 : {
                    System.out.println("Modification armée");
                    break;
                }
                case 3 : {
                    System.out.println("Modification faction");
                    break;
                }
                case 4 : {
                    System.out.println("Fin de l'exécution... Merci d'avoir joué avec nous !");
                    break;
                }
                default : {
                    throw new IllegalArgumentException("The choice must be between 1 and " + menu.getOptions().size());
                }
            }

        };
    }

    public void open() {
        menu.display();
    }

}