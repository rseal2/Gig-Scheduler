package Accessors;

import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.Relationship;

/**
 * Accessor interface for the relationship table.
 *
 */
public interface IRelationshipAccessor {

    /**
     * Saving a relationship.
     * 
     * @param relationship is the relationship you are trying to save.
     * @return a saved relationship.
     */
    public Relationship saveRelationship(Relationship relationship);

    /**
     * Getting a relationship by the gig id.
     * 
     * @param id is the gig id.
     * @return relationship.
     */
    public ArrayList<Relationship> getRelationshipByGigID(int id);

}
