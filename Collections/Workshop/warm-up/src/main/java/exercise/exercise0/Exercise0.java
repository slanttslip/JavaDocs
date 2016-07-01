package exercise.exercise0;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        ArrayList<String> Lista=new ArrayList<String>();
        Lista.add("Ion");
        Lista.add("Ioana");
        Lista.add("Maria");
        ListIterator<String> i=Lista.listIterator();



        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        while (i.hasNext()){
            System.out.println("Elementul din lista mea "+i.next()+"cu indexul acestuia"+i.nextIndex());
        }

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements

        System.out.println(Lista);
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
for(String interator:Lista){
    System.out.println(interator);
}
//i=Lista.listIterator();
        for(int a=0;a<Lista.size();a++){
            System.out.println(Lista.get(a));
        }

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 e0=new Exercise0();
        e0.iterateThroughList();
    }
}
