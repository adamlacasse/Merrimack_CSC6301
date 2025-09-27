# NumberSorter - A Java Program for Sorting Integers

This Java program reads a list of integers from a file, sorts them using Java's built-in sorting capabilities, and writes the sorted list to an output file. It demonstrates code reuse by leveraging the `Collections.sort()` method from the Java Standard Library.

## Compile and Run
To compile and run the program, use the following commands in your terminal from the `Project4` directory:

```bash
javac lacassea/NumberSorter.java
java -cp .. Project4.lacassea.NumberSorter
```
Then enter integers when prompted, one per line. To finish input, enter a non-integer value (e.g., 'q'), or use Ctrl+D (Unix) or Ctrl+Z (Windows) to signal end-of-file.

## JavaDocs
JavaDocs for the `NumberSorter` class can be generated using the following command:

```bash
javadoc -d docs -cp .. Project4.lacassea
```
This will create a `docs` directory containing the HTML documentation. Open `Project4/docs/index.html` in a web browser to view the documentation.
