package edu.unl.raikes.gigscheduler.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Mock.InputMock;
import Mock.OutputMock;
import edu.unl.raikes.gigscheduler.InputValidation;

public class InputValidationTest {

    @Test
    public void testBandUniqueName() {
        // setup
        String fail = "Failure happens. Learn from it. Embrace change, aim to adapt, and "
                + "have the courage and positivity to continue. "
                + "raikesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter an unique name that is at most 50 characters.");

        // execute
        InputValidation.testBandUniqueName(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("band unique name is not valid", expected, actual);
    }

    @Test
    public void testBandHometown() {
        // setup
        String fail = "Failure happens. Learn from it. Embrace change, aim to adapt, and "
                + "have the courage and positivity to continue. "
                + "raikesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a hometown that is at most 50 characters.");

        // execute
        InputValidation.testBandHometown(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("band hometown is not valid", expected, actual);
    }

    @Test
    public void testBandWebURL() {
        // setup
        String fail = "Failure happens. Learn from it. Embrace change, aim to adapt, and "
                + "have the courage and positivity to continue. " + "raikesssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssss" + "ssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssss" + "ssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssss" + "ssssssssssssssssssssssssssssssssssssssssssssss"
                + "sssssssssssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a web url that is at most 500 characters.");

        // execute
        InputValidation.testBandWebURL(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("band web url is not valid", expected, actual);
    }

    @Test
    public void testBandImageURL() {
        // setup
        String fail = "Failure happens. Learn from it. Embrace change, aim to adapt, and "
                + "have the courage and positivity to continue. " + "raikesssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssss" + "ssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssss" + "ssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssss" + "ssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssssssssss"
                + "sssssssssssssssssssssssssssssssssssssssssssssssssss"
                + "ssssssssssssssssssssssssssssssssssssssssssss";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter an image url that is at most 500 characters.");

        // execute
        InputValidation.testBandImageURL(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("band image url is not valid", expected, actual);
    }

    @Test
    public void testGigName() {
        // setup
        String fail = "Failure happens. Learn from it. Embrace change, aim to adapt, and "
                + "have the courage and positivity to continue. "
                + "raikesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a name that is at most 100 characters.");

        // execute
        InputValidation.testGigName(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig name is not valid", expected, actual);
    }

    @Test
    public void testGigDateTime() {
        // setup
        String fail = "2002-12:30   12:00:00";
        String[] arr = { "2004-08-30 10:00:00" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a valid date that follows the format yyyy-mm-dd hh:mm:ss");

        // execute
        InputValidation.testGigDateTime(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig datetime is not valid", expected, actual);
    }

    @Test
    public void testGigDateTimeWithLetters() {
        // setup
        String fail = "sssssssssssss";
        String[] arr = { "2004-08-30 10:00:00" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a valid date that follows the format yyyy-mm-dd hh:mm:ss");

        // execute
        InputValidation.testGigDateTime(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig datetime is not valid", expected, actual);
    }

    @Test
    public void testGigDescription() {
        // setup
        String fail = "The world is a complex and fascinating place, full of endless wonders and mysteries "
                + "waiting to be explored. "
                + "From the vastness of outer space to the depths of the ocean, there is always some"
                + "thing new and exciting to discover. "
                + "But at the same time, the world can also be a challenging and difficult place, wi"
                + "th problems and obstacles that we must "
                + "overcome. Whether it's climate change, poverty, or inequality, there are many "
                + "issues facing our world today that require "
                + "urgent attention and action. It's up to each and every one of us to do our part a"
                + "nd work towards a better future "
                + "for ourselves and for future generations. By coming together and using our coll"
                + "ective knowledge and resources, we "
                + "can overcome even the greatest challenges and create a world that is more peacefu"
                + "l, just, and sustainable for all. The world is a complex and fascinating place, ful"
                + "l of endless wonders and mysteries waiting to be ex"
                + "plored. From the vastness of outer space to t"
                + "he depths of the ocean, there is always something new a"
                + "nd exciting to discover. But at the same time, the world "
                + "can also be a challenging and difficult place, with problems a"
                + "nd obstacles that we must overcome. Whether it's climate change,"
                + " poverty, or inequality, there are many issues facing our world to"
                + "day that require urgent attention and action. It's up to each an"
                + "d every one of us to do our part and work towards a better fut"
                + "ure for ourselves and for future generations. By coming together and using our c"
                + "ollective knowledge and resources, we can overcome even the greatest challenges and "
                + "create a world that is more peaceful, just, and sustainable for all.\r\n" + "\r\n" + "\r\n" + "\r\n"
                + "\r\n" + "";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a description that is at most 1000 characters.");

        // execute
        InputValidation.testGigDescription(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig description is not valid", expected, actual);
    }

    @Test
    public void testGigTicketCost() {
        // setup
        String fail = "50000";
        String[] arr = { "3000" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("You can't charge that much for your tickets! Enter a ticket "
                + "cost that is less than or equal to $3000.");

        // execute
        InputValidation.testGigTicketCost(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig ticket cost is not valid", expected, actual);
    }

    @Test
    public void testGigTicketCostWith1PlusMaxNumber() {
        // setup
        String fail = "3001";
        String[] arr = { "3000" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("You can't charge that much for your tickets! Enter a ticket "
                + "cost that is less than or equal to $3000.");

        // execute
        InputValidation.testGigTicketCost(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig ticket cost is not valid", expected, actual);
    }

    @Test
    public void testGigLink() {
        // setup
        String fail = "Failure happens. Learn from it. Embrace change, aim to adapt, and "
                + "have the courage and positivity to continue. "
                + "raikesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a link that is at most 100 characters.");

        // execute
        InputValidation.testGigLink(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig link is not valid", expected, actual);
    }

    @Test
    public void testGigNotes() {
        // setup
        String fail = "Life is full of unexpected twists and turns. "
                + "Just when we think we have it all figured out, "
                + "something comes along to challenge us and push us "
                + "out of our comfort zones. But it's often these moments "
                + "of discomfort and uncertainty that lead to the greatest "
                + "growth and learning. Whether it's facing a difficult "
                + "decision, overcoming a personal obstacle, or navigating "
                + "a new and unfamiliar situation, we have the opportunity "
                + "to rise to the occasion and discover what we're truly "
                + "capable of. It may not always be easy, but by embracing "
                + "the challenges that come our way, we can unlock our full "
                + "potential and create a life that is rich, meaningful, and " + "fulfilling.";
        String[] arr = { "normal input" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter notes that are at most 500 characters.");

        // execute
        InputValidation.testGigNotes(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("gig notes are not valid", expected, actual);
    }

    @Test
    public void testUserInputForMain() {
        // setup
        String fail = "7";
        String[] arr = { "3" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a valid option from the ones listed above. Your input should be a number 1-5");

        // execute
        InputValidation.testUserInputForMain(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("user input for main is not valid", expected, actual);
    }

    @Test
    public void testUserInputForMainIfUserEntersANegativeNumber() {
        // setup
        String fail = "-5";
        String[] arr = { "3" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a valid option from the ones listed above. Your input should be a number 1-5");

        // execute
        InputValidation.testUserInputForMain(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("user input for main is not working as expected if user enters a negative number", expected,
                actual);
    }

    @Test
    public void testUserInputForAssociateBandToGigs() {
        // setup
        String fail = "5";
        String[] arr = { "1" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a valid option from the ones listed above. Your input should be a 1 or a 2");

        // execute
        InputValidation.testUserInputForAssociateBandToGigs(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals("user input for associate band to gigs is not valid", expected, actual);
    }

    @Test
    public void testUserInputForAssociateBandToGigsIfUserEntersANegativeNumber() {
        // setup
        String fail = "-5";
        String[] arr = { "1" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        List<String> expected = new ArrayList<String>();
        expected.add("Please enter a valid option from the ones listed above. Your input should be a 1 or a 2");

        // execute
        InputValidation.testUserInputForAssociateBandToGigs(input, output, fail);
        List<String> actual = output.getOutput();

        // test
        assertEquals(
                "user input for associate band to gigs is not working as expected if the user enters a negative number",
                expected, actual);
    }
}
