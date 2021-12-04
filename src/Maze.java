import java.util.ArrayList;

public class Maze {

    int rows;
    int cols;
    UnionFind maze;//maybe turn to one?
    ArrayList all_eges;
    ArrayList shuffled_edges;
    // union find

    public Maze(int n,int m){
        this.maze = new UnionFind(n*m);
        this.rows = n;
        this.cols = m;
        // Create all edges

        // shuffle the removable edges
    }

    public void create_all_Edges(){
        //permenant edges

        //removable edges
    }

    public void removed_next_edge(){
        while (!shuffled_edges.isEmpty()){
            //remove if only if they are disjoint arcoding to
        }
    }


}
