package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class Circle extends Shape {
    protected int xPos, yPos,radius;

    public Circle() {
        this.xPos = 1;
        this.yPos = 1;
        this.radius = 1;
    }
    public Circle(int radius) {
        this.radius= radius;
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
    public double area(){
        return PI*pow(this.radius,2);
    }

    @Override
    public String toString() {

        return "center = ("+this.xPos+","+this.yPos+") and radius = "+this.radius;

    }

    public void fillColour() {

        System.out.println(color);

    }

    public void fillColour(int culoarea) {

        setColor(culoarea);
        System.out.println("The circle color is now "+color);

    }

    public void fillColour(float saturatia) {

        setSaturation(saturatia);

    }
}
