package Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * Output Mock class that implements the IConsoleOutput interface.
 */
public class OutputMock implements IConsoleOutput {
    List<String> output;

    /**
     * OutputMock constructor that takes in a list of outputs.
     */
    public OutputMock() {
        this.output = new ArrayList<String>();
    }

    @Override
    public void print(String s) {
        this.output.add(s);
    }

    /**
     * List that gets the output from a program/function.
     * @return output.
     */
    public List<String> getOutput() {
        return this.output;
    }

    @Override
    public void println(String s) {
        this.output.add(s);
    }
}
