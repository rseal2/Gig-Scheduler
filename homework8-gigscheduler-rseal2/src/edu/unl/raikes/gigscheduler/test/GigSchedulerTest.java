package edu.unl.raikes.gigscheduler.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Mock.IConsoleOutput;
import Mock.IUserInput;
import Mock.InputMock;
import Mock.MockBandAccessor;
import Mock.MockGigAccessor;
import Mock.MockRelationshipAccessor;
import Mock.OutputMock;
import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.Gig;
import edu.unl.raikes.gigscheduler.GigSchedulerRunner;
import edu.unl.raikes.gigscheduler.Relationship;

public class GigSchedulerTest {

    @Test
    public void testCreateGigFromInputWithAllData() {
        // setup
        String[] arr = { "gigname", "2023-04-19 21:30:00", "description", "10", "link", "notes" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Gig expected = new Gig("gigname", "2023-04-19 21:30:00", "description", 10, "link", "notes", 0);

        // execute
        Gig actual = g.createGigFromInput();

        // test
        assertEquals("the gig is invalid when all of the data is being entered", expected, actual);
    }

    @Test
    // test gig from input when missing data
    public void testCreateGigFromInputWithMissingData() {
        // setup
        String[] arr = { "gigname", "2023-04-19 21:30:00", "description", "10", "", "notes" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Gig expected = new Gig("gigname", "2023-04-19 21:30:00", "description", 10, "", "notes", 0);

        // execute
        Gig actual = g.createGigFromInput();

        // test
        assertEquals("the gig is invalid when the optional link data is not entered", expected, actual);
    }

    @Test
    public void testCreateGigFromInputWhenDataIsNotGivenAsExpected() {
        // setup
        String[] arr = { "gigname", "2023-21-19 21:30:00", "description", "10", "link", "notes" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Gig expected = new Gig("gigname", "2023-21-19 21:30:00", "description", 10, "link", "notes", 0);

        // execute
        Gig actual = g.createGigFromInput();

        // test
        assertEquals("the gig is invalid when all of the data is being entered", expected, actual);
    }

    @Test
    public void testCreateBandFromInputWithAllData() {
        // setup
        String[] arr = { "bandtest", "hometown", "web url", "image url" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Band expected = new Band("bandtest", "hometown", "web url", "image url");

        // execute
        Band actual = g.createBandFromInput();

        // test
        assertEquals("the band is invalid when all of the data is being entered", expected.toString(),
                actual.toString());
    }

    @Test
    public void testCreateBandFromInputWithOptionalWebURL() {
        // setup
        String[] arr = { "bandtest", "hometown", "", "image url" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Band expected = new Band("bandtest", "hometown", "", "image url");

        // execute
        Band actual = g.createBandFromInput();

        // test
        assertEquals("the band is invalid when the web url is not being entered", expected.toString(),
                actual.toString());
    }

    @Test
    public void testCreateBandFromInputWithOptionalImageURL() {
        // setup
        String[] arr = { "bandtest", "hometown", "web url", "" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Band expected = new Band("bandtest", "hometown", "web url", "");

        // execute
        Band actual = g.createBandFromInput();

        // test
        assertEquals("the band is invalid when the image url is not being entered", expected.toString(),
                actual.toString());
    }

    @Test
    public void testCreateBandFromInputWithOptionalURLs() {
        // setup
        String[] arr = { "bandtest", "hometown", "", "" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Band expected = new Band("bandtest", "hometown", "", "");

        // execute
        Band actual = g.createBandFromInput();

        // test
        assertEquals("the band is invalid when the urls are not being entered", expected.toString(), actual.toString());
    }

    @Test
    public void testAssociateBandToGigs() {
        // setup
        String[] arr = { "raimee's band", "n", "y" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        Gig gig = new Gig("coachella", "2022-08-30 10:00:00", "description", 10, "link", "notes", 0);
        Band band = new Band("raimee's band", "omaha", "raimeeseal.com", "image", 0);
        Relationship expected = new Relationship(gig, band, 0, 1);

        // execute
        Relationship actual = g.associateBandsToGigs(gig);

        // test
        assertEquals("the band is invalid when the urls are not being entered", expected.toString(), actual.toString());
    }

    @Test
    public void testGetAllGigs() {
        // setup
        String[] arr = { "raimee's band", "n", "y" };
        InputMock input = new InputMock(arr);
        OutputMock output = new OutputMock();
        GigSchedulerRunner g = new GigSchedulerRunner(input, output, new MockGigAccessor(), new MockBandAccessor(),
                new MockRelationshipAccessor());
        List<String> expected = new ArrayList<String>();
        expected.add("Here are the ordered gigs: ");
        Gig superfungig = new Gig("super fun gig", "2004-08-30 19:30:25",
                "this is a super fun gig that happened on my birthday", 10, "www.raimeesbirthdaygig.com",
                "this is a super fun gig that happened on my birthday because my birthday is super fun", 4);
        expected.add(superfungig.toString());

        // execute
        g.displayAllGigs("2003-10-10 10:00:00", "2005-10-10 10:00:00");
        List<String> actual = expected;

        // test
        for (int i = 0; i < expected.size(); i++) {
            assertEquals("display all gigs is not working as expected", expected, actual);
        }
    }

}
