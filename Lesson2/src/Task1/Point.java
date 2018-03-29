package Task1;

public class Point extends Polygon{
    private int x;
    private int y;

    public Point(){
        dimension=0;
    }

    public Point(int x,int y){
        this.x=x;
        this.y=y;
        dimension=0;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+ x +", " + y +')';
    }
}
