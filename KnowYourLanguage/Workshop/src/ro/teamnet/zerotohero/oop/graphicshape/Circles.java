package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class Circles {
public double getAreaPub(){
Circle circle=new Circle(2,2,2);
    return circle.area();
}
public void getAreaDef(){
    Circle circle=new Circle();
   circle.fillColour();
    circle.fillColour(2);
    circle.fillColour(3.6f);
}
}
