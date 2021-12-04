public class edge {

    public int start;
    public int end;
    boolean horizontal;

    public edge(int start,int end, boolean horizontal){
        this.start =start;
        this.end = end;
        this.horizontal = horizontal;
    }

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }

    @Override
    public String toString() {
        return "[" + start +"," + end + ']';
    }
}


