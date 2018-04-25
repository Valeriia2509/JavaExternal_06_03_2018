package Task1;

import java.io.Serializable;

public class Triangle implements Figure, Serializable{
    private Point A;
    private Point B;
    private Point C;
    transient private Line AB;
    transient private Line BC;
    transient private Line AC;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        A=new Point(x1,y1);
        B=new Point(x2,y2);
        C=new Point(x3,y3);
        AB=new Line(A,B);
        BC=new Line(B,C);
        AC=new Line(A,C);
    }

    public Triangle(Point a, Point b, Point c){
        A=a;
        B=b;
        C=c;
        AB=new Line(A,B);
        BC=new Line(B,C);
        AC=new Line(A,C);
    }

    public Triangle(Line ab, Point c){
        C=c;
        AB=ab;
        A=ab.getA();
        B=ab.getB();
        BC=new Line(B,C);
        AC=new Line(A,C);
    }

    public void setA(Point a) {
        A = a;
    }

    public void setA(int x, int y){
        A.setX(x);
        A.setY(y);
    }

    public void setAB(Line AB) {
        A=AB.getA();
        B=AB.getB();
    }

    @Override
    public String toString() {
        return "["+A.toString()+"; "+B.toString()+"; "+C.toString()+"]";
    }
}
