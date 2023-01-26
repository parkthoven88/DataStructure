
/**
 * CSCI 251 Project One: Compare Sorting Algorithms
 * 
 * Implement Insert, Select, Quick, and merge Sort in MySort.
 * @author: Hyojin Park
 * @version: 08/09/2022
 */

import java.util.Arrays;

public class MySorts
{
    public static void insertSort(int [] arr)
    {
        int i = 0;
        int j = 0;
        int temp = 0; // Temporary variable for swap
        
        for(i = 1; i < arr.length; ++i){
            j = i;
            // Insert arr[i] into sorted part
            //stopping once numbers[i] in correct position
            while(j > 0 && arr[j] > arr[j-1]) {
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                --j;
            }
        }
    }
    
    public static void selectSort(int [] arr)
    {
        int i = 0,j = 0,indexSmallest = 0,temp = 0;  
        
        for(i = 0; i < arr.length-1; ++i){
            
            //Find index of smallest remainf element
            indexSmallest = i;
            for(j = i+1; j<arr.length; ++j){
                if(arr[j] < arr[indexSmallest]){
                    indexSmallest = j;
                }
            }
            
            //Swap arr[i] and arr[indexSmallest]
            temp = arr[i];
            arr[i] = arr[indexSmallest];
            arr[indexSmallest] = temp;
        }
        
    }
   
    public static int partition(int arr[], int i, int k){
        int lowIndex = i, highIndex = k;
        int pivot = arr[(i+k)/2];
        boolean done = false;
        while(!done) {
            
            //Increment lowIndex while arr[lowIndex] < pivot
            while (arr[lowIndex] < pivot) {
                lowIndex += 1;
            }
            
            //Decrement highIndex while pivot < arr[highIndex]
            while (pivot < arr[highIndex]) {
                highIndex -= 1;
            }
            
            //If zero or one elements remain, then all numbers are partitioned. Return highIndex.
            if (lowIndex >= highIndex) {
                done = true;
            }
            else {
                //Swap arr[lowIndex] and arr[highIndex]
                int temp = arr[lowIndex];
                arr[lowIndex] = arr[highIndex];
                arr[highIndex] = temp;
                
                //Undate lowIndex and highIndex
                lowIndex++;
                highIndex--;
            }
        }
        return highIndex;
    }
    
    public static void quickSort(int arr[], int i, int k){
        if (i >= k) return;
        int j = partition(arr, i, k);
        quickSort(arr, i, j);
        quickSort(arr, j+1, k);
    }
   
    public static void quickSort(int arr[])
    {
        quickSort(arr, 0, arr.length-1);
    }
    
    public static void merge(int arr[], int i, int j, int k) {
        // Size of merged partition
        int mergedSize = k-i+1;
        // Dynamically allocates temporary array for merged numbers
        int mergeArr[] = new int[mergedSize];
        // Position to insert merged number
        int mergePos = 0;
        // Position of elements in left partition
        int leftPos = i;
        // Position of elements in right partition
        int rightPos = j+1;
        // Add smallest element from left or right partition to merged numbers
        while(leftPos <= j && rightPos <= k){
            if(arr[leftPos] <= arr[rightPos]) {
                mergeArr[mergePos++] = arr[leftPos++];
            }
                
            else {
                mergeArr[mergePos++] = arr[rightPos++];
            }
        }
        
        // If left partition is not empty, add remaining elements to merged numbers
        while(leftPos <= j){
            mergeArr[mergePos++] = arr[leftPos++];
        }
        
        // If right partition is not empty, add remaining elements to merged numbers
        while(rightPos <= k) {
            mergeArr[mergePos++] = arr[rightPos++];
        }
       
        for(mergePos = 0; mergePos < mergeArr.length; mergePos++)
            arr[i+mergePos] = mergeArr[mergePos];

    }
    
    public static void mergeSort(int arr[], int i, int k){
        if (i >= k) return;
        int j = (i+k)/2;
        mergeSort(arr, i, j);
        mergeSort(arr, j+1, k);
        merge(arr, i, j, k); 
    }
    
    public static void mergeSort(int [] arr)
    {
        mergeSort(arr, 0, arr.length-1);
    }
}

