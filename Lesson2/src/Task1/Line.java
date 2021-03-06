package Task1;

import java.io.Serializable;

public class Line implements Figure, Serializable{
    private Point A;
    private Point B;

    public Line(int x1, int y1, int x2, int y2){
        A=new Point(x1,y1);
        B=new Point(x2,y2);
    }

    public Line(Point a, Point b){
        this.A=a;
        this.B=b;
    }

    public Line(Point a, int x, int y){
        A=a;
        B=new Point(x,y);
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public void setA(Point a) {
        A = a;
    }

    public void setB(Point b) {
        B = b;
    }

    public void setA(int x, int y) {
        A.setX(x);
        A.setY(y);
    }

    public void setB(int x, int y) {
        B.setX(x);
        B.setY(y);
    }

    @Override
    public String toString() {
        return "["+A.toString()+"; "+B.toString()+"]";
    }
}
