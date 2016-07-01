package exercise.exercise3;

import java.util.*;

/**
 * Created by Radu.Hoaghe on 04/20/2015.
 *
 * Exercise 3: Fill three Set implementations that you know (Hint: they were described during
 *             the earlier presentation) with the List<String> that is given to this class by
 *             its constructor.
 *
 *             Check out the elements that the list mentioned above contains and then, add them
 *             to your three Sets. After this check out the elements of your Sets. What do you
 *             remark? What could be the reason?
 *
 *             Finally, add to the one of the three Sets some elements
 *             that already exist in the Set (e.g add("that") and add("collection"))
 *
 *             To run your implementation, run the Exercise3Test class.
 */
public class Exercise3 {

    // List containing some elements that need to be added into the Set
    private List<String> listToAdd;
    private Set<String> mySet1 = new HashSet<String>();
    private LinkedHashSet<String> mySet2 = new LinkedHashSet<String>();
    private TreeSet<String> mySet3 = new TreeSet<String>();

    public Exercise3(List<String> l) {
        listToAdd = l;
    }

    public void addElementsToSets() {

        System.out.println("The elements that will be added to the Sets: ");
        // TODO Exercise #3 a) Check the content of the elements you will add into the Set
        System.out.println(listToAdd);
        // TODO Exercise #3 b) add the elements from listToAdd to the Sets

        for (String element : listToAdd) {
            mySet1.add(element);
            mySet2.add(element);
            mySet3.add(element);
        }
        // TODO Exercise #3 c) Check the content of the Sets
        System.out.println("\nThe elements contained in the first Set: ");
        System.out.println(mySet1);
        System.out.println("\nThe elements contained in the second Set: ");
        System.out.println(mySet2);
        System.out.println("\nThe elements contained in the third Set: ");
        System.out.println(mySet3);
        mySet3.add(".");
        mySet3.add(mySet3.first());
        System.out.println("\nThe elements contained in the TreeSet after inserting two duplicates: ");
        System.out.println(mySet3);
        // TODO Exercise #3 d) Add to the TreeSet two elements that already exist in the Set
        // TODO Exercise #3 d) and print again the TreeSet. What do you see?

        System.out.println("\nAfter ADD the comparator ");
        TreeSet<siruri> mySet4 = new TreeSet<siruri>(new mycompare_dupa_lungime());
        for (String element : listToAdd) {
            mySet4.add(new siruri(element));
        }
        for (siruri element : mySet4) {
            System.out.println(element.getStringul_din_three());
        }


        System.out.println("\nAfter 2 st Comparator ");
        TreeSet<siruri> mySet5 = new TreeSet<siruri>(new mycompare_dupa_String());
        for (String element : listToAdd) {
            mySet5.add(new siruri(element));
        }
        for (siruri element : mySet5) {
            System.out.println(element.getStringul_din_three());
        }
    }


}
class mycompare_dupa_lungime implements Comparator<siruri>{
    public int compare(siruri o1, siruri o2) {
if(o1.getNumberOfCharacters()>o2.getNumberOfCharacters()) return 1;
        else
        return -1;
    }
}

class mycompare_dupa_String implements Comparator<siruri>{
    public int compare(siruri o1, siruri o2) {
        return o1.getStringul_din_three().compareTo(o2.getStringul_din_three());
    }
}


class siruri{
    private String stringul_din_three;
    public siruri(String n){
        this.stringul_din_three=n;
    }

    public int getNumberOfCharacters() {
        return stringul_din_three.length();
    }

    public String getStringul_din_three() {
        return stringul_din_three;
    }
}

