package edu.unl.raikes.gigscheduler;

import Mock.IConsoleOutput;
import Mock.IUserInput;

/**
 * Input validation class to make sure that user inputs meet the requirements of the program.
 *
 */
public class InputValidation {
    final static int FIFTY = 50;
    final static int FIVE_HUNDRED = 500;
    final static int ONE_HUNDRED = 100;
    final static int ONE_THOUSAND = 1000;
    final static int MAX_TICKET_COST = 3000;
    // these are all ints used to test the datetime
    final static int FOUR = 4;
    final static int FIVE = 5;;
    final static int SEVEN = 7;
    final static int TEN = 10;
    final static int THIRTEEN = 13;
    final static int SIXTEEN = 16;
    final static int NINETEEN = 19;

    /**
     * Testing to see if the band's name is at most 50 characters.
     * 
     * @param uniqueName is the name to test.
     * @return a valid uniqueName.
     */
    public static String testBandUniqueName(IUserInput scnr, IConsoleOutput output, String uniqueName) {
        while (uniqueName.length() > FIFTY) {
            output.print("Please enter an unique name that is at most 50 characters.");
            uniqueName = scnr.nextLine();
        }
        return uniqueName;
    }

    /**
     * Testing to see if the band's home town is at most 500 characters.
     * 
     * @param hometown is the home town to test.
     * @return a valid home town.
     */
    public static String testBandHometown(IUserInput scnr, IConsoleOutput output, String hometown) {
        while (hometown.length() > FIFTY) {
            output.print("Please enter a hometown that is at most 50 characters.");
            hometown = scnr.nextLine();
        }
        return hometown;
    }

    /**
     * Testing to see if the band's webURL is at most 500 characters.
     * 
     * @param webURL is the webURL to test.
     * @return a valid webURL.
     */
    public static String testBandWebURL(IUserInput scnr, IConsoleOutput output, String webURL) {
        while (webURL.length() > FIVE_HUNDRED) {
            output.print("Please enter a web url that is at most 500 characters.");
            webURL = scnr.nextLine();
        }
        return webURL;
    }

    /**
     * Testing to see if the band's imageURL is at most 500 characters.
     * 
     * @param webURL is the imageURL to test.
     * @return a valid imageURL.
     */
    public static String testBandImageURL(IUserInput scnr, IConsoleOutput output, String imageURL) {
        while (imageURL.length() > FIVE_HUNDRED) {
            output.print("Please enter an image url that is at most 500 characters.");
            imageURL = scnr.nextLine();
        }
        return imageURL;
    }

    /**
     * Testing to see if a gig's name is at most 100 characters.
     * 
     * @param name is the name to test.
     * @return a valid gig name.
     */
    public static String testGigName(IUserInput scnr, IConsoleOutput output, String name) {
        while (name.length() > ONE_HUNDRED) {
            output.print("Please enter a name that is at most 100 characters.");
            name = scnr.nextLine();
        }
        return name;
    }

    /**
     * Testing to see if the date and time are in the format yyyy-mm-dd 00:00:00.
     * 
     * @param datetime is the date and time to test.
     * @return a valid date and time in the form date time.
     */
    public static String testGigDateTime(IUserInput scnr, IConsoleOutput output, String datetime) {
        while (((datetime.charAt(FOUR) != '-') || (datetime.charAt(SEVEN) != '-') || (datetime.charAt(TEN) != ' ')
                || (datetime.charAt(THIRTEEN) != ':') || (datetime.charAt(SIXTEEN) != ':')
                || (datetime.length() != NINETEEN))) {
            output.print("Please enter a valid date that follows the format yyyy-mm-dd hh:mm:ss");
            datetime = scnr.nextLine();
        }
        return datetime;
    }

    /**
     * Testing to see if a gig's description is at most 1000 characters.
     * 
     * @param description is the description to test.
     * @return a valid description.
     */
    public static String testGigDescription(IUserInput scnr, IConsoleOutput output, String description) {
        while (description.length() > ONE_THOUSAND) {
            output.print("Please enter a description that is at most 1000 characters.");
            description = scnr.nextLine();
        }
        return description;
    }

    /**
     * Testing to see if a gig's ticket cost is reasonable (at most $3000).
     * 
     * @param ticketCost is a ticket cost to test.
     * @return a valid ticket cost.
     */
    public static Integer testGigTicketCost(IUserInput scnr, IConsoleOutput output, String ticketCost) {
        int ticketInt = Integer.parseInt(ticketCost);
        while (!(ticketInt <= MAX_TICKET_COST)) {
            output.print("You can't charge that much for your tickets! Enter a ticket "
                    + "cost that is less than or equal to $3000.");
            ticketCost = scnr.nextLine();
            ticketInt = Integer.parseInt(ticketCost);
        }
        return ticketInt;
    }

    /**
     * Testing to see if a gig's link is at most 100 characters.
     * 
     * @param link is the link to test.
     * @return a valid link.
     */
    public static String testGigLink(IUserInput scnr, IConsoleOutput output, String link) {
        while (link.length() > ONE_HUNDRED) {
            output.print("Please enter a link that is at most 100 characters.");
            link = scnr.nextLine();
        }
        return link;
    }

    /**
     * Testing to see if a gig's notes are at most 500 characters.
     * 
     * @param notes are the notes to test.
     * @return valid notes.
     */
    public static String testGigNotes(IUserInput scnr, IConsoleOutput output, String notes) {
        while (notes.length() > FIVE_HUNDRED) {
            output.print("Please enter notes that are at most 500 characters.");
            notes = scnr.nextLine();
        }
        return notes;
    }

    /**
     * Testing to see if a user's choice is valid.
     * 
     * @param choice is the number for the choice the user picks.
     * @return a valid choice int.
     */
    public static int testUserInputForMain(IUserInput scnr, IConsoleOutput output, String choice) {
        int choiceInt = Integer.parseInt(choice);
        while (choiceInt > FIVE || choiceInt < 0) {
            output.println("Please enter a valid option from the ones listed above. Your input should be a number 1-5");
            choice = scnr.nextLine();
            choiceInt = Integer.parseInt(choice);
        }
        return choiceInt;
    }

    /**
     * Testing to see if the user's choice input is correct for the associateBandToGigs function. A valid input is
     * either the number 1 or 2.
     * 
     * @param int choice is the number that the user selects to make bands/select headliner.
     * @return a valid choice int.
     */
    public static int testUserInputForAssociateBandToGigs(IUserInput scnr, IConsoleOutput output, String choice) {
        int choiceInt = Integer.parseInt(choice);
        while (choiceInt > 2 || choiceInt < 1) {
            output.println("Please enter a valid option from the ones listed above. Your input should be a 1 or a 2");
            choice = scnr.nextLine();
            choiceInt = Integer.parseInt(choice);
        }
        return choiceInt;
    }
}
