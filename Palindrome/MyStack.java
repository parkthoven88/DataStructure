/**
 * class MyStack: A stack class implemented by using ArrayList
 * All stack elements are stored in an ArrayList. The top element
 * has index top
 * 
 * @author Hyojin Park
 * @version Date 10-06-2022
 */
import java.util.ArrayList;

public class MyStack<E>
{
    private ArrayList<E> list; // used to store elements in stack
    private int top; // the index of top element
    
    /**
     * constructor construct an empty stack
     */
    public MyStack()
    {
        list = new ArrayList();
        top = -1; // stack is empty
    }
    
    /**
     * push push a given element on the top of the stack
     */
    public void push(E item)
    {
        list.add(item);
        top++;
    }
    
    /**
     * isEmpty return true if the stack is empty; false otherwise
     * @return true if the stack is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
        //return top == -1
    }
    
    /**
     * peek Return the top element
     */
    public E peek()
    {
        if(!isEmpty())
            return list.get(top);
        return null;
    }
    
    /**
     * pop Remove the top element from the stack. If the stack is empty,nothing happen
     */
    public void pop()
    {
       if(!isEmpty())
           list.remove(top--);
    }
    
    /**
     * size return the size of the stack
     * @return number of elements in stack
     */
    public int size()
    {
        return list.size();
        //return top + 1;
    }
}