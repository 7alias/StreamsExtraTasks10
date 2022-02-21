import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) throws IOException {
        solution("Federal District",2019, 2020);

    }
    public static void solution(String district, int fromYear, int toYear) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("files/crop_volumes.txt"));
        String[] headers = scanner.nextLine().split(";"); // array with headers
        String result = "Part;" + fromYear + ";" + toYear;


        while (scanner.hasNextLine()) {
            String[] element = scanner.nextLine().split(";"); // take array of elements
            if (element[1].equals(district)) {
                // take indexes
                int index1 = Arrays.asList(headers).indexOf(String.valueOf(fromYear));
                int index2 = Arrays.asList(headers).indexOf(String.valueOf(toYear));
                // get a values
                double fromYearResult = Double.parseDouble(element[index1]);
                double toYearResult = Double.parseDouble(element[index2]);

                // check that it's true
                if (fromYearResult * 1.04 < toYearResult) {
                    // add in result
                    result += "\n" + element[0] + ";" + fromYearResult + ";" + toYearResult;
                }
            }
        }

        // write in file our result
        FileWriter writer = new FileWriter(new File("files/out.txt"), false);
        writer.write(result);
        writer.flush();
    }

}
