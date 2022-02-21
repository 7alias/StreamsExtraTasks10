import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(arePalindromes());
    }
    public static boolean arePalindromes() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("files/strings.txt"));

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine(); // read new string
            string = string.toLowerCase().replace(" ", "");
            if (!string.equals(new StringBuilder(string.toLowerCase()).reverse().toString())) return false;
        }

        return true;
    }
}
