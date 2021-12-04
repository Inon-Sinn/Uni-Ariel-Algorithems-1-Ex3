import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;



public class MazeFrame extends JFrame {

    double[][] points;
    Maze maze;

    public MazeFrame(Maze m){
        this.maze = m;
        createPoints();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setTitle("Algorithm Ex3");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void createPoints(){
        this.points = new double[(maze.cols+1)*(maze.rows+1)][2];
        int max = maze.cols;
        if(maze.cols<maze.rows)
            max = maze.rows;
        double weidth = (double)(500/(max));
        double heigth =  (double)(500/(max));
        int counter = 0;
        for (int i = 0; i <= maze.rows; i++) {
            for (int j = 0; j <= maze.cols; j++) {
                points[counter][1] = 100 + i*heigth;
                points[counter][0] = 100 + j*weidth;
                counter++;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        for (int i = 0; i < maze.all_edges.size(); i++) {
            edge cur = maze.all_edges.get(i);
            double x1 = points[cur.start][0];
            double y1 = points[cur.start][1];
            double x2 = points[cur.end][0];
            double y2 = points[cur.end][1];
            Line2D line =new Line2D.Double(x1,y1,x2,y2);
            g2D.draw(line);
        }

    }



}
