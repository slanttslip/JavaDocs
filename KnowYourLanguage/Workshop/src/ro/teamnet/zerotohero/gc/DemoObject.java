package ro.teamnet.zerotohero.gc;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class DemoObject {

    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;

    public DemoObject() {
        this.objectRef = this.toString();
        this.temp=objectRef;
        count++;
    }

}
