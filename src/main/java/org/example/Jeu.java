package org.example;

import java.util.IllegalFormatException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Jeu {

    Scanner scanner = new Scanner(System.in);
    String motADeviner = "";
    int tauxErreur;
    char[] reponse;

    String lettreDonnee;

    public void jouer() {
        System.out.println("Can you give me the word to guess ?");
        motADeviner = scanner.nextLine().toUpperCase();
        if (motADeviner.contains(" ") || motADeviner.contains("1") || motADeviner.contains("2")
                || motADeviner.contains("3") || motADeviner.contains("4") || motADeviner.contains("5")
                || motADeviner.contains("6") || motADeviner.contains("7") || motADeviner.contains("8")
                || motADeviner.contains("7") || motADeviner.contains("9") || motADeviner.contains("0")) {
            System.out.println("Can you give me the word to guess ? (in a format without numbers or spaces)");
            motADeviner = scanner.nextLine().toUpperCase();
        }
        try {
            motADeviner.toCharArray();
        } catch (IllegalFormatException illegalFormatException) {
            System.out.println("Can you give me the word to guess ? (in a correct format : " + illegalFormatException + ")");
            motADeviner = scanner.nextLine().toUpperCase();
        }

        System.out.println("Can I get the number of errors accepted ?");
        try {
            tauxErreur = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Can I get the number of errors accepted ? (in a correct format : " + numberFormatException + ")");
            tauxErreur = Integer.parseInt(scanner.nextLine());
        }

        asciiWall();

        System.out.println("\nGive me a letter to start ! The word contains " + motADeviner.length() + " letters.");

        reponse = new char[motADeviner.length()];
        for (int j = 0; j < motADeviner.length(); j++) {
            reponse[j] = '_';
            System.out.print(reponse[j]);
        }


        for (int i = 0; i < tauxErreur; ) {

            System.out.println("\n");
            lettreDonnee = scanner.nextLine().toUpperCase();

            if (String.valueOf(motADeviner).contains(lettreDonnee)) {

                for (int o = 0; o < motADeviner.length(); o++) {
                    if (motADeviner.toUpperCase().charAt(o) == lettreDonnee.toUpperCase().charAt(0)) {
                        reponse[o] = lettreDonnee.toUpperCase().charAt(0);
                    }
                }

                if (motADeviner.equals(String.valueOf(reponse))) {
                    System.out.println("GG! The word was : " + String.valueOf(motADeviner) + ".");
                } else {
                    System.out.println("\nYes, there is the letter : '" + lettreDonnee.toUpperCase() + "'.");
                }

            } else {
                System.out.println("\nNo, there is not letter : '" + lettreDonnee.toUpperCase() + "'.");
                i++;
                if (i >= tauxErreur) {
                    System.out.println("Nice try! The word was : '" + motADeviner.toUpperCase() + "'.");

                }
            }
            for (int j = 0; j < motADeviner.length(); j++) {

                System.out.print(reponse[j]);
            }

        }

    }

    public void demanderJouer() {
        System.out.println("*****************************");
        System.out.println("*                           *");
        System.out.println("*        Welcome to         *");
        System.out.println("*      the Hangman Game     *");
        System.out.println("*                           *");
        System.out.println("*****************************");
        System.out.println("Hello ! Do you want to play ? (y/n)\n");
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine();
        if (reponse.equals("y") || reponse.equals("yes")) {
            jouer();
        } else if (reponse.equals("n") || reponse.equals("no")) {
            System.out.println("No worries ! Have a good day !");
        } else {
            System.out.println("I need an answer like 'yes' or 'non'");
        }
    }

    public void asciiWall() {
        System.out.println("\n \n \n");
        System.out.println("********************************************************************************************************************************");
        System.out.println("         /$$                   /$$   /$$              /$$$$$$$                      /$$");
        System.out.println("        | $$                  | $$  | $/             | $$__  $$                    |__/");
        System.out.println("        | $$        /$$$$$$  /$$$$$$|_//$$$$$$$      | $$  \\ $$  /$$$$$$   /$$$$$$  /$$ /$$$$$$$ ");
        System.out.println("        | $$       /$$__  $$|_  $$_/  /$$_____/      | $$$$$$$  /$$__  $$ /$$__  $$| $$| $$__  $$");
        System.out.println("        | $$      | $$$$$$$$  | $$   |  $$$$$$       | $$__  $$| $$$$$$$$| $$  \\ $$| $$| $$  \\ $$");
        System.out.println("        | $$      | $$_____/  | $$ /$$\\____  $$      | $$  \\ $$| $$_____/| $$  | $$| $$| $$  | $$");
        System.out.println("        | $$$$$$$$|  $$$$$$$  |  $$$$//$$$$$$$/      | $$$$$$$/|  $$$$$$$|  $$$$$$$| $$| $$  | $$");
        System.out.println("        |________/ \\_______/   \\___/ |_______/       |_______/  \\_______/ \\____  $$|__/|__/  |__/");
        System.out.println("                                                                          /$$  \\ $$");
        System.out.println("                                                                          |  $$$$$$/              ");
        System.out.println("                                                                           \\______/");
        System.out.println("********************************************************************************************************************************");
    }
}