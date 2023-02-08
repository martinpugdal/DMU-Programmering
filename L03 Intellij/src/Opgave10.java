import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Class Opgave10: En implementation af spillet "Scissor, Rock, Paper".
 * Spilleren vælger et af de tre elementer (scissor, rock, paper) og computeren vælger
 * et af elementerne tilfældigt. Vinderen af spillet afgøres ud fra følgende regler:
 * scissor vinder over paper, rock vinder over scissor, og paper vinder over rock.
 * Resultatet af spillet vises som en besked på skærmen.
 */
public class Opgave10 {
    /**
     * Enum Item: Repræsenterer de tre elementer i spillet: scissor, rock, paper.
     */
    public enum Item {
        /**
         * Scissor: Repræsenteret ved tallet 0.
         */
        SCISSOR("scissor", 0),
        /**
         * Rock: Repræsenteret ved tallet 1.
         */
        ROCK("rock", 1),
        /**
         * Paper: Repræsenteret ved tallet 2.
         */
        PAPER("paper", 2);

        /**
         * Navnet på elementet (scissor, rock, paper).
         */
        private final String name;
        /**
         * Værdien af elementet (0, 1, 2).
         */
        private final int value;

        /**
         * Constructor for enum Item. Initialiserer navn og værdi for et element.
         *
         * @param name Navnet på elementet.
         * @param value Værdien af elementet.
         */
        Item(String name, int value) {
            this.name = name;
            this.value = value;
        }

        /**
         * Map convertStringToEnum: Mapper mellem en string og et enum-element.
         * Bruges til at konvertere en string til et enum-element.
         */
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

        /**
         * Metoden fromString: Konverterer en string til et enum-element.
         *
         * @param name Navnet på elementet som en string.
         * @return Enum-elementet som svarer til navnet.
         */
        public static Item fromString(String name) {
            return convertStringToEnum.get(name);
        }

        private static final int[][] result = new int[][] {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0}
        };

        /**
         * Returnerer resultatet af en kamp mellem to items
         *
         * @param item1 Første item, der skal sammenlignes
         * @param item2 Andet item, der skal sammenlignes
         * @return Resultatet af sammenligningen (-1 for lost, 0 for draw, 1 for won)
         */
        public static int getResult(Item item1, Item item2) {
            return result[item1.value][item2.value];
        }    }

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

    /**
     * Returnerer en meddelelse, der angiver resultatet af spillet baseret på sammenligningen mellem spillerens og bottens bevægelser.
     *
     * @param playerItem Spillerens item.
     * @param botItem Computerens item.
     * @return En meddelelse, der angiver resultatet af spillet.
     */
    private static String getResultMessage(Item playerItem, Item botItem) {
        return "The computer is " + botItem.name + ". " +
            "You are " + playerItem.name +
            ". You " + resultMessages.get(Item.getResult(playerItem, botItem));
    }
}
