package gui;

import java.util.Scanner;

public class MenuApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
          I denne applikation, skal der laves kommunikation med brugeren, så man fra brugeren kan få
          oplysninger om de teams og de studerende, der skal oprettes (hvorefter programmet opretter
          objekterne). Programmet skal kunne oprette flere teams med et antal studerende.
          Efter oprettelsen af et team skal programmet udskrive oplysninger om teamet og dets studerende
          (f.eks. hver studerendes gennemsnitskarakter).
         */
        System.out.println("MENU\n" +
                "1: Create a team\n" +
                "2: Create a student\n" +
                "3: Show one student's info and results\n" +
                "4: Show one team's info and results\n" +
                "5: Show info and results for all teams\n" +
                "6: Exit program");
        int triggerIndex = scanner.nextInt();



    }
}
