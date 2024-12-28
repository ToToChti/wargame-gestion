import java.util.ArrayList;
import java.util.Arrays;

public class CreateArmyMenu {

    private String armyName;
    private String armyFaction;
    private int armyMaxPoints;

    public Menu menu1 = new Menu(
            "Menu création d'armée",
            null,
            "Choisissez un nom pour votre armée (q pour annuler) (1/3) :",
            false,
            false
    );

    public Menu menu2 = new Menu(
            "Menu création d'armée",
            null,
            "Choisissez la faction ou donnez le nom de votre nouvelle faction si elle n'existe pas encore (q pour annuler) (2/3) :",
            false,
            false
    );

    public Menu menu3 = new Menu(
            "Menu création d'armée",
            null,
            "Nombre de points maximal de l'armée (q pour annuler) (3/3) :",
            true,
            false
    );

    public Menu menu4 = new Menu(
            "Menu création d'armée",
            null,
            "Armée créé avec succès ! Appuyez sur entrée pour continuer :",
            false,
            true
    );


    public CreateArmyMenu() {

        menu1.treatChoiceString = choice -> {
            armyName = choice;

            menu2.display();
        };

        menu2.treatChoiceString = choice -> {
            armyFaction = choice;

            menu3.display();
        };

        menu3.treatChoiceInt = choice -> {

            if(choice < 1) {
                System.out.println("\nLe nombre de points doit être supérieur à 0");

                menu3.waitForAnswer();
            }

            armyMaxPoints = choice;

            menu4.display();
        };

        menu4.treatChoiceString = choice -> {

            Army newArmy = new Army(armyName, armyFaction, armyMaxPoints);

            // TODO: ajouter l'armée à la liste des armées
            // TODO: Afficher le recap de la nouvelle armée ?

            open();
        };


    }

    public void open() {
        menu1.display();
    }

}
