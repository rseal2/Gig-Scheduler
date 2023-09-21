package Mock;

/**
 * Output class that implements the IConsoleOutput.
 */
public class Output implements IConsoleOutput {

    /**
     * Constructor for the output.
     */
    public Output() {

    }

    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }

}
