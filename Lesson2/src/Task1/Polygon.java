package Task1;

import java.io.Serializable;

public class Polygon implements Figure, Serializable {
    private Point[] points;

    public Polygon(Point[] p){
        points=new Point[p.length];
        this.points=p;
    }

    public int[] getPolyX(){
        int [] arr=new int[points.length];
        for (int i=0;i<points.length; i++){
            arr[i]=points[i].getX();
        }
        return arr;
    }

    public int[] getPolyY(){
        int [] arr=new int[points.length];
        for (int i=0;i<points.length; i++){
            arr[i]=points[i].getY();
        }
        return arr;
    }

    public int getPolyN(){
        return points.length;
    }

    @Override
    public String toString() {
        String result="[";
        for (int i=0; i<points.length; i++){
            result+=points[i].toString();
            result+="; ";
        }
        result=result.substring(0,result.length()-2);
        result+="]";
        return result;
    }
}
