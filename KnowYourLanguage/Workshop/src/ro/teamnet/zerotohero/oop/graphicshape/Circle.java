package ro.teamnet.zerotohero.oop.graphicshape;
import java.util.Objects;

import static java.lang.Math.PI;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class Circle extends Shape {
    protected int xPos, yPos,radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;
    }
    public Circle(int xpos1) {
        this.xPos = xpos1;
    }
    public Circle(int xpos1,int xpos2) {
        this.xPos = xpos1;
        this.yPos = xpos2;
    }
    public Circle(int xpos1,int xpos2, int radius1) {
        this.xPos = xpos1;
        this.yPos = xpos2;
        this.radius=radius1;
    }

    @Override
    public double area() {
        return super.area();
    }

    @Override
    public String toString() {

        return "center = ("+this.xPos+","+this.yPos+") and radius = "+this.radius;

    }

}
