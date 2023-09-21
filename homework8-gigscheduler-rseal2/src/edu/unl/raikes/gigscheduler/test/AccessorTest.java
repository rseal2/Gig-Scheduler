package edu.unl.raikes.gigscheduler.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Accessors.GigAccessor;
import Accessors.IBandAccessor;
import Accessors.IGigAccessor;
import Accessors.IRelationshipAccessor;
import Mock.InputMock;
import Mock.MockBandAccessor;
import Mock.MockGigAccessor;
import Mock.MockRelationshipAccessor;
import Mock.OutputMock;
import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.Gig;
import edu.unl.raikes.gigscheduler.InputValidation;
import edu.unl.raikes.gigscheduler.Relationship;

public class AccessorTest {

    @Test
    public void testGetGigByID() {
        // setup
        IGigAccessor gigAcc = new MockGigAccessor();
        int expectedID = 2;

        // execute
        Gig g = gigAcc.getGigByID(expectedID);
        int actualID = g.getprimaryKey();

        // test
        assertEquals("the get gig by id is not retrieving the correct gig", expectedID, actualID);
    }

    @Test
    public void testSaveGig() {
        // setup
        IGigAccessor gigAcc = new MockGigAccessor();
        Gig expected = new Gig("coachella", "2022-08-30 10:10:00", "des", 10, "link", "notes", 0);

        // execute
        Gig actual = gigAcc.saveGig(expected);

        // test
        assertEquals("the save gig is not saving and returning the expected gig", expected, actual);
    }

    @Test
    public void testSaveGigWithOptionalLink() {
        // setup
        IGigAccessor gigAcc = new MockGigAccessor();
        Gig expected = new Gig("coachella", "2022-08-30 10:10:00", "des", 10, "", "notes", 0);

        // execute
        Gig actual = gigAcc.saveGig(expected);

        // test
        assertEquals("the save gig is not saving and returning the expected gig", expected, actual);
    }

    @Test
    public void testReturnOrderedGigs() {
        // setup
        IGigAccessor gigAcc = new MockGigAccessor();
        String startDate = "2021-10-10 10:10:10";
        String endDate = "2023-10-10 10:10:10";
        ArrayList<Gig> expected = new ArrayList<Gig>();
        Gig coachella = new Gig("coachella", "2023-04-19 21:30:00", "coachella is a super cool event", 1000,
                "www.coachella.com", "coachella is full of celebrities", 0);
        Gig lollapalooza = new Gig("lollapalooza", "2023-06-30 19:30:25",
                "lollapalooza is a cool music festival that is in chicago this year", 200, "www.lollapaloozalink.com",
                "lollapalooza is a multi-day event", 1);
        Gig test = new Gig("test", "2022-08-30 10:10:00", "des", 10, "link", "notes", 2);
        expected.add(test);
        expected.add(coachella);
        expected.add(lollapalooza);

        // execute
        ArrayList<Gig> actual = gigAcc.returnOrderedGigs(startDate, endDate);

        // test
        for (int i = 0; i < actual.size(); i++) {
            assertEquals("the return ordered gigs function is not outputting gigs in the correct order",
                    expected.get(i).toString(), actual.get(i).toString());
        }
    }

    @Test
    public void testReturnOrderedWithNoSpecificStartOrEndDate() {
        // setup
        IGigAccessor gigAcc = new MockGigAccessor();
        String startDate = "";
        String endDate = "";
        ArrayList<Gig> expected = new ArrayList<Gig>();
        Gig coachella = new Gig("coachella", "2023-04-19 21:30:00", "coachella is a super cool event", 1000,
                "www.coachella.com", "coachella is full of celebrities", 0);
        Gig lollapalooza = new Gig("lollapalooza", "2023-06-30 19:30:25",
                "lollapalooza is a cool music festival that is in chicago this year", 200, "www.lollapaloozalink.com",
                "lollapalooza is a multi-day event", 1);
        Gig test = new Gig("test", "2022-08-30 10:10:00", "des", 10, "link", "notes", 2);
        expected.add(test);
        expected.add(coachella);
        expected.add(lollapalooza);

        // execute
        ArrayList<Gig> actual = gigAcc.returnOrderedGigs(startDate, endDate);

        // test
        for (int i = 0; i < actual.size(); i++) {
            assertEquals("the return ordered gigs function is not outputting gigs in the correct order",
                    expected.get(i).toString(), actual.get(i).toString());
        }
    }

    @Test
    public void testGetBandByName() {
        // setup
        IBandAccessor bandAcc = new MockBandAccessor();
        String expectedName = "cowie moo moo";

        // execute
        Band b = bandAcc.getBandByName(expectedName);
        String actualName = b.getuniqueName();

        // test
        assertEquals("the get band by name is not retrieving the band as expected", expectedName, actualName);
    }

    @Test
    public void testSaveBand() {
        // setup
        IBandAccessor bandAcc = new MockBandAccessor();
        Band expected = new Band("chaita's band", "garmin", "www.capitalone.com", "image two");

        // execute
        Band actual = bandAcc.saveBand(expected);

        // test
        assertEquals("the save band is not saving and returning the expected band", expected, actual);
    }

    @Test
    public void testSaveBandWithOptionalWebUrl() {
        // setup
        IBandAccessor bandAcc = new MockBandAccessor();
        Band expected = new Band("chaita's band", "garmin", "", "image two");

        // execute
        Band actual = bandAcc.saveBand(expected);

        // test
        assertEquals("the save band is not saving and returning the expected band", expected, actual);
    }

    @Test
    public void testSaveBandWithOptionalImageUrl() {
        // setup
        IBandAccessor bandAcc = new MockBandAccessor();
        Band expected = new Band("chaita's band", "garmin", "www.capitalone.com", "");

        // execute
        Band actual = bandAcc.saveBand(expected);

        // test
        assertEquals("the save band is not saving and returning the expected band", expected, actual);
    }

    @Test
    public void testSaveBandWithOptionalUrls() {
        // setup
        IBandAccessor bandAcc = new MockBandAccessor();
        Band expected = new Band("chaita's band", "garmin", "", "");

        // execute
        Band actual = bandAcc.saveBand(expected);

        // test
        assertEquals("the save band is not saving and returning the expected band", expected, actual);
    }

    @Test
    public void testGetBandsByGigID() {
        // setup
        IBandAccessor bandAcc = new MockBandAccessor();
        Gig coachella = new Gig("coachella", "2023-04-19 21:30:00", "coachella is a super cool event", 1000,
                "www.coachella.com", "coachella is full of celebrities", 1);
        int gigID = coachella.getprimaryKey();
        Band expected = new Band("raimee's band", "omaha", "www.raimeeseal.com", "image", 1);

        // execute
        Band actual = bandAcc.getBandsByGigID(gigID);

        // test
        assertEquals("the function is not retrieving the bands associated with the gigs", expected.toString(),
                actual.toString());
    }

    @Test
    public void testSaveRelationshipWhenOptionalItemsAreGiven() {
        // setup
        IRelationshipAccessor relationAcc = new MockRelationshipAccessor();
        Gig g = new Gig("test gig with one band", "2024-10-10 10:00:00", "test gig", 10, "link", "notes", 32);
        Band b = new Band("test band", "hometown", "web url", "image url");
        Relationship expected = new Relationship(g, b, 0, 27);

        // execute
        Relationship actual = relationAcc.saveRelationship(expected);

        // test
        assertEquals("the save relationship function is not saving the relationship as expected", expected, actual);
    }

    @Test
    public void testSaveRelationshipWhenOptionalItemsAreNotGiven() {
        // setup
        IRelationshipAccessor relationAcc = new MockRelationshipAccessor();
        Gig g = new Gig("test gig with one band", "2024-10-10 10:00:00", "test gig", 10, "", "notes", 32);
        Band b = new Band("test band", "hometown", "", "");
        Relationship expected = new Relationship(g, b, 0, 27);

        // execute
        Relationship actual = relationAcc.saveRelationship(expected);

        // test
        assertEquals("the save relationship function is not saving the relationship as expected", expected, actual);
    }

    @Test
    public void testGetRelationshipByGigID() {
        // setup
        IRelationshipAccessor relationAcc = new MockRelationshipAccessor();
        Gig coachella = new Gig("coachella", "2023-04-19 21:30:00", "coachella is a super cool event", 1000,
                "www.coachella.com", "coachella is full of celebrities", 1);
        Band raimee = new Band("raimee's band", "omaha", "www.raimeeseal.com", "image", 1);
        ArrayList<Relationship> expected = new ArrayList<Relationship>();
        Relationship r = new Relationship(coachella, raimee, 0, 1);
        expected.add(r);

        // execute
        ArrayList<Relationship> actual = relationAcc.getRelationshipByGigID(coachella.getprimaryKey());

        // test
        for (int i = 0; i < actual.size(); i++) {
            assertEquals("the relationships are not being retrieved properly", expected.get(i).toString(),
                    actual.get(i).toString());
        }
    }

}
