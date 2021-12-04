public class edge {

    int start;
    int end;

    public edge(int start,int end){
        this.start =start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start +"," + end + ']';
    }
}


