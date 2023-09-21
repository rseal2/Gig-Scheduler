package edu.unl.raikes.gigscheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Accessors.BandAccessor;
import Accessors.GigAccessor;
import Accessors.IBandAccessor;
import Accessors.IGigAccessor;
import Accessors.IRelationshipAccessor;
import Accessors.RelationshipAccessor;
import Mock.IConsoleOutput;
import Mock.IUserInput;
import Mock.Output;
import Mock.UserInput;

/**
 * The main class for the gig scheduler, including the main method.
 */
public class GigSchedulerRunner {

    public IGigAccessor gigAcc;
    public IBandAccessor bandAcc;
    public IRelationshipAccessor relationAcc;
    // these numbers are used for the options
    public final int THREE = 3;
    public final int FOUR = 4;
    public final int FIVE = 5;

    IConsoleOutput output;
    IUserInput scnr;

    /**
     * Constructor for the Gig Scheduler Runner class.
     * 
     * @param scnr is a IUserInput interface.
     * @param output is a IConsoleOutput interface.
     */
    public GigSchedulerRunner(IUserInput scnr, IConsoleOutput output, IGigAccessor gigAcc, IBandAccessor bandAcc,
            IRelationshipAccessor relationAcc) {
        this.scnr = scnr;
        this.output = output;
        this.gigAcc = gigAcc;
        this.bandAcc = bandAcc;
        this.relationAcc = relationAcc;
    }

    /**
     * This function prompts the user for the bands that will be associated with the gig they create.
     */
    public Relationship associateBandsToGigs(Gig gig) {
        Relationship r = null;
        this.output.println("You've just created a new gig. What bands do you want to play at this gig?");
        String check = "2";
        int checkInt = Integer.parseInt(check);
        // calling createBandFromInput() several times until the user is done creating bands
        while (checkInt != 1) {
            Band band = this.createBandFromInput();
            // prompting user to determine if the band is a headliner
            this.output.println("Is this band a headliner? Please enter 'y' for yes and 'n' for no.");
            String choice = this.scnr.nextLine();
            int headliner = 1;
            if (choice.equals("y")) {
                headliner = 1;
            } else {
                headliner = 0;
            }
            // checking to see if the user is done creating bands
            this.output.println("Are you done creating bands? Please enter 'y' for yes and 'n' for no.");
            choice = this.scnr.nextLine();
            if (choice.equals("y")) {
                checkInt = 1;
            } else {
                checkInt = 2;
            }
            InputValidation.testUserInputForAssociateBandToGigs(this.scnr, this.output, check);
            r = new Relationship(gig, band, headliner);
            r = this.relationAcc.saveRelationship(r);
        }
        return r;
    }

    /**
     * Creating a band from user input.
     * 
     * @return a band with all the characteristics that the user inputs.
     */
    public Band createBandFromInput() {
        // if it returns null that means the band doesn't exist and you can prompt for the rest of the info
        // otherwise just immediately return the band that was already there
        this.output.println(
                "Please enter the information you are prompted for to get/make a band. If the band already exists, "
                        + "the information for it will be retrieved.");
        this.output.println("Enter a unique name for your band ");
        String uniqueName = this.scnr.nextLine();
        InputValidation.testBandUniqueName(this.scnr, this.output, uniqueName);
        // call the get band by name function here
        Band b = this.bandAcc.getBandByName(uniqueName);
        if (b != null) {
            this.output.println("That band already exists!");
            return b;
        }
        this.output.println("Enter the hometown from which your band is from ");
        String hometown = this.scnr.nextLine();
        InputValidation.testBandHometown(this.scnr, this.output, hometown);

        this.output.println(
                "Enter the web URL for the website of your band. Press enter if you do not want to have a web URL ");
        String webURL = this.scnr.nextLine();
        InputValidation.testBandWebURL(this.scnr, this.output, webURL);

        this.output.println(
                "Enter the image URL for the image of your band. Press enter if you do not want to have an image URL ");
        String imageURL = this.scnr.nextLine();
        InputValidation.testBandImageURL(this.scnr, this.output, imageURL);

        Band band = new Band(uniqueName, hometown, webURL, imageURL);
        band = this.bandAcc.saveBand(band);

        return band;
    }

    /**
     * Creating a gig from user input.
     * 
     * @return a gig with all the characteristics that the user inputs.
     */
    public Gig createGigFromInput() {
        this.output.println("Please enter the information you are prompted for to create a new gig.");

        this.output.println("Enter the name of your gig");
        String name = this.scnr.nextLine();
        InputValidation.testGigName(this.scnr, this.output, name);

        this.output.println("Enter the date and time for your gig in the form yyyy-mm-dd hh:mm:ss."
                + " Enter your time in military time");
        String datetime = this.scnr.nextLine();
        InputValidation.testGigDateTime(this.scnr, this.output, datetime);

        this.output.println("Enter the description for your gig ");
        String description = this.scnr.nextLine();
        InputValidation.testGigDescription(this.scnr, this.output, description);

        this.output.println("Enter the ticket cost to attend your gig ");
        String ticketCost = this.scnr.nextLine();
        int ticketNum = Integer.parseInt(ticketCost);

        this.output.println("Enter the link to your gig's website. Press enter if you do not want to have a web URL ");
        String link = this.scnr.nextLine();
        InputValidation.testGigLink(this.scnr, this.output, link);

        this.output.println("Enter any additional notes you have about your gig ");
        String notes = this.scnr.nextLine();
        InputValidation.testGigNotes(this.scnr, this.output, notes);

        int primaryKey = 1;

        Gig gig = new Gig(name, datetime, description, ticketNum, link, notes, primaryKey);
        gig = this.gigAcc.saveGig(gig);

        return gig;
    }

    /**
     * Displaying all of the gigs in order given a start and end date.
     * 
     * @param startTime is the start date.
     * @param endTime is the end date.
     */
    public void displayAllGigs(String startTime, String endTime) {
        this.output.println("Here are the ordered gigs: ");
        ArrayList<Gig> orderedGigs = this.gigAcc.returnOrderedGigs(startTime, endTime);

        for (int i = 0; i < orderedGigs.size(); i++) {
            this.output.println(orderedGigs.get(i).toString());
            this.output.println("");
            this.bandAcc.getBandsByGigID(orderedGigs.get(i).getprimaryKey());
        }
    }

    /**
     * Reads and returns all contents of a file.
     * 
     * @param filepath the filepath (including the filename) of the file to read
     * @return a string containing all contents of the file
     */
    public void readFile() {
        // read the file, loop through contents, append to one big string
        Scanner input = null;
        try {
            // file path
            input = new Scanner(new File("./HelpMenu.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder fileString = new StringBuilder();
        // reading and outputting the contents of the file
        while (input.hasNextLine()) {
            fileString.append(input.nextLine());
            fileString.append("\n");
        }
        input.close();
        this.output.println(fileString.toString());
    }

    /**
     * Getting all the gigs from a specific start date and time to print.
     * 
     * @param scnr is a Scanner for user input.
     */
    public void getAllGigsOutput() {
        this.output.println("Choose a start date and an end date for all of the gigs you want to see. "
                + "Enter your dates in the format yyyy-mm-dd hh:mm:ss.");
        this.output.println("If you do not want to enter a specific start or end date, press enter.");
        this.output.println("Pick a start date.");
        String start = this.scnr.nextLine();
        if (start.equals("")) {
            start = "0000-01-01 00:00:00";
        }
        InputValidation.testGigDateTime(this.scnr, this.output, start);
        this.output.println("Pick an end date.");
        String end = this.scnr.nextLine();
        if (end.equals("")) {
            end = "9999-12-12 12:59:59";
        }
        InputValidation.testGigDateTime(this.scnr, this.output, end);
        this.displayAllGigs(start, end);
    }

    /**
     * Main output function.
     */
    public void mainOutput() {
        this.output.println("Hello! Welcome to Gig Scheduler. What would you like to do today?");
        this.output.println("Option 1: Add a new Gig. Please enter 1 for this option. ");
        this.output.println("Option 2: Add a new Band. Please enter 2 for this option. ");
        this.output.println("Option 3: View a schedule. Please enter 3 for this option. ");
        this.output.println("Option 4: View the help menu. Please enter 4 for this option. ");
        this.output.println("Option 5: Quit the application. Please enter 5 for this option. ");

        String choice = this.scnr.nextLine();
        int choiceInt = Integer.parseInt(choice);
        InputValidation.testUserInputForMain(this.scnr, this.output, choice);

        // this accounts for if the user chooses to exit the program as their first choice
        if (choiceInt == this.FIVE) {
            this.output.println("Thanks for using Gig Scheduler!");
            System.exit(0);
        }
        // this accounts for all of the other choices/combinations
        while (choiceInt != this.FIVE) {
            if (choiceInt == 1) {
                // if user wants to add a new gig
                Gig gig = this.createGigFromInput();
                this.associateBandsToGigs(gig);
            } else if (choiceInt == 2) {
                // if the user wants to add a new band
                this.createBandFromInput();
            } else if (choiceInt == this.THREE) {
                // if user wants to view a schedule
                this.getAllGigsOutput();
            } else if (choiceInt == this.FOUR) {
                // if user wants to view the help menu
                this.readFile();
            } else if (choiceInt == this.FIVE) {
                // if user wants to exit the system
                this.output.println("Thanks for using Gig Scheduler!");
                System.exit(0);
            }
            this.output.println("What else would you like to with Gig Scheduler?");
            choice = this.scnr.nextLine();
            choiceInt = Integer.parseInt(choice);
            InputValidation.testUserInputForMain(this.scnr, this.output, choice);
        }
    }

    /**
     * Main method for the gig scheduler runner class. Accepts no unique arguments.
     */
    public static void main(String[] args) {
        GigSchedulerRunner g = new GigSchedulerRunner(new UserInput(), new Output(), new GigAccessor(),
                new BandAccessor(), new RelationshipAccessor());
        g.mainOutput();
    }
}
