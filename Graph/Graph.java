/**
 * It is an interactive test class for MyGraph
 * 
 * @author Hyojin Park
 * @version Dec 6, 2022
 */
import java.util.Scanner;

public class Graph
{
   public static void main(String args[]){
        int numberOfVertices;
        String result;
        int [][] graphRep;
        int startVertex;
        int choice;
        Scanner input = new Scanner(System.in);
        MyGraph graph = null;
       
        do{
            menu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch(choice){
            case 1:
                System.out.println("Enter an graph.");
                System.out.print("First enter the number of vertices: ");
                numberOfVertices = input.nextInt();
                graphRep = new int[numberOfVertices+1][numberOfVertices+1];
                System.out.println("Enter the matrx reprentation of the graph.");
                System.out.println("If no edge between two vertices, enter 0");
                for(int i = 1; i<= numberOfVertices; i++){
                    for(int j = 1; j <= numberOfVertices; j++){
                        graphRep[i][j] = input.nextInt();
                    }
                }
                graph = new MyGraph(graphRep);
                break;
            case 2: 
                System.out.print("Enter the start vertex: ");
                startVertex = input.nextInt();
                result = graph.bfs(startVertex);
                if(result == null)
                    System.out.println("No such a start vertex");   
                else
                    System.out.println("The result for BFS is: " + result);
                break;
            case 3:
                System.out.print("Enter the start vertex: ");
                startVertex = input.nextInt();
                result = graph.dfs(startVertex);
                if(result == null)
                    System.out.println("No such a start vertex");   
                else
                    System.out.println("The result for DFS is: " + result);
                break;
            case 4:
                System.out.println("Make sure you run enough test before you turn it in");
                break;
            default:
                System.out.println("Wrong option. Please choose from menu");
                break;
            }
        }while(choice != 4);
        
    }
    
    private static void menu(){
        System.out.println("*********************************");
        System.out.println("*              MENU             *");
        System.out.println("* 1. Enter a graph              *");
        System.out.println("* 2. Breadth First Search       *");
        System.out.println("* 3. Depth First Search         *");
        System.out.println("* 4. Quit                       *");
        System.out.println("********************************");
    }
}


/*
 ******** Sample Output *******
  
         *********************************
        *              MENU             *
        * 1. Enter a graph              *
        * 2. Breadth First Search       *
        * 3. Depth First Search         *
        * 4. Quit                       *
        ********************************
        Enter your choice: 1
        Enter an graph.
        First enter the number of vertices: 5
        Enter the matrx reprentation of the graph.
        If no edge between two vertices, enter 0
        0
        1
        1
        0
        1
        1
        0
        0
        1
        1
        1
        0
        0
        1
        0
        0
        1
        1
        0
        0
        1
        1
        0
        0
        0
        *********************************
        *              MENU             *
        * 1. Enter a graph              *
        * 2. Breadth First Search       *
        * 3. Depth First Search         *
        * 4. Quit                       *
        ********************************
        Enter your choice: 2
        Enter the start vertex: 1
        The result for BFS is: [1, 2, 3, 5, 4]
        *********************************
        *              MENU             *
        * 1. Enter a graph              *
        * 2. Breadth First Search       *
        * 3. Depth First Search         *
        * 4. Quit                       *
        ********************************
        Enter your choice: 3
        Enter the start vertex: 5
        The result for DFS is: [5, 2, 4, 3, 1]
        *********************************
        *              MENU             *
        * 1. Enter a graph              *
        * 2. Breadth First Search       *
        * 3. Depth First Search         *
        * 4. Quit                       *
        ********************************
        Enter your choice: 2
        Enter the start vertex: 2
        The result for BFS is: [2, 1, 4, 5, 3]
        *********************************
        *              MENU             *
        * 1. Enter a graph              *
        * 2. Breadth First Search       *
        * 3. Depth First Search         *
        * 4. Quit                       *
        ********************************
        Enter your choice: 3
        Enter the start vertex: 1
        The result for DFS is: [1, 5, 3, 4, 2]
        *********************************
        *              MENU             *
        * 1. Enter a graph              *
        * 2. Breadth First Search       *
        * 3. Depth First Search         *
        * 4. Quit                       *
        ********************************
        Enter your choice: 4
        Make sure you run enough test before you turn it in

 */