package Mock;

import java.util.ArrayList;

import Accessors.IGigAccessor;
import edu.unl.raikes.gigscheduler.Gig;

/**
 * Mock Gig Accessor that implements the IGigAccessor interface.
 */
public class MockGigAccessor implements IGigAccessor {
    final int THREE = 3; 
    Gig coachella = new Gig("coachella", "2023-04-19 21:30:00", "coachella is a super cool event", 1000,
            "www.coachella.com", "coachella is full of celebrities", 1);
    Gig lollapalooza = new Gig("lollapalooza", "2023-06-30 19:30:25",
            "lollapalooza is a cool music festival that is in chicago this year", 200, "www.lollapaloozalink.com",
            "lollapalooza is a multi-day event", 2);
    Gig musicfestival = new Gig("music festival", "2021-02-15 20:22:22", "this is a music festival gig", 250,
            "www.musicfestivallink.com", "this is a super cool music festival", 3);
    Gig superfungig = new Gig("super fun gig", "2004-08-30 19:30:25",
            "this is a super fun gig that happened on my birthday", 10, "www.raimeesbirthdaygig.com",
            "this is a super fun gig that happened on my birthday because my birthday is super fun", 4);
    Gig superduperfunmusicfestival = new Gig("super duper fun music festival", "2020-08-19 21:30:30",
            "this is a super fun music festival", 150, "www.linktosuperduperfunmusicfestival.com",
            "this is the last gig and it is super duper fun", 5);
    Gig testgigwithoneband = new Gig("test gig with one band", "2024-10-10 10:00:00", "test gig", 10, "", "notes", 32);
    ArrayList<Gig> gigList = new ArrayList<Gig>();

    /**
     * Mock Gig Accessor constructor.
     */
    public MockGigAccessor() {
        this.gigList.add(this.coachella);
        this.gigList.add(this.musicfestival);
        this.gigList.add(this.superduperfunmusicfestival);
        this.gigList.add(this.superfungig);
        this.gigList.add(this.testgigwithoneband);
        this.gigList.add(this.lollapalooza);
    }

    @Override
    public Gig getGigByID(int id) {
        for (int i = 0; i < this.gigList.size(); i++) {
            if (this.gigList.get(i).getprimaryKey() == id) {
                return this.gigList.get(i);
            }
        }
        return null;
    }

    @Override
    public Gig saveGig(Gig gig) {
        return gig;
    }

    @Override
    public ArrayList<Gig> returnOrderedGigs(String startDate, String endDate) {
        if (startDate.equals("")) {
            startDate = "0000";
        }
        if (endDate.equals("")) {
            endDate = "9999";
        }
        int startD = Integer.parseInt(startDate.substring(0, this.THREE));
        int endD = Integer.parseInt(startDate.substring(0, this.THREE));

        ArrayList<Gig> toReturn = new ArrayList<Gig>();
        for (int i = 0; i < this.gigList.size(); i++) {
            if (Integer.parseInt(this.gigList.get(i).getDatetime().substring(0, 3)) > startD
                    && Integer.parseInt(this.gigList.get(i).getDatetime().substring(0, 3)) < endD) {
                toReturn.add(this.gigList.get(i));
            }
        }
        return toReturn;
    }

}
