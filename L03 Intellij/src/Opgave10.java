import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Opgave10 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("scissor (0), rock (1), paper (2): ");
        /*debugging faster*/
//        for (int i = 0; i < 10; i++) {
//            int playerItem = new Random().nextInt(0, 3);
//            int botItem = new Random().nextInt(0, 3);
//            StringBuilder resultMessage = new StringBuilder();
//            resultMessage.append("The computer is ").append(getItem(botItem)).append(". ");
//            resultMessage.append("You are ").append(getItem(playerItem));
//            resultMessage.append(((playerWon(getItem(playerItem),getItem(botItem))).equals("draw")) ? " too. It is a "+playerWon(getItem(playerItem),getItem(botItem)) : ". You "+playerWon(getItem(playerItem),getItem(botItem)));
//            System.out.println(resultMessage);
//        }
        int playerItem = sc.nextInt();
        int botItem = new Random().nextInt(0, 3);
        StringBuilder resultMessage = new StringBuilder();
        resultMessage.append("The computer is ").append(getItem(botItem)).append(". ");
        resultMessage.append("You are ").append(getItem(playerItem));
        resultMessage.append(((playerWon(getItem(playerItem),getItem(botItem))).equals("draw")) ? " too. It is a "+playerWon(getItem(playerItem),getItem(botItem)) : ". You "+playerWon(getItem(playerItem),getItem(botItem)));
        System.out.println(resultMessage);
    }

    private static String getItem(int item) {
        ArrayList<String> items = new ArrayList<>(Arrays.asList("scissor", "rock", "paper"));
        return items.get((item));
    }

    private static String playerWon(String playerItem, String botItem) {
        if (playerItem.equals("scissor") && botItem.equals("rock")) {
            return "lost";
        } else if (playerItem.equals("scissor") && botItem.equals("paper")) {
            return "won";
        } else if (playerItem.equals("rock") && botItem.equals("scissor")) {
            return "won";
        } else if (playerItem.equals("rock") && botItem.equals("paper")) {
            return "lost";
        } else if (playerItem.equals("paper") && botItem.equals("scissor")) {
            return "lost";
        } else if (playerItem.equals("paper") && botItem.equals("rock")) {
            return "won";
        }
        return "draw";
    }
}
