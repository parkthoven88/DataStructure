/**
 * Add the following data one by one
 * to a binary search tree, then print out the tree
 * 65, 23, 45, 76, 54, 55, 98, 86 to test output
 * 
 * 
 * @author Hongbiao Zeng 
 * @version April 1, 2020
 */
import java.util.Scanner;
public class Search
{
    public static void main(String args[]){
        int data;
        int choice;
        Scanner input = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
       
        do{
            menu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch(choice){
            case 1:
                System.out.print("Enter data that you will add to tree: ");
                data = input.nextInt();
                tree.insert(new Integer(data));
                System.out.println("The tree is: " + tree);
                break;
            case 2: 
                System.out.print("Enter data that you will remvoe from tree: ");
                data = input.nextInt();
                if(tree.search(data) == null)
                    System.out.println("No such data in tree");
                else{
                    tree.remove(new Integer(data));
                    System.out.println("The tree is: " + tree);
                }
                break;
            case 3:
                System.out.print("Enter data that you want to search for: ");
                data = input.nextInt();
                if(tree.search(data) == null)
                    System.out.println("No such data in tree");
                else
                    System.out.println("The tree is: " + tree + ". Data found in tree");
                break;
            case 4:
                if(tree.isEmpty())
                    System.out.println("Tree is empty");
                else{
                    System.out.println("The tree is: " + tree);
                    System.out.println("Tree size: " + tree.size());
                    System.out.println("Tree height: " + tree.height());
                }
                break;
            case 5:
                System.out.println("Make sure you run enough test before you turn it in");
                break;
            default:
                System.out.println("Wrong option. Please choose from menu");
                break;
            }
        }while(choice != 5);
        
    }
    
    private static void menu(){
        System.out.println("********************");
        System.out.println("*      MENU        *");
        System.out.println("* 1. Add a node    *");
        System.out.println("* 2. Remove a node *");
        System.out.println("* 3. Search a data *");
        System.out.println("* 4. Tree property *");
        System.out.println("* 5. Quit          *");
        System.out.println("********************");
    }
}

/*
***** Sample Run *****  
             ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 20
            The tree is: (67(35(20(-, -), -), 90(89(-, -), -)))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 57
            The tree is: (67(35(20(-, -), 57(-, -)), 90(89(-, -), -)))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 10
            The tree is: (67(35(20(10(-, -), -), 57(-, -)), 90(89(-, -), -)))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 30
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, -)), 90(89(-, -), -)))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 65
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(-, -), -)))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 95
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(-, -), 95(-, -))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 106
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(-, -), 95(-, 106(-, -)))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 76
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(76(-, -), -), 95(-, 106(-, -)))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 69
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(76(69(-, -), -), -), 95(-, 106(-, -)))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 1
            Enter data that you will add to tree: 110
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(76(69(-, -), -), -), 95(-, 106(-, 110(-, -))))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 4
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(76(69(-, -), -), -), 95(-, 106(-, 110(-, -))))))
            Tree size: 14
            Tree height: 4
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 3
            Enter data that you want to search for: 90
            The tree is: (67(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(76(69(-, -), -), -), 95(-, 106(-, 110(-, -)))))). Data found in tree
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 2
            Enter data that you will remvoe from tree: 67
            The tree is: (69(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 90(89(76(-, -), -), 95(-, 106(-, 110(-, -))))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 2
            Enter data that you will remvoe from tree: 90
            The tree is: (69(35(20(10(-, -), 30(-, -)), 57(-, 65(-, -))), 95(89(76(-, -), -), 106(-, 110(-, -)))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 2
            Enter data that you will remvoe from tree: 20
            The tree is: (69(35(30(10(-, -), -), 57(-, 65(-, -))), 95(89(76(-, -), -), 106(-, 110(-, -)))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 2
            Enter data that you will remvoe from tree: 89
            The tree is: (69(35(30(10(-, -), -), 57(-, 65(-, -))), 95(76(-, -), 106(-, 110(-, -)))))
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 4
            The tree is: (69(35(30(10(-, -), -), 57(-, 65(-, -))), 95(76(-, -), 106(-, 110(-, -)))))
            Tree size: 10
            Tree height: 3
            ********************
            *      MENU        *
            * 1. Add a node    *
            * 2. Remove a node *
            * 3. Search a data *
            * 4. Tree property *
            * 5. Quit          *
            ********************
            Enter your choice: 5
Make sure you run enough test before you turn it in  
 */