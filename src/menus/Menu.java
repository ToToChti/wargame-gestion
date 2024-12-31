package menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private String title;
    private ArrayList<String> options;
    private String askSentence;
    private HashMap<String, Menu> menusList;



    public Menu(String title, ArrayList<String> options, String askSentence) {

        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        if(askSentence == null || askSentence.isEmpty()) {
            throw new IllegalArgumentException("Ask sentence cannot be null or empty");
        }



        this.title = title;
        this.options = options;
        this.askSentence = askSentence;
    }


    public void display() {

        if(this.title == null || this.title.isEmpty()) {
            throw new IllegalArgumentException("No title to display for the menu.");
        }

        if(this.askSentence == null || this.askSentence.isEmpty()) {
            throw new IllegalArgumentException("No sentence for choice to display for the menu.");
        }

        // Displaying title
        System.out.printf("\n\n-----> %s <------\n\n", this.title);

        // Displaying options
        if(this.options != null && !this.options.isEmpty()) {
            for (int i = 0; i < this.options.size(); ++i) {
                System.out.printf("%d. %s\n", i + 1, this.options.get(i));
            }
        }

        // Displaying choice sentence
        System.out.printf("\n%s ", this.askSentence);
    }

    public void openMenu() {};

    public void openMenu(String param1) {};

    public void openMenu(String param1, String param2) {};


    public int waitForChoiceInt() {

        int choice = 0;
        boolean correct = false;

        while(!correct) {

            // Ask for user input
            Scanner input = new Scanner(System.in);

            if(!input.hasNextInt()) {
                System.out.printf("Choix non valide, veuillez réessayer (choix entre %d et %d).\n", 1, options.size());
                System.out.printf("%s ", askSentence);

                continue;
            }

            choice = input.nextInt();

            if(choice < 1 || choice > options.size()) {
                System.out.printf("Choix non valide, veuillez réessayer (choix entre %d et %d).\n", 1, options.size());
                System.out.printf("%s ", askSentence);

                continue;
            }

            correct = true;
        }

        return choice;
    }


    public String waitForChoiceString() {

        String choice = null;
        boolean correct = false;

        while(!correct) {

            // Ask for user input
            Scanner input = new Scanner(System.in);

            if(!input.hasNextLine()) {
                System.out.print("Choix non valide, veuillez réessayer");
                System.out.printf("%s ", askSentence);

                continue;
            }

            choice = input.nextLine();
            correct = true;
        }

        return choice;
    }
}
