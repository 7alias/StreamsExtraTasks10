import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) throws IOException {
        findMerchant("Cherevik");
    }
    public static void findMerchant(String name) throws IOException {
        // read file and put it in array
        Scanner scanner = new Scanner(new FileInputStream("files/outcome.txt"));
        scanner.nextLine();
        int s = 0;
        String result = "";

        while (scanner.hasNextLine()) {
            String[] element = scanner.nextLine().split(";");
            if (element[1].equals(name)) {
                System.out.println(element[2] + "," +  element[3] + "," + element[4] + "," + (Integer.parseInt(element[3]) * Integer.parseInt(element[4])));
                s += Integer.parseInt(element[3]) * Integer.parseInt(element[4]);
            }
        }
        System.out.println("tax: " + s * 0.15);
    }
}
