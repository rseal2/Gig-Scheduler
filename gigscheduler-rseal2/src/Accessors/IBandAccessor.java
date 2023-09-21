package Accessors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.Relationship;

/**
 * Accessor interface for the band table.
 */
public interface IBandAccessor {

    /**
     * Saving a band.
     * 
     * @param band to save.
     * @return the band saved.
     */
    public Band saveBand(Band band);

    /**
     * Getting a band by the gig id.
     * 
     * @param id is the gig's id.
     * @return a band corresponding to a gig id.
     */
    Band getBandsByGigID(int id);

    /**
     * Getting a band by a unique name to see if they are already stored.
     * 
     * @param name is the band's unique name.
     * @return a band with that name
     */
    Band getBandByName(String name);
}
