package Mock;

/**
 * Input mocking class that implements the IUserInput mock interface.
 */
public class InputMock implements IUserInput {
    String[] input;
    int count;

    /**
     * Input Mock function that takes in a string array of inputs.
     * @param input is the string array of inputs.
     */
    public InputMock(String[] input) {
        this.input = input;
        this.count = 0;
    }

    @Override
    public String nextLine() {
        return this.input[this.count++];
    }

}
