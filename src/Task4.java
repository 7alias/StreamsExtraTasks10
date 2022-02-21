import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws IOException {
        writeOrder();
    }
    public static void writeOrder() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("files/numbers.txt"));
        int index = 1;
        String resString = "";

        while (scanner.hasNextLine()) {
            String nowNumber = scanner.nextLine();
            if (Integer.parseInt(nowNumber) == index) {
                resString += nowNumber + " ";
            }
            index++;
        }

        if (resString.equals("")) {
            resString = "0";
        }

        // write string in file
        FileWriter writer = new FileWriter("files/output.txt", false);
        writer.write(resString.trim());
        writer.flush();
    }
}
