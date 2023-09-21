package Mock;

import java.util.ArrayList;
import java.util.List;

import Accessors.IBandAccessor;
import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.Gig;
import edu.unl.raikes.gigscheduler.Relationship;

/**
 * Mock Band Accessor that implements the IBandAccessor.
 */
public class MockBandAccessor implements IBandAccessor {
    Gig coachella = new Gig("coachella", "2023-04-19 21:30:00", "coachella is a super cool event", 1000,
            "www.coachella.com", "coachella is full of celebrities", 1);
    Band raimee = new Band("raimee's band", "omaha", "www.raimeeseal.com", "image", 1);
    Band chaitra = new Band("chaitra's band", "garmin", "www.capitalone.com", "image two", 2);
    Band coolband = new Band("cool band", "colorado", "", "", 3);
    Band cowiemoomoo = new Band("cowie moo moo", "iowa", "", "", 4);
    Band chicken = new Band("chicken", "nebraska", "www.chickeniscoolilikechicken.org", "", 5);
    Band aidrake = new Band("ai drake", "computer", "", "imageofdrake", 6);
    Band testband = new Band("test band", "hometown", "", "", 27);
    Relationship r = new Relationship(this.coachella, this.raimee, 0, 1);

    ArrayList<Band> bands = new ArrayList<Band>();

    /**
     * Mock Band Accessor constructor.
     */
    public MockBandAccessor() {
        this.bands.add(this.raimee);
        this.bands.add(this.chaitra);
        this.bands.add(this.coolband);
        this.bands.add(this.cowiemoomoo);
        this.bands.add(this.chicken);
        this.bands.add(this.aidrake);
        this.bands.add(this.testband);
    }

    @Override
    public Band saveBand(Band b) {
        return b;
    }

    @Override
    public Band getBandsByGigID(int id) {
        id = this.coachella.getprimaryKey();
        for (int i = 0; i < this.bands.size(); i++) {
            if (this.bands.get(i).getprimaryKey() == id) {
                return this.bands.get(i);
            }
        }
        return null;
    }

    @Override
    public Band getBandByName(String name) {
        for (int i = 0; i < this.bands.size(); i++) {
            if (this.bands.get(i).getuniqueName().equals(name)) {
                return this.bands.get(i);
            }
        }
        return null;
    }

}
