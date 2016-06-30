package ro.teamnet.zerotohero.Exceptions;

import java.util.Calendar;

/**
 * Created by Adrian.Calancea on 6/30/16.
 */
public class exception {
int matrix[];
    int n;
    public exception(int n) throws exceptie{
        if (n< 0) throw new exceptie("Valoare Incorecta pentru un tabel"+java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()),"wewe");

        this.matrix=new int[n];
    }
    public static void main(String[] args) {

        try{
    exception matrice=new exception(2);
            exception matrice1=new exception(-2);
            matrice1.matrix[7]=2;
}
catch(exceptie|ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
}
        finally {
    System.out.println("final");


        }
    }
}

