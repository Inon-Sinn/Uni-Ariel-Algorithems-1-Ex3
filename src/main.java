import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int rows,cols;
        Scanner scan= new Scanner(System.in);
        System.out.println("Please enter number of Rows:");
        rows = scan.nextInt();
        System.out.println("Please enter number of Columns:");
        cols = scan.nextInt();
        Maze MyMaze = new Maze(rows,cols);
        MazeFrame frame = new MazeFrame(MyMaze);
    }
}
