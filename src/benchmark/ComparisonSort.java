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
	 
	    
	  
}
