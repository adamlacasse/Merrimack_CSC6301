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

#### Answer:

```
┌─────────────────────────┐
│       Person            │
├─────────────────────────┤
│ - name: String          │
│ - age: int              │
├─────────────────────────┤
│ + display(): void       │
└─────────────────────────┘
           △
           │
    ┌──────┴──────┐
    │             │
┌───┴──────────┐  ┌─────────────────┐
│   Student    │  │   Instructor    │
├──────────────┤  ├─────────────────┤
│ - major:     │  │ - title: String │
│   String     │  └─────────────────┘
└──────────────┘
    △
    │
    │ 0..*
    │
┌───┴──────────────────────┐
│       Course             │
├──────────────────────────┤
│ - name: String           │
│ - credits: int           │
│ - teacher: Instructor    │◆────────────────────> Instructor
│ - roster: Student[]      │
├──────────────────────────┤
│ + addStudent(Student):   │
│   void                   │
│ + display(): void        │
└──────────────────────────┘
           △
           │
┌──────────┴──────────────────┐
│      OnlineCourse           │
├─────────────────────────────┤
│ - meetingId: String         │
│ - helper: Person            │◆─────────────────> Person
└─────────────────────────────┘
```

#### Reasoning:
The diagram shows inheritance relationships (hollow triangle arrows): `Student` and `Instructor` both extend `Person`; `OnlineCourse` extends `Course`. Composition relationships (filled diamond) indicate ownership: `Course` has one `Instructor` (`teacher`) and an array of `Student` objects (`roster`); `OnlineCourse` has a `Person` helper. The attributes are marked private (`-`), methods are public (`+`), and multiplicities are shown where applicable (e.g., `0..*` indicates zero or more students). This captures the structure, relationships, and cardinalities of the class hierarchy.

---

### 4. Java Collections
Using your words, explain the structural and Java implementation differences between the Java Collections Stack and Queue. I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

#### Answer:
Stack is a legacy LIFO class that extends Vector, so push/pop/peek operate on the synchronized top element inherited from Vector. Queue is a FIFO interface in `java.util`, typically implemented by LinkedList, PriorityQueue, or ArrayDeque, exposing offer/poll/peek while letting each class decide on synchronization. Because Stack carries Vector’s synchronization overhead, it is slower and less flexible than most queue/deque implementations. Modern Java therefore prefers Deque implementations such as ArrayDeque for both stack-like and queue-like usage instead of the old Stack class.

#### Reasoning:
Blends structural (class vs. interface), behavioral (LIFO vs. FIFO), and implementation (synchronization, modern Deque guidance) differences so the comparison reflects both classic definitions and current Java practice.

### 5. SDLC
Using your words, what is the advantage of having different teams to develop code and to test it? I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

#### Answer:
Separating development and testing teams provides independent validation, reducing confirmation bias where developers might overlook their own mistakes. Testers bring a fresh perspective focused on breaking the code and uncovering edge cases that developers may not anticipate. This division of responsibilities ensures higher quality assurance, clearer accountability, and better adherence to requirements. It also allows each team to specialize - developers optimize for implementation efficiency, while testers focus on coverage, usability, and defect detection - ultimately delivering more robust and reliable software.

#### Reasoning:
Highlights the key SDLC benefits: objectivity, specialization, and quality improvement through independent verification, aligning with course discussions on testing phases and team roles.

---

### 6. Version Control
How can we recreate a reusing environment for a Python program that needs packages numpy version 1.18.5 and xlwt version 1.3.0 for running your own code? What command line command is necessary? Do you need additional files? Do you need to make changes in the .py files? I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

#### Answer:
To recreate a reusable environment, use a virtual environment and a `requirements.txt` file. First, create and activate the environment. Then, install the packages and save them to a file:
```bash
python -m venv venv
source venv/bin/activate  # for macOS/Linux; on Windows: venv\Scripts\activate
pip install numpy==1.18.5 xlwt==1.3.0
pip freeze > requirements.txt
```
This creates a `requirements.txt` file, which is the additional file needed. Others can then perfectly recreate the environment by running `pip install -r requirements.txt`. No changes are needed in the `.py` files themselves.

#### Reasoning:
This approach follows best practices by isolating dependencies in a virtual environment and automating the creation of a `requirements.txt` file with `pip freeze`. It directly answers all parts of the question: the necessary commands, the need for an additional file (`requirements.txt`), and confirms no changes are required in the Python source files.

---

### 7. Profiling
Considering the code below and the obtained output, which function would you consider optimizing? Explain your choice. I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

**Note:** See image in `final-exam-questions.pdf` page 8 for code and profiling output.

#### Answer:
The function that should be optimized is `check(mat)`. Profiling shows it dominates execution time, being called tens of millions of times and accounting for the largest share of total runtime. This function performs nested loops over the matrix, giving it O(n^2) complexity per call, and it is invoked repeatedly within `layer()`. The inner loops count occurrences of 0s and 1s, then check balance conditions—calculations that could potentially be memoized or restructured to avoid redundant matrix scans. Optimizing this part (e.g., precomputing partial sums, caching results, or using vectorized operations) would significantly reduce total execution time.

#### Reasoning:
Profiling data directly identifies `check()` as the bottleneck with the highest total time and call count. Its nested structure and frequent invocation make it the primary optimization target, aligning with profiling best practices of addressing functions that dominate execution time.

---

### 8. SDM
Which among the methodologies Agile, Lean, and DevOps is more similar (or less different) to the Waterfall methodology? Explain your choice. I suggest you limit your answer to no less than 2 lines and to no more than 10 lines (soft limits).

#### Answer:
Lean is most similar to Waterfall: both can operate as structured, phase‑oriented flows, and Lean optimizes that flow (waste reduction, value‑stream discipline) without requiring short iterations or CI/CD. Agile and DevOps explicitly break phase gates via iteration and continuous delivery. A fair alternate lens says Agile “looks” similar because each sprint contains plan‑build‑test mini‑cycles, but that’s procedural resemblance; structurally Agile rejects linear phases — hence Lean remains closer.

#### Reasoning:
This balances clarity and nuance: it states the structural alignment (phase‑oriented flow), contrasts Agile/DevOps mechanisms (iteration, CI/CD), and acknowledges the valid “mini‑waterfall” viewpoint while justifying why Lean is still the closest to Waterfall.

--- 

