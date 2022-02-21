import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(translate());
    }



    public static String translate() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("files/message.txt"));
        String[] binLetters = "1000001;1000010;1000011;1000100;1000101;1000110;1000111;1001000;1001001;1001010;1001011;1001100;1001101;1001110;1001111;1010000;1010001;1010010;1010011;1010100;1010101;1010110;1010111;1011000;1011001;1011010".split(";");
        String[] englishLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        String message = "";

        while (scanner.hasNextLine()) {
            String messageString = scanner.nextLine();
            String[] array = messageString.split("");
            for (String symbol : array) {
                int index = findSymbol(symbol, englishLetters);
                message += index != -1 ? binLetters[index] : symbol;
            }
            message += "\n";
        }
        return message.trim();
    }

    private static int findSymbol(String symbol, String[] engLetters) {
        for (int i = 0; i < engLetters.length; i++) {
            if (engLetters[i].equals(symbol)) return i;
        }
        return -1;
    }
}
