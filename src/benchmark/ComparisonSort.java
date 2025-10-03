package benchmark;

import java.util.Random;
import java.util.Arrays;

public class ComparisonSort
{

    // Generate random array because why not?
    public static int[] RandomizedArray(int size, int start, int end) // Instructions said to use this way, I think I understand why
    {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(end - start + 1) + start;
        }
        return arr;
    }

    // Bubble Sort
    public static void bubbleSort(int arr[]) // Used GeeksforGeeks bubble sort documentation for reference...makes sense in code now
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] numbers) // Used zyBook Section 3.3 for reference...yeah, I'm kind of new to these algorithms
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
    
    // Insertion Sort is here
    public static void insertionSort(int[] arr) // AI believes that this documentation is the way, I can understand it
    {
        for (int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;
            // Shift elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args)
    {
        int size = 10000; // This will be the amount for doing this.
        int[] originalArray = RandomizedArray(size, 1, 100000);

        // Duplicate arrays because I was told to do so
        int[] bubbleArray = Arrays.copyOf(originalArray, originalArray.length);
        int[] selectionArray = Arrays.copyOf(originalArray, originalArray.length);
        int[] insertionArray = Arrays.copyOf(originalArray, originalArray.length);

        // Bubble Sort timing right here with instructed code
        long start = System.currentTimeMillis();
        bubbleSort(bubbleArray);
        long finish = System.currentTimeMillis();
        long bubbleTime = finish - start;

        // Selection Sort timing also right here with instructed code
        start = System.currentTimeMillis();
        selectionSort(selectionArray);
        finish = System.currentTimeMillis();
        long selectionTime = finish - start;
        
        // Insertion Sort timing with this instructed code
        start = System.currentTimeMillis();
        insertionSort(insertionArray);
        finish = System.currentTimeMillis();
        long insertionTime = finish - start;

        // Print the results just like the instructions said to do
        System.out.println("Sorting a random array size of " + size + " took Bubble Sort " + bubbleTime + "ms to complete.");
        System.out.println("Sorting a random array size of " + size + " took Selection Sort " + selectionTime + "ms to complete.");
        System.out.println("Sorting a random array size of " + size + " took Insertion Sort " + insertionTime + "ms to complete.");
    }
}