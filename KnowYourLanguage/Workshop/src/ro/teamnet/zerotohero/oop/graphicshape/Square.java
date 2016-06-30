package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class Square extends Shape {
private int side;
    public Square( int sidee){
        this.side=sidee;
    }

    @Override
    public double area() {
        return this.side*this.side;
    }
}
