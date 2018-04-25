/*
создать динамический массив из разных фигур и вывести информацию на экран
создать класс Polygon для описания фигур разной размерности
сериализовать фигуры  3 точки 3 линии и 1 треугольник
сделать 3 файла с сериализованим polygon который будет описывать 3 разные фигуры
и десериализовать отобразить на екран
 */
package Task1;

import javax.swing.*;
import java.io.*;

public class PolygonMain {
    public static void main(String[]args){

        tryFiguresAndPoligons();//1
        System.out.println();

        serializeAndDeserializeFigures();//2

        serializeAndDeserializePolygons();
    }

    private static void serializeAndDeserializePolygons() {
        Point [] points1={new Point(200,50), new Point(250, 100),
                new Point(225,100), new Point(300,200), new Point(250,200),
                new Point(350,350), new Point(50,350), new Point(150,200),
                new Point(100,200), new Point(175,100),new Point(150,100)};
        Polygon poly1=new Polygon(points1);

        Point [] points2={new Point(200,250), new Point(250,300), new Point(150,300)};
        Polygon poly2=new Polygon(points2);

        Point [] points3={new Point(50,50), new Point(100,50), new Point(100,100), new Point(50,100)};
        Polygon poly3=new Polygon(points3);

        Polygon [] polygons={poly1,poly2,poly3};

        for (int i=0; i<polygons.length; i++){
            serializeFigure((Figure)polygons[i],"Polygon"+(i+1)+".txt");
        }

        Polygon [] polygonsSerialized=new Polygon[polygons.length];
        for (int i=0; i<polygons.length; i++){
            polygonsSerialized[i]=(Polygon)deserializeFigure("Polygon"+(i+1)+".txt");
        }

        JFrame frame=new PolyFrame(polygonsSerialized);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private static void serializeAndDeserializeFigures() {
        Figure [] figures=new Figure[0];

        figures=addElement(figures,new Point(10,10));
        figures=addElement(figures,new Point(20,20));
        figures=addElement(figures,new Point(30,30));

        figures=addElement(figures,new Line(40,40,50,50));
        figures=addElement(figures,new Line(5,5,7,7));
        figures=addElement(figures,new Line(10,10,60,60));

        figures=addElement(figures,new Triangle(1,1,10,10,20,20));

        for (int i=0; i<figures.length; i++){
            serializeFigure(figures[i],"Figure"+(i+1)+".txt");
        }

        Figure [] figuresSerialized=new Figure[figures.length];
        for (int i=0; i<figuresSerialized.length; i++){
            figuresSerialized[i]=deserializeFigure("Figure"+(i+1)+".txt");
        }

        for (int i=0; i<figuresSerialized.length; i++){
            System.out.println(figuresSerialized[i]);
        }
/*
        figuresSerialized[figuresSerialized.length-1].*/
    }

    public static void serializeFigure(Figure fig, String filename){
        try{
            FileOutputStream f=new FileOutputStream(filename);
            ObjectOutputStream s=new ObjectOutputStream(f);
            s.writeObject(fig);
            s.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Figure deserializeFigure(String filename){
        try {
            FileInputStream f=new FileInputStream(filename);
            ObjectInputStream s=new ObjectInputStream(f);
            Figure fig=(Figure)s.readObject();
            s.close();
            return fig;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void tryFiguresAndPoligons(){
        Point A=new Point();
        Point B=new Point(3,2);
        Point C=new Point(1,1);
        Point D=new Point(5,7);
        Point E=new Point(2,9);

        Line AC=new Line(A, C);
        Line FG=new Line(1,7,3,5);
        Line EK=new Line(E, 3,9);

        Triangle XYZ=new Triangle(0,4,7,2,9,3);
        Triangle ADE=new Triangle(A,D,E);
        Triangle ACB=new Triangle(AC,B);
        Triangle KLM=new Triangle(2,3,7,9,1,3);

        Figure [] figures=new Figure[0];
        figures=addElement(figures,A);
        figures=addElement(figures,B);
        figures=addElement(figures,C);
        figures=addElement(figures,D);
        figures=addElement(figures,E);
        figures=addElement(figures,AC);
        figures=addElement(figures,FG);
        figures=addElement(figures,EK);
        figures=addElement(figures,XYZ);
        figures=addElement(figures,ADE);
        figures=addElement(figures,ACB);
        figures=addElement(figures,KLM);

        for (int i=0; i<figures.length; i++){
            System.out.print(figures[i]+" ");
        }

        System.out.println();

        D.setX(0);
        D.setY(0);

        FG.setA(0,0);
        EK.setB(A);

        XYZ.setA(D);
        ADE.setA(9,9);

        KLM.setAB(AC);

        for (int i=0; i<figures.length; i++){
            System.out.print(figures[i]+" ");
        }

        System.out.println();
        Point [] points={A, B, C, D, E};
        Polygon poly =new Polygon(points);
        System.out.println(poly);

        Point [] points1={new Point(234,95), new Point(111, 22),
                new Point(99,108), new Point(55,37)};
        Polygon poly1=new Polygon(points1);
        System.out.println(poly1);
    }

    public static Figure[] addElement(Figure[] arr, Figure x){
        Figure[] array=new Figure[arr.length+1];

        for (int i=0; i<arr.length; i++){
            array[i]=arr[i];
        }
        array[array.length-1]=x;
        return array;
    }
}
