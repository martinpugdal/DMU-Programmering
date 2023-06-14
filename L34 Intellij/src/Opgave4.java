import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave4 {

    public static void main(String[] args) {
        System.out.println(linFileSearch("A:\\GitHub\\Programmering1\\L34 Intellij\\src\\" + "talfil.txt", 9140));
        System.out.println(linFileSearch("A:\\GitHub\\Programmering1\\L34 Intellij\\src\\" + "talfil.txt", 9141));
        System.out.println(linFileSearch("A:\\GitHub\\Programmering1\\L34 Intellij\\src\\" + "talfil.txt", 9142));
        System.out.println(linFileSearch("A:\\GitHub\\Programmering1\\L34 Intellij\\src\\" + "talfil.txt", 4450));
    }


    public static boolean linFileSearch(String fileName, int target) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if (scanner.nextInt() == target) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
