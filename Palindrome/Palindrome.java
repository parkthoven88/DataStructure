/**
 * CSCI463ProjectTwo: Use MyStack and MyQueue to write a project that check if a sentence is palindrom
 * 
 * @author Hyojin Park
 * @version Date 10-06-2022
 */
import java.util.Scanner;

public class Palindrome
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        String sentence;
        String again;
        do{
            System.out.println("Enter a sentence, I will tell you if it is a palindrome: ");
            sentence = input.nextLine();
            if(isPalindrome(sentence))
                System.out.println("\"" + sentence + "\" is a palindrome!");
            else
                System.out.println("\"" + sentence + "\" is not a palindrome!");
            System.out.println("Do you want another test (\"YES\" or \"NO\"): ");
            again = input.nextLine();
        }while(again.equalsIgnoreCase("YES"));
        
    }
    
    /**
     * isPalindrom returns true if the given String is a palindrom
     * @
     */
    public static boolean isPalindrome(String sentence)
    {
        // declare a MyStack s
        MyStack<Character> s = new MyStack();
        // declare a MyQueue q
        MyQueue<Character> q = new MyQueue();
        for(int i = 0; i < sentence.length(); i++)
        {
            char c = sentence.charAt(i);
            // if ith character in sentence is a letter
            if(Character.isLetter(c)){
                s.push(Character.toUpperCase(c));
                q.push(Character.toUpperCase(c));
            }
                // convert to upper case and push it into s and q
        }
        while(!s.isEmpty()){
            // if the front of the queue not match the top of stack
            if(s.peek() != q.peek())
                return false;
                // return false
            // pop out top of the stack and front of the queue
            s.pop();
            q.pop();
        }
        return true;
    }
    
   
}

/*
 *  (Sample Run)
 *  
 *  Enter a sentence, I will tell you if it is a palindrome: 
    Able was I ere I saw Elba
    "Able was I ere I saw Elba" is a palindrome!
    Do you want another test ("YES" or "NO"): 
    yes
    Enter a sentence, I will tell you if it is a palindrome: 
    racecar
    "racecar" is a palindrome!
    Do you want another test ("YES" or "NO"): 
    yes
    Enter a sentence, I will tell you if it is a palindrome: 
    refer
    "refer" is a palindrome!
    Do you want another test ("YES" or "NO"): 
    yes
    Enter a sentence, I will tell you if it is a palindrome: 
    madam
    "madam" is a palindrome!
    Do you want another test ("YES" or "NO"): 
    yes
    Enter a sentence, I will tell you if it is a palindrome: 
    Mr. Owl ate my metal worm
    "Mr. Owl ate my metal worm" is a palindrome!
    Do you want another test ("YES" or "NO"): 
    yes
    Enter a sentence, I will tell you if it is a palindrome: 
    as you know won ku oys a
    "as you know won ku oys a" is a palindrome!
    Do you want another test ("YES" or "NO"): 
    yes 
    Enter a sentence, I will tell you if it is a palindrome: 
    I love you
    "I love you" is not a palindrome!
    Do you want another test ("YES" or "NO"): 
    no

 */