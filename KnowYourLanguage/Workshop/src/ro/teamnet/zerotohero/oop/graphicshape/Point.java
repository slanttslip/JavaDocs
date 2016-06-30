package ro.teamnet.zerotohero.oop.graphicshape;

import java.security.PublicKey;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class Point {
    public int xPos, yPos;
    public Point(int xpos, int ypos){
        this.xPos=xpos;
        this.yPos=ypos;
    }
    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        // check if the dynamic type of 'other' is Point
        // if 'other' is of any other type than 'Point', the two objects cannot be
        // equal if 'other' is of type Point (or one of its derived classes), then
        // downcast the object to Point type and then compare members for equality
        if(other instanceof Point) {
            Point anotherPoint = (Point) other;
            // two points are equal only if their x and y positions are equal
            if( (xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos) )
                return true;
        }
        return false;
    }

}
