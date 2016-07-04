package exercise0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.*;


/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        HashMap<String, Double> hm = new HashMap<String, Double>();
        hm.put("Zara", new Double(3434.34));
        hm.put("Mahnaz", new Double(123.22));
        hm.put("Ayan", new Double(1378.00));
        hm.put("Daisy", new Double(99.22));
        hm.put("Qadir", new Double(-19.08));

        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map


        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        Set<String> set = hm.keySet();
for(Object a:set){
    System.out.println(a+":"+hm.get(a));

}

        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]

        System.out.println();
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }

}
