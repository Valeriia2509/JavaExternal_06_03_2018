package Task1;

import javax.swing.*;
import java.awt.*;
import java.awt.Polygon;

public class PolyFrame extends JFrame {
    private Polygon [] polygons;

    public PolyFrame(Task1.Polygon [] polys){
        JPanel panel = new JPanel();
        add(panel);

        polygons=new Polygon[polys.length];

        for (int i=0; i<polygons.length; i++){
            polygons[i]=new Polygon(polys[i].getPolyX(),polys[i].getPolyY(),polys[i].getPolyN());
        }
    }

    public void paint(Graphics g){
        for (int i=0; i<polygons.length; i++)
            g.drawPolygon(polygons[i]);
    }

}
