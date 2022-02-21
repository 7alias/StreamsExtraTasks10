import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task16 {

    public static void main(String[] args) throws IOException {
        getOutput();
    }
    public static void getOutput() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("files/files.txt"));

        // creating arrays for all types of files
        String[] tempZip = new String[100];
        String[] tempBmp = new String[100];
        String[] tempTxt = new String[100];

        // creating counters for all types of files
        int zipB = 0;
        int bmpB = 0;
        int txtB = 0;

        // creating counters for all types of files
        int zipCount = 0;
        int bmpCount = 0;
        int txtCount = 0;

        while (scanner.hasNextLine()) {
            String[] fileInfo = scanner.nextLine().split(" ");

            // get all info about file
            String name = fileInfo[0];
            int size = Integer.parseInt(fileInfo[1]);
            String unit = fileInfo[2];
            String type = name.split("\\.")[1];

            // converting to bytes
            if (unit.equals("KB")) size *= 1024;
            else if (unit.equals("MB")) size *= 1024 * 1024;

            // add file in array
            if (type.equals("zip")) {
                tempZip[zipCount] = name;
                zipB += size;
                zipCount++;
            } else if (type.equals("bmp")) {
                tempBmp[bmpCount] = name;
                bmpB += size;
                bmpCount++;
            } else {
                tempTxt[txtCount] = name;
                txtB += size;
                txtCount++;
            }
        }

        String[] zip = new String[zipCount];
        String[] bmp = new String[bmpCount];
        String[] txt = new String[txtCount];

        if (zipCount >= 0) System.arraycopy(tempZip, 0, zip, 0, zipCount);
        if (bmpCount >= 0) System.arraycopy(tempBmp, 0, bmp, 0, bmpCount);
        if (txtCount >= 0) System.arraycopy(tempTxt, 0, txt, 0, txtCount);

        // sorting arrays
        Arrays.sort(zip);
        Arrays.sort(bmp);
        Arrays.sort(txt);

        // convert to max units
        String[] zipArr = convertToMaxUnits(zipB);
        String[] bmpArr = convertToMaxUnits(bmpB);
        String[] txtArr = convertToMaxUnits(txtB);

        // begin writing in file
        String resultString = "";
        resultString += buildResultString(bmp, bmpArr);
        resultString += buildResultString(txt, txtArr);
        resultString += buildResultString(zip, zipArr);

        FileWriter writer = new FileWriter(new File("files/output.txt"), false);
        writer.write(resultString.trim());
        writer.flush();
    }

    private static String[] convertToMaxUnits(int bytes) {
        // array with {B, KB, MB}
        double[] bytesToUnits = {(double) bytes, (double) bytes / 1024, (double) bytes / (1024 * 1024)};

        String nowType = "B";
        if (bytesToUnits[2] >= 0.5) {
            nowType = "MB";
        } else if (bytesToUnits[1] >= 0.5) {
            nowType = "KB";
        }

        if (nowType.equals("B")) return new String[]{bytesToUnits[0] + "", nowType};
        else if (nowType.equals("KB")) return new String[]{Math.round(bytesToUnits[1]) + "", nowType};
        else return new String[]{Math.round(bytesToUnits[2]) + "", nowType};
    }

    private static String buildResultString(String[] arr, String[] units) {
        String resultString = "";
        if (arr.length > 0) {
            for (String fileName : arr) {
                resultString += fileName + "\n";
            }
            resultString += "----------\nSummary: " + units[0] + " " + units[1] + "\n\n";
        }
        return resultString;
    }
}
