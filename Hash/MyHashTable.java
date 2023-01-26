 

/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 * 
 * @author Hyojin Park
 * @version Oct. 22. 2022
 */
import java.util.ArrayList;

public class MyHashTable<K extends Comparable<K>, V>
{
    private ArrayList<MyHashEntry<K, V>> table;
    private int count; // how many elements in table
    
    /**
     * Constructor. Constructor an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize){
        count = 0;
        table = new ArrayList<MyHashEntry<K,V>>(tableSize);
        for(int i = 0; i < tableSize; i++)
            table.add(null); //initialize every bucket as a null linked list
       
    }
    
    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
       this(10); //default number of bucket is 10
    }
    
    /**
     * get the number of elements in the table
     * @return the number of elements in the table
     */
    public int size(){
       return count;
    }
    
    /**
     * clear the table
     */
    public void clear(){
       for(int i = 0; i < table.size(); i++)
           table.set(i, null); // set bucket refer to a null linked list
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
        int hashValue = key.hashCode()%table.size();
        if(hashValue < 0)
            //java % may return nehative value if your hashcode is negative
            hashValue += table.size();
        if(table.get(hashValue) == null) 
            return null; //not in the table
        //Otherwise, there is a linked list for the elements with the same hash value
        MyHashEntry<K,V> hashEntry = table.get(hashValue);
        
        while(hashEntry != null && hashEntry.getKey().compareTo(key) != 0)
            //search through the linked list to find the element with the key
            hashEntry = hashEntry.getNext();
        if(hashEntry == null)
            return null; //search through whole thing, no match
        return hashEntry.getValue();
    }
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value){
        int hashValue = key.hashCode()%table.size();
        System.out.println(hashValue);
        
        if(hashValue < 0)
            hashValue += table.size();
            
        if(table.get(hashValue) == null) { //add the first one to bucket
            table.set(hashValue, new MyHashEntry<K, V> (key, value));
            count++;
            return; //done add first one
        }
        
        MyHashEntry<K, V> hashEntry = table.get(hashValue);
        // if bucket not empty, find if the key already exist
        while(hashEntry.getNext() != null && hashEntry.getKey().compareTo(key) != 0)
            hashEntry = hashEntry.getNext();
            
        if(hashEntry.getKey().compareTo(key) == 0) //if ket exists, override the old value
            hashEntry.setValue(value);
        else // if key not exist, add new entry
            hashEntry.setNext(new MyHashEntry<K, V>(key, value));
        count++;
    }
    
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key){
        int hashValue = key.hashCode()%table.size();
        if(hashValue < 0)
            hashValue += table.size();
        if(table.get(hashValue) == null) // if the bucket is empty, no item in the table will have such key
            return null;
        MyHashEntry<K, V> hashEntry = table.get(hashValue); //get the head of the linked list
        if(hashEntry.getKey().compareTo(key) == 0){ // if head's key matches, remove the head
            V value = hashEntry.getValue();
            table.set(hashValue, hashEntry.getNext());
            count--;
            return value;
         }
        while(hashEntry.getNext() != null && hashEntry.getNext().getKey().compareTo(key) != 0)
            hashEntry = hashEntry.getNext();
            if(hashEntry.getNext() == null) 
                return null;
            MyHashEntry<K, V> removeEntry = hashEntry.getNext();
            //hashEntry is the node before the one you want to remove
            hashEntry.setNext(removeEntry.getNext());
            count--; //update the count
            return removeEntry.getValue();
}
    
    /**
     * check if the table is empty,i.e. no entry
     * @return true if the table holds no elements; false otherwise
     */
    public boolean isEmpty(){
        return count == 0;
    }
    
    /**
     * return a String representation of the table
     * @return a String representation of the table
     */
    public String toString(){
        String output ="";
        for(int i = 0; i < table.size(); i++){
            MyHashEntry<K, V> hashEntry = table.get(i);
            if(hashEntry != null)
            output += "(" + hashEntry.getKey() + " " + hashEntry.getValue() + ")";
        }
        return output;
    }
}