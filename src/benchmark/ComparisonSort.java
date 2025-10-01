package benchmark;

import java.util.Random;
import java.util.Arrays;

public class ComparisonSort
{
	public static int[] RandomizedArray(int size, int start, int end)
	{
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = rand.nextInt(end - start + 1) + start;
        }
        return arr;
    }
	
	// Need bubble sort now
	class BubbleSort // Used GeeksforGeeks Documentation
	{  
	    void bubbleSort(int arr[])
	    {
	        int n = arr.length;
	      
	        for (int i = 0; i < n - 1; i++)
	            for (int j = 0; j < n - i - 1; j++)
	                if (arr[j] > arr[j + 1]) {
	                  
	                    // swap temp and arr[i]
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	    }
	 
	    
	  // Now, onto selection sort
	   private static void selectionSort(int[] numbers) // Used zyBook section 3.3
	    {
	        for (int i = 0; i < numbers.length - 1; i++)
	        {
	           // Find index of smallest remaining element
	           int indexSmallest = i;
	           for (int j = i + 1; j < numbers.length; j++)
	           {
	              if (numbers[j] < numbers[indexSmallest])
	              {
	                 indexSmallest = j;
	              }
	           }
	           
	           // Swap numbers[i] and numbers[indexSmallest]
	           int temp = numbers[i];
	           numbers[i] = numbers[indexSmallest];
	           numbers[indexSmallest] = temp;
	        }
	     }
	    
	   public static void main(String[] args)
	   {
	        int size = 10000;
	        int[] originalArray = RandomizedArray(size, 1, 100000);

	        // Duplicate arrays
	        int[] bubbleArray = Arrays.copyOf(originalArray, originalArray.length);
	        int[] selectionArray = Arrays.copyOf(originalArray, originalArray.length);

	        // Bubble Sort timing
	        long start = System.currentTimeMillis();
	        bubbleSort(bubbleArray);
	        long finish = System.currentTimeMillis();
	        long bubbleTime = finish - start;

	        // Selection Sort timing
	        start = System.currentTimeMillis();
	        selectionSort(selectionArray);
	        finish = System.currentTimeMillis();
	        long selectionTime = finish - start;
	        
	    //Print the results
	    System.out.println("Sorting a random array size of " + size + " took Bubble Sort " + bubbleTime + "ms to complete.");
        System.out.println("Sorting a random array size of " + size + " took Selection Sort " + selectionTime + "ms to complete.");
}
