package Mock;

import java.util.Scanner;

/**
 * UserInput mocking class that implements the IUserInput interface.
 */
public class UserInput implements IUserInput {
    Scanner scnr;

    /**
     * UserInput constructor.
     */
    public UserInput() {
        this.scnr = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return this.scnr.nextLine();
    }
}
