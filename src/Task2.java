import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getCountWords());
    }

        public static int getCountWords() throws FileNotFoundException {
            Scanner scanner = new Scanner(new FileInputStream("files/text.txt"));
            int countWords = 0;

            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(" ");
                countWords += words.length;
            }

            return countWords;
        }
    }


