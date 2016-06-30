package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class Shape extends AbstractShape implements ShapeBehaviour{

    public double area(){
        return 0;}

    protected int color;
    protected float saturation;

    public void setColor(int color){
        this.color = color;
    }
    public void setSaturation(float saturation){

        this.saturation = saturation;
    }


    /*public static void main(String[] args) {

    }*/
}
