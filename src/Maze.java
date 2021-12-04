import java.util.ArrayList;
import java.util.Collections;

public class Maze {

    int rows;
    int cols;
    UnionFind maze;
    ArrayList<edge> all_edges = new ArrayList<edge>();
    ArrayList<edge> shuffled_edges = new ArrayList<edge>();


    public Maze(int rows,int cols){
        this.maze = new UnionFind(rows*cols);
        this.rows = rows;
        this.cols = cols;
        create_all_Edges();
        Collections.shuffle(this.shuffled_edges);
        create_Complete_Maze();
    }

    /**
     * Creates all possible edges in the maze
     */
    public void create_all_Edges(){
        //permanent edges

        //upper row and lower row
        all_edges.add(new edge(0,cols,true));
        all_edges.add(new edge((cols+1)*rows,(cols+1)*(rows+1) -1,true));
        //left and right column
        if (rows!=1) {
            all_edges.add(new edge(cols + 1, (cols + 1) * rows,false));
            all_edges.add(new edge(cols,(cols+1)*(rows) -1,false));
        }

        // inner edges - columns
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                edge next = new edge(i*(cols +1) + j,(i+1)*(cols+1) + j,false);
                all_edges.add(next);
                shuffled_edges.add(next);
            }
        }

        // inner edges - rows
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                edge next = new edge(j*(cols+1)+i,j*(cols+1)+i+1,true);
                all_edges.add(next);
                shuffled_edges.add(next);
            }
        }
    }

    /**
     * removes one random edge from the maze to complete it
     */
    public void removed_next_edge(){
        boolean rm_a_edge = false;
        while (!shuffled_edges.isEmpty()||!rm_a_edge){
            edge curr = shuffled_edges.get(0);
            if(curr.horizontal){
                int from = UnionNum(curr.start,true);
                if(maze.disJointSets(from,from+cols)){
                    maze.union(from,from+cols);
                    rm_a_edge = true;
                    all_edges.remove(curr);
                }
                shuffled_edges.remove(curr);
            }
            else{
                int from = UnionNum(curr.start,false);
                if(maze.disJointSets(from,from+1)){
                    maze.union(from,from+1);
                    rm_a_edge = true;
                    all_edges.remove(curr);
                }
                shuffled_edges.remove(curr);
            }
        }
    }

    /**
     * given the starting point of the edge from the maze, it calculates its id in the Union find
     * @param s int - the id of point in the maze
     * @param horizontal boolean - True if its an horizontal edge, false else
     * @return int - the id of its node in the Union find
     */
    public int UnionNum(int s, boolean horizontal){
        int ans = 0;
        int current_row = s/(cols+1);
        if(!horizontal)
            ans = s -1 - current_row;
        else
            ans = s - cols - current_row;
        return ans;
    }

    public void create_Complete_Maze(){
        while(!shuffled_edges.isEmpty())
            removed_next_edge();
    }


}
