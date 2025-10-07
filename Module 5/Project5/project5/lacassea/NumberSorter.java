package project5.lacassea;

import java.util.*;

/**
 * NumberSorter is a program that reads integer numbers from standard input
 * and stores them in a Stack in sorted order from smallest to largest.
 *
 * This program demonstrates the use of the Java Collections Framework,
 * specifically Stack and Collections.sort() method.
 *
 * <p><strong>Design overview</strong></p>
 * <pre>
 *  ┌─────────────┐   push()    ┌────────────────┐   Collections.sort()   ┌────────────────────┐
 *  │ User Input  ├────────────▶│ Stack&lt;Integer&gt;│────────────────────────▶│ displayResults()   │
 *  └─────────────┘             └────────────────┘                         └────────────────────┘
 *           ▲                             │                                        │
 *           └───────────── Scanner ───────┴───────────────────── copy+pop() ───────┘
 * </pre>
 * The stack preserves insertion order until sorted, then the program prints both the ascending
 * list and the LIFO pop view to highlight how the stack structure behaves after sorting.
 *
 * @author Adam LaCasse
 * @version 2.0
 * @since 2025-10-07
 */
public class NumberSorter {

    /**
     * Creates a new {@code NumberSorter}. The class is stateless, so the constructor
     * exists primarily to support instantiation from {@link #main(String[])} and to
     * provide documented JavaDoc output.
     */
    public NumberSorter() {
        // No state to initialize; the sorter operates through method calls.
    }
    
    /**
     * Main method that executes the number sorting program.
     *
     * Reads integers from standard input until EOF or non-integer input is encountered.
     * Stores the numbers in a Stack and sorts them in ascending order.
     * Displays the sorted numbers to the user.
     *
     * @param args Command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        NumberSorter sorter = new NumberSorter();
        sorter.run();
    }
    
    /**
     * Executes the main logic of the program.
     *
     * This method handles the input reading, sorting, and output display.
     * It uses a Stack from the Collections Framework to store the numbers
     * and Collections.sort() to sort them in ascending order.
     */
    public void run() {
        Stack<Integer> numbers = readNumbers();
        sortNumbers(numbers);
        displayResults(numbers);
    }
    
    /**
     * Reads integer numbers from standard input and stores them in a Stack.
     *
     * The method continues reading until:
     * - End of file (EOF) is reached
     * - Non-integer input is encountered
     * - An empty line is entered
     *
     * @return Stack<Integer> containing all successfully read numbers
     */
    private Stack<Integer> readNumbers() {
        // CODE REUSE: Using java.util.Stack - a LIFO data structure implementation
        // from the Collections Framework. This saves us from implementing our own
        // stack data structure with array resizing, node management, etc.
        Stack<Integer> numbers = new Stack<>();
        
        // CODE REUSE: Using java.util.Scanner for input parsing - leverages existing
        // tokenization and type conversion functionality instead of manually parsing strings
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter integer numbers (one per line):");
        System.out.println("Press Ctrl+D (EOF) or enter a non-integer to finish:");
        
        while (scanner.hasNext()) {
            try {
                // CODE REUSE: hasNextInt() and nextInt() methods reuse existing
                // input validation and integer parsing logic from Scanner class
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    // CODE REUSE: Stack.push() method reuses existing stack manipulation
                    // logic - no need to implement array resizing, node creation, or size tracking
                    numbers.push(number);
                    System.out.println("Added: " + number);
                } else {
                    // If next input is not an integer, break the loop
                    String input = scanner.next();
                    if (input.trim().isEmpty()) {
                        System.out.println("Empty input - stopping input.");
                        break;
                    }
                    System.out.println("Invalid input '" + input + "' - stopping input.");
                    break;
                }
            } catch (InputMismatchException e) {
                // CODE REUSE: Leveraging Java's built-in exception handling system
                // instead of implementing custom error checking for invalid input
                System.out.println("Invalid input - stopping input.");
                break;
            } catch (NoSuchElementException e) {
                // CODE REUSE: Using existing exception handling for EOF detection
                // rather than manually checking for end-of-stream conditions
                System.out.println("EOF reached - stopping input.");
                break;
            }
        }
        
        scanner.close();
        return numbers;
    }
    
    /**
     * Sorts the stack of integers in ascending order using Collections.sort().
     *
     * This method demonstrates the use of the Collections Framework's sorting capability.
     * The sort is performed in-place, modifying the original Stack.
     *
     * @param numbers The Stack<Integer> to be sorted
     */
    private void sortNumbers(Stack<Integer> numbers) {
        // CODE REUSE: Using empty() method from Stack/Vector
        // instead of checking if size() == 0 or implementing custom empty check
        if (numbers.empty()) {
            System.out.println("No numbers to sort.");
            return;
        }
        
        // CODE REUSE: Using size() method from Collection interface
        System.out.println("\nSorting " + numbers.size() + " numbers...");
        
        // CODE REUSE: Using Collections.sort() instead of implementing
        // our own sorting algorithm (bubble sort, merge sort, quicksort, etc.)
        // This leverages Java's optimized TimSort algorithm - a hybrid stable sorting
        // algorithm derived from merge sort and insertion sort, with O(n log n) complexity
        Collections.sort(numbers);
        
        System.out.println("Sorting completed.");
    }
    
    /**
     * Displays the sorted numbers to the user.
     *
     * Shows both the count of numbers and the complete sorted list.
     * If no numbers were entered, displays an appropriate message.
     *
     * @param numbers The sorted Stack<Integer> to display
     */
    private void displayResults(Stack<Integer> numbers) {
        System.out.println("\n" + "=".repeat(50));
        
        // CODE REUSE: Again using empty() from Stack/Vector
        if (numbers.empty()) {
            System.out.println("No numbers were entered.");
        } else {
            System.out.println("Sorted numbers (smallest to largest):");
            // CODE REUSE: Using size() method from Collection interface
            System.out.println("Total count: " + numbers.size());
            // CODE REUSE: Using toString() method inherited from AbstractCollection
            // which automatically formats the list as [element1, element2, ...]
            // instead of manually building the string representation
            System.out.println("Numbers: " + numbers);
            
            // Also display in a more readable format
            System.out.print("List: ");
            // CODE REUSE: Using get() method from List interface
            // The get() method reuses Stack/Vector's internal indexing logic
            // instead of manually implementing array or pointer navigation
            for (int i = 0; i < numbers.size(); i++) {
                // CODE REUSE: get(i) leverages Stack/Vector's existing indexing mechanism
                System.out.print(numbers.get(i));
                if (i < numbers.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();

            // Demonstrate LIFO behavior by popping elements from a copy
            Stack<Integer> copy = new Stack<>();
            copy.addAll(numbers);
            System.out.print("Stack top-to-bottom (pop order): ");
            while (!copy.empty()) {
                System.out.print(copy.pop());
                if (!copy.empty()) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
        
        System.out.println("=".repeat(50));
    }
}
