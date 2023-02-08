import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Opgave10 {

    public enum Item {
        SCISSOR("scissor", 0),
        ROCK("rock", 1),
        PAPER("paper", 2);

        private final String name;
        private final int value;

        Item(String name, int value) {
            this.name = name;
            this.value = value;
        }

        private static final Map<String, Item> convertStringToEnum = Map.of(
            "scissor", SCISSOR,
            "rock", ROCK,
            "paper", PAPER,
            "0", SCISSOR,
            "1", ROCK,
            "2", PAPER,
            "s", SCISSOR,
            "r", ROCK,
            "p", PAPER
        );

        public static Item fromString(String name) {
            return convertStringToEnum.get(name);
        }

        private static final int[][] result = new int[][] {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0}
        };

        public static int getResult(Item item1, Item item2) {
            return result[item1.value][item2.value];
        }
    }

    private static final Map<Integer, String> resultMessages = Map.of(
        -1, "lost",
        0, "draw",
        1, "won"
    );

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("scissor (0), rock (1) or paper (2): ");
        String playerItem_ = sc.next();
        Item playerItem = Item.fromString(playerItem_);
        Item botItem = Item.values()[new Random().nextInt(3)];
        System.out.println(getResultMessage(playerItem, botItem));
    }

    private static String getResultMessage(Item playerItem, Item botItem) {
        int outcome = Item.getResult(playerItem, botItem);
        return "The computer is " + botItem.name + ". " +
            "You are " + playerItem.name +
            ". You " + resultMessages.get(outcome);
    }
}
