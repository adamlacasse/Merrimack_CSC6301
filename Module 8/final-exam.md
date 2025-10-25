# Final exam
## Instructions
- You have four hours to solve all eight questions.
- You have to submit one single pdf with your answers. In this .pdf you can put electronic edited text, photo of handwritten text or annotations, print screen images, or any other materials you believe to be appropriate as your answer.
- Remember to number your answers from 1 to 8.

## Questions

### 1. Include the docstrings documentation
Given the code below, insert the docstrings to properly document the class and all its methods. You will need to explain the code considering that the documentation reader will need to understand the code enough to provide maintenance.

```python
class Queue:
    def __init__(self):
        self.a_in = []
        self.a_out = []
    
    def enqueue(self, d):
        self.a_in.append(d)
    
    def dequeue(self):
        if (self.a_out == []):
            for d in self.a_in:
                self.a_out.append(d)
            self.a_in = []
        return self.a_out.pop(0)
```

#### Answer:

```python
class Queue:
    """
    A FIFO (First-In-First-Out) queue implementation using two internal lists.
    
    This implementation uses two lists to achieve amortized O(1) 
    enqueue and dequeue operations. Items are added to `a_in` and removed 
    from `a_out`. When `a_out` is empty, all items from `a_in` are moved 
    to `a_out` in reverse order, preserving FIFO semantics.
    
    Attributes:
        a_in (list): List for incoming enqueued elements.
        a_out (list): List for outgoing dequeued elements.
    """
    
    def __init__(self):
        """
        Initialize an empty queue with two internal lists.
        
        The `a_in` list holds newly enqueued items, while `a_out` 
        holds items ready to be dequeued in FIFO order.
        """
        self.a_in = []
        self.a_out = []
    
    def enqueue(self, d):
        """
        Add an element to the back of the queue.
        
        Args:
            d: The data element to enqueue (any type).
        
        Time Complexity: O(1)
        """
        self.a_in.append(d)
    
    def dequeue(self):
        """
        Remove and return the element at the front of the queue.
        
        If `a_out` is empty, this method transfers all elements from 
        `a_in` to `a_out` in reverse order to maintain FIFO behavior. 
        This transfer happens at most once per batch of enqueued items, 
        resulting in amortized O(1) performance.
        
        The amortized analysis works because each element is transferred 
        at most once from `a_in` to `a_out`, then dequeued once. Over n 
        dequeue operations, the total cost is O(n) for transfers + O(n) 
        for pops = O(2n), averaging to O(1) per operation.
        
        Returns:
            The front element of the queue.
        
        Raises:
            IndexError: If the queue is empty when dequeue is called.
        
        Time Complexity: Amortized O(1), worst-case O(n) when transferring.
        """
        if (self.a_out == []):
            for d in self.a_in:
                self.a_out.append(d)
            self.a_in = []
        return self.a_out.pop(0)
```

#### Reasoning:
The docstrings follow PEP 257 conventions with a class-level summary explaining the two-stack design pattern and its performance characteristics. Each method includes a brief description, parameters (Args), return values, potential exceptions, and time complexity notes. The `__init__` docstring clarifies the role of each internal list. The `dequeue` docstring explains the batched transfer mechanism that ensures FIFO ordering while maintaining amortized constant-time performance. This documentation gives maintainers enough context to understand the algorithmic trade-offs and modify the implementation safely.

---

### 2. Convert from Python to Java
Convert the code below from Python to Java and follow all best practices to Java code including choice of Identifiers and Code Formatting.

**Note:** See image in `final-exam-questions.pdf` page 3 for Python code to convert.

#### Answer:

```java
import java.util.Scanner;
import java.util.Set;

public final class RockPaperScissors {

    private static final Set<String> VALID_CHOICES = Set.of("r", "p", "s");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            play(scanner);
        }
    }

    private static void play(Scanner scanner) {
        String playerChoice;
        while (true) {
            System.out.print("Enter (r)ock, (s)cissors, or (p)aper: ");
            playerChoice = scanner.nextLine().trim().toLowerCase();
            if (!VALID_CHOICES.contains(playerChoice)) {
                System.out.println("Only 'r', 's', or 'p' are valid inputs! Please try again.");
            } else {
                break;
            }
        }

        String computerChoice = pickComputerChoice();
        announceOutcome(playerChoice, computerChoice);
    }

    private static String pickComputerChoice() {
        double rand = Math.random();
        if (rand < 1.0 / 3.0) {
            return "r";
        } else if (rand < 2.0 / 3.0) {
            return "s";
        }
        return "p";
    }

    private static void announceOutcome(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            System.out.println("It is a tie!");
        } else if (playerLoses(playerChoice, computerChoice)) {
            System.out.printf("Sorry, you lost as I had %s.%n", describeChoice(computerChoice));
        } else {
            System.out.printf("Congrats, you won as I had %s.%n", describeChoice(computerChoice));
        }
    }

    private static boolean playerLoses(String playerChoice, String computerChoice) {
        return ("r".equals(playerChoice) && "p".equals(computerChoice))
            || ("p".equals(playerChoice) && "s".equals(computerChoice))
            || ("s".equals(playerChoice) && "r".equals(computerChoice));
    }

    private static String describeChoice(String choice) {
        return switch (choice) {
            case "r" -> "rock";
            case "p" -> "paper";
            case "s" -> "scissors";
            default -> throw new IllegalArgumentException("Unexpected choice: " + choice);
        };
    }
}
```

#### Reasoning:
The Java version mirrors the Python control flow while adopting Java conventions: input handled through a `Scanner`, validation loop using a `Set` of allowed symbols, and `Math.random()` to choose the computer move. Helper methods (`pickComputerChoice`, `announceOutcome`, `playerLoses`, `describeChoice`) keep `main` small and readable. Using `switch` and `printf` provides clear messaging, and choice descriptions give the player context similar to the Python prints.

---

### 3. Class Diagram
Draw the class diagram for the Java code represented by the following classes.

**Note:** See image in `final-exam-questions.pdf` page 4 for Java classes.

---

### 4. Java Collections
Using your words, explain the structural and Java implementation differences between the Java Collections Stack and Queue. I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

---

### 5. SDLC
Using your words, what is the advantage of having different teams to develop code and to test it? I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

---

### 6. Version Control
How can we recreate a reusing environment for a Python program that needs packages numpy version 1.18.5 and xlwt version 1.3.0 for running your own code? What command line command is necessary? Do you need additional files? Do you need to make changes in the .py files? I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

---

### 7. Profiling
Considering the code below and the obtained output, which function would you consider optimizing? Explain your choice. I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

**Note:** See image in `final-exam-questions.pdf` page 8 for code and profiling output.

---

### 8. SDM
Which among the methodologies Agile, Lean, and DevOps is more similar (or less different) to the Waterfall methodology? Explain your choice. I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

--- 
