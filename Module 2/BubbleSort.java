/**
 * BubbleSort implementation of the classic Bubble Sort algorithm.
 * 
 * @author Adam LaCasse
 * @version 1.0
 */
public class BubbleSort {
    
    /**
     * Sorts an array using the Bubble Sort algorithm.
     * Compares adjacent elements and swaps them if needed.
     * 
     * @param arr the integer array to sort
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null) return;
        
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Main method demonstrating the bubble sort algorithm.
     * 
     * @param args command line arguments - not required for this basic implementation
     */
    public static void main(String[] args) {
        int[] myArray = {2, 45, 37, 21, 31, 50, 29, 22, 67, 88, 56};
        
        System.out.println("Original: [2, 45, 37, 21, 31, 50, 29, 22, 67, 88, 56]");
        bubbleSort(myArray);
        
        System.out.print("Sorted:   [");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i]);
            if (i < myArray.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
