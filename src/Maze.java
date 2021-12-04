import java.util.ArrayList;
import java.util.Collections;

public class Maze {

    int rows;
    int cols;
    UnionFind maze;//maybe turn to one?
    ArrayList<edge> all_edges = new ArrayList<edge>();
    ArrayList<edge> shuffled_edges = new ArrayList<edge>();
    // union find

    public Maze(int rows,int cols){
        this.maze = new UnionFind(rows*cols);
        this.rows = rows;
        this.cols = cols;
        create_all_Edges();
        Collections.shuffle(this.shuffled_edges);
    }

    public void create_all_Edges(){
        //permenant edges

        //upper row and lower row
        all_edges.add(new edge(0,cols));
        all_edges.add(new edge((cols+1)*rows,(cols+1)*(rows+1) -1));
        //left and right column
        if (rows!=1) {
            all_edges.add(new edge(cols + 1, (cols + 1) * rows));
            all_edges.add(new edge(cols,(cols+1)*(rows) -1));
        }

    }

    public void removed_next_edge(){
        while (!shuffled_edges.isEmpty()){
            //remove if only if they are disjoint arcoding to
        }
    }


}
