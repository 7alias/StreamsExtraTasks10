import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) throws FileNotFoundException {
solution();

    }
    public static void solution() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("files/trees.txt"));
        String[] trees = scanner.nextLine().split(" ");

        // check that we have more than 1 tree
        if (trees.length != 1) {
            int x = 0, y = 0;
            int x1 = 0, y1 = 0;

            int tree = findTree(trees, 1, trees.length);
            int tree2 = findTree(trees, 0, trees.length - 1);

            System.out.println(Math.max(tree, tree2));
        } else {
            System.out.println(trees[trees.length - 1]); // else sout this tree
        }
    }

    private static int findTree(String[] trees, int start, int end) {
        int x = 0, y = 0;
        int tree = 0;

        for (int i = start; i < end; i++) {
            int temp = x;
            x = y + Integer.parseInt(trees[i]);
            y = Math.max(temp, y);
            tree = Math.max(x, y);
        }
        return tree;
    }
}
