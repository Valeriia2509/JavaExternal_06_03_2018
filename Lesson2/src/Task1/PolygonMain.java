/*
создать динамический массив из разных фигур и вывести информацию на экран
создать класс Polygon для описания фигур разной размерности
 */
package Task1;

public class PolygonMain {
    public static void main(String[]args){

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

        Polygon [] figures=new Polygon[0];
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

        for (int i=0; i<figures.length;i++){
            System.out.println(figures[i].printDimension()+figures[i].toString()+", ");
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
    }

    public static Polygon[] addElement(Polygon[] arr, Polygon x){
        Polygon[] array=new Polygon[arr.length+1];

        for (int i=0; i<arr.length; i++){
            array[i]=arr[i];
        }
        array[array.length-1]=x;
        return array;
    }
}
