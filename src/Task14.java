import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task14 {



    public static int findMaxQuantity() throws FileNotFoundException {
        int[][] forest = new int[10][10];
        Scanner scanner = new Scanner(new FileInputStream("files/forest.txt"));
        int k = 0;

        // build array
        while (scanner.hasNextLine()) {
            String[] string = scanner.nextLine().split(";");
            for (int i = 0; i < 10; i++) {
                forest[k][i] = Integer.parseInt(string[i]);
            }
            k++;
        }

        // find maximum
        for (int i = 1; i < 10; i++) {
            forest[i][0] += forest[i - 1][0];
            forest[0][i] += forest[0][i - 1];
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                forest[i][j] += Math.max(forest[i - 1][j], forest[i][j - 1]);


                System.out.print(" "+i);

                System.out.print(" "+j);

                System.out.print(" " + forest[j][0]);

                System.out.print(" "+ forest[0][j]);
                System.out.println();

            }
        }

        return forest[9][9];
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new Task14().findMaxQuantity());
    }
}
