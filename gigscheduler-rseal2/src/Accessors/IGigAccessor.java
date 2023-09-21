package Accessors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.Gig;

/**
 * Accessor interface for the gig table.
 */
public interface IGigAccessor {

    /**
     * Getting a gig by an id.
     * 
     * @param id is the id of the band.
     * @return a gig with the given id.
     */
    public Gig getGigByID(int id);

    /**
     * Saving the gig.
     * 
     * @param a gig to save.
     * @return the gig that was saved.
     */
    public Gig saveGig(Gig gig);

    /**
     * Returning the gigs in order by time.
     * 
     * @param an array list of gigs to order.
     */
    public ArrayList<Gig> returnOrderedGigs(String startDate, String endDate);

}
