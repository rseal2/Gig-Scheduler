package Mock;

/**
 * Mock console output.
 */
public interface IConsoleOutput {
    /**
     * print replacement function for console output.
     * @param s is the string to replace.
     */
    void print(String s);

    /**
     * println replacement function for the console output.
     * @param s is the string to replace.
     */
    void println(String s);
}
