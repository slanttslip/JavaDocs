package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.Canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

import java.io.*;
import java.util.*;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles circles=new Circles();

    System.out.println("The default circle area is "+circles.getAreaPub());
        circles.getAreaDef();
        Canvas canvas=new Canvas();
        Shape shape=new Circle(10);
        System.out.println("The default circle area is "+shape.area());
        ShapeBehaviour square=new Square(10);
        System.out.println("The square area is "+square.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }


}
