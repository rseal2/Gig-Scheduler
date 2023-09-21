package Mock;

import java.util.ArrayList;

import Accessors.IRelationshipAccessor;
import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.Gig;
import edu.unl.raikes.gigscheduler.Relationship;

/**
 * Mock Relationship Accessor that implements the IRelationshipAccessor.
 */
public class MockRelationshipAccessor implements IRelationshipAccessor {

    Gig coachella = new Gig("coachella", "2023-04-19 21:30:00", "coachella is a super cool event", 1000,
            "www.coachella.com", "coachella is full of celebrities", 1);
    Band raimee = new Band("raimee's band", "omaha", "www.raimeeseal.com", "image", 1);

    @Override
    public Relationship saveRelationship(Relationship relation) {
        return relation;
    }

    @Override
    public ArrayList<Relationship> getRelationshipByGigID(int id) {
        ArrayList<Relationship> toReturn = new ArrayList<Relationship>();
        Relationship r = new Relationship(this.coachella, this.raimee, 0, 1);
        toReturn.add(r);
        return toReturn;
    }

}
