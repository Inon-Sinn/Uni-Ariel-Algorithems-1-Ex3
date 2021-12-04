public class edge {

    int start;
    int end;
    boolean horizontal;

    public edge(int start,int end, boolean horizontal){
        this.start =start;
        this.end = end;
        this.horizontal = horizontal;
    }

    @Override
    public String toString() {
        return "[" + start +"," + end + ']';
    }
}


