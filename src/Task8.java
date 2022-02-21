import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) throws FileNotFoundException {
     solution(80);
    }
    public static void solution(double n) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("files/EGE.txt"));
        String[] headers = scanner.nextLine().split(";"); // array with headers

        while (scanner.hasNextLine()) {
            String[] element = scanner.nextLine().split(";");
            double percents = Double.parseDouble(element[2]); // take a 2 index of array
            if (percents >= n) System.out.println(element[0]);
        }
    }
}
