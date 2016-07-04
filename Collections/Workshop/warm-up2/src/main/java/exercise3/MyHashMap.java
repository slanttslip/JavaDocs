package exercise3;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private int capacity;

    public MyHashMap(int capacity) {
        this.capacity = capacity;

        // Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>();
        for(Integer i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public String get(String key) {
       if (key == null)
            return null;
        int hash;
        if(key.hashCode()<0)
            hash=-key.hashCode()%this.capacity;
        else
            hash=key.hashCode()%this.capacity;

        LinkedList<MyEntry> mylist = buckets.get(hash);
        for (MyEntry me : mylist) {
            if (me.getKey().equals(key))
                return me.getValue();
        }
        return null;
    }
    public void put(String key, String value) {
        if(key==null)
            buckets.get(0).add(new MyEntry(key, value));
        //
        else if(!this.values().contains(value)){
        int hash;
        if(key.hashCode()<0)
        hash=-key.hashCode()%this.capacity;
        else
        hash=key.hashCode()%this.capacity;
        buckets.get(hash).add(new MyEntry(key,value));}

    }



    public Set<String> keySet() {
        Set <String> mylist=new HashSet<String>();
        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {

            for (MyEntry mye :lista_mea_de_caldari) {
                mylist.add(mye.getKey());
            }
        }
        return mylist;

    }

    public Collection values() {
        LinkedList <String> mylist=new LinkedList<String>();

        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {

            for (MyEntry mye :lista_mea_de_caldari) {
                mylist.add(mye.getValue());
            }
        }
        return mylist;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        String returns=null;
        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {
                for (MyEntry a:lista_mea_de_caldari){
           if(a.getKey().equals(key)){ lista_mea_de_caldari.remove(a);returns=a.getValue();}
            }}


        return returns;
    }

    public boolean containsKey(String key) {

        Boolean returns=false;
        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {
            for (MyEntry a:lista_mea_de_caldari){
                if(a.getKey().equals(key)){returns=true;}
            }}


        return returns;
    }

    public boolean containsValue(String value) {
        // TODO
        Boolean returns=false;
        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {
            for (MyEntry a:lista_mea_de_caldari){
                if(a.getValue().equals(value)){returns=true;}
            }}

        return returns;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
int suma=0;

        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {

            suma+=lista_mea_de_caldari.size();
        }
        return suma;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {

            lista_mea_de_caldari.clear();
        }

    }

    public Set<MyEntry> entrySet() {
        Set entryse=new HashSet();
        for (LinkedList<MyEntry> lista_mea_de_caldari: buckets) {
            for (MyEntry a:lista_mea_de_caldari){
                entryse.add(a);
            }}
        return entryse;
    }

    public boolean isEmpty() {
        if(this.size()==0)
        return true;
        else return false;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
