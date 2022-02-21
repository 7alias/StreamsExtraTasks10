import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(findSquare());
    }
    public static double findSquare() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("files/points.txt"));
        String[] prevPoint = scanner.nextLine().split(" "); // previous point
        double square = 0;

        while (scanner.hasNextLine()) {
            String[] nowPoint = scanner.nextLine().split(" ");
            // get all points
            int prevX = Integer.parseInt(prevPoint[0]);
            int prevY = Integer.parseInt(prevPoint[1]);

            int nowX = Integer.parseInt(nowPoint[0]);
            int nowY = Integer.parseInt(nowPoint[1]);

            double a = prevY;
            double b = nowY;
            double h = nowX - prevX;

            square += (a + b) / 2 * h; // sum squares

            prevPoint = nowPoint;
        }

        return square;
    }
}
