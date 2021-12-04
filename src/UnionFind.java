public class UnionFind {

    int[] parent;
    int[] size;

    public UnionFind(int numberOfSets){
        this.parent = new int[numberOfSets];
        this.size = new int[numberOfSets];
        for (int i = 0; i < numberOfSets; i++) {
            this.makeSet(i);
        }
    }

    public void makeSet(int v){
        parent[v] = v;
        size[v] = 1;
    }

    public int find(int v){
        if(parent[v] != v)
            parent[v] = find(parent[v]);
        return parent[v];
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if ((size[a] <=size[b])){
                parent[a]=b;
                size[b] = size[b] + size[a];
            }
            else {
                parent[b] = a;
                size[a] = size[a]+size[b];
            }
        }
    }

    /**
     * Calculates if the two nodes are in the same set
     * @param a int - id of the first set
     * @param b int - id of the second set
     * @return boolean - True if they are from different sets else false
     */
    public boolean disJointSets(int a, int b){
        return find(a)!=find(b);
    }


}
