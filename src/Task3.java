import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3 {


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getMul());
    }
        public static int getMul() throws FileNotFoundException {
            Scanner scanner = new Scanner(new FileInputStream("files/data.txt"));

            int limit = Integer.parseInt(scanner.nextLine());
            String[] strings = scanner.nextLine().split(" ");
            int[] delimiters = new int[strings.length];

            for (int i = 0; i < strings.length; i++) {
                delimiters[i] = Integer.parseInt(strings[i]);
            }

            int mul = 1;

            for (int i = 1; i <= limit; i++) {
                for (int delimiter : delimiters) {
                    if (i % delimiter == 0) {
                        mul *= i;
                        break;
                    }
                }
            }

            return mul;
        }
    }

