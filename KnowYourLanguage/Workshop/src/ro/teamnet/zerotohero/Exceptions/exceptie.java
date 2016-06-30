package ro.teamnet.zerotohero.Exceptions;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adrian.Calancea on 7/1/16.
 */
public class exceptie extends Exception {
    public String mydate;
    public exceptie(String mess, String dataes){
        super(mess);
        this.mydate=dataes;
    }

}
