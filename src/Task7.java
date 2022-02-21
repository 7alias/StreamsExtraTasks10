import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) throws IOException {
        dance();
    }
    public static void dance() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("files/dance.txt"));
        StringBuilder result = new StringBuilder();
        int rhythm = Integer.parseInt(scanner.nextLine()); // read rhythm
        while (scanner.hasNextLine()) {
            int step = Integer.parseInt(scanner.nextLine());
            result.append(step / rhythm).append(" ").append(step % rhythm).append("\n"); // add in result string
        }

        // write result in file
        FileWriter writer = new FileWriter(new File("files/rhythm.txt"), false);
        writer.write(result.toString().trim()); // trim result because \n in the end
        writer.flush();
    }
}
