# NumberSorter - A Java Program for Sorting Integers

This Java program reads integers from standard input, pushes them onto a `Stack<Integer>`, sorts the stack using Java's built-in sorting capabilities, and then displays the results. It demonstrates code reuse in the Collections Framework by leveraging the `Stack` class together with the `Collections.sort()` method and other utility features.

## Design Overview

- `NumberSorter.main()` creates a single instance and delegates to `run()`.
- `run()` orchestrates the three phases: read input, sort the stack, and display the output.
- `readNumbers()` pushes each valid integer onto a stack via `Stack.push()` while the scanner handles tokenization and validation.
- `sortNumbers()` relies on `Collections.sort()` to reorder the stack in-place (backed by `Vector`) using Java's TimSort implementation.
- `displayResults()` prints both the ascending order and a simulated LIFO pop sequence to illustrate how stack semantics look after sorting.

```mermaid
flowchart TD
	A[User Input (Scanner)] --> B[Stack.push]
	B --> C[Collections.sort]
	C --> D[displayResults - Ascending List]
	C --> E[displayResults - Stack Pop View]
```

> Tip: Because `Stack` extends `Vector`, sorting mutates the underlying collection directly. We clone the sorted stack before popping so the displayed ascending list remains intact.

## Folder Layout

```
Project5/
├─ project5/
│  └─ lacassea/
│     ├─ NumberSorter.java
│     └─ NumberSorter.class (after compilation)
└─ docs/ (generated after running the JavaDoc command)
```

## Compile and Run
From the `Project5` folder:

```bash
javac -d . project5/lacassea/NumberSorter.java
java project5.lacassea.NumberSorter
```
Then enter integers when prompted, one per line. To finish input, enter a non-integer value (e.g., `q`), or use Ctrl+D (Unix) / Ctrl+Z (Windows) to signal end-of-file (EOF). After sorting, the program shows both the ascending list and the stack's pop order to highlight Last In First Out (LIFO) behavior.

## JavaDocs
JavaDocs for the `NumberSorter` class can be generated using the following command:

```bash
javadoc -d docs -cp . project5.lacassea
```
This will create a `docs` directory containing the HTML documentation. Open `docs/index.html` in a web browser to view the documentation.
