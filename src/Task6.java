import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) throws IOException {
        System.out.println();
        solution();
    }

    public static void solution() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("files/data6.txt"));
        int length = 0, k = 0;
        StringBuilder allStrings = new StringBuilder();

        int limit = Integer.parseInt(scanner.nextLine());
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine(); // read new string
            allStrings.append(string).append("\n");        // build a big string with all strings
            length += string.length();          // search a median
            k++;
        }

        StringBuilder result = new StringBuilder(length / k + "\n");      // take median
        String[] strings = allStrings.toString().trim().split("\n");   // build array with all strings
        for (String string : strings) {
            if (Math.abs(string.length() - length / k) <= limit) result.append(string).append("\n"); // selecting strings
        }

        // write result in file
        FileWriter writer = new FileWriter("files/output.txt", false);
        writer.write(result.toString().trim());
        writer.flush();
    }
}
