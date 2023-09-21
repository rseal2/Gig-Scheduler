package edu.unl.raikes.gigscheduler;

import java.util.List;

/**
 * Class to outline the relationships between the gigs and the bands.
 *
 */
public class Relationship {
    public Gig gig;
    public Band band;
    public int headliner;
    public int primaryKey;

    /**
     * Relationship constructor that takes in a gig, band, headliner, and primary key.
     * 
     * @param gig is the id of the gig we want to relate to the band.
     * @param band is the id of the band we want to relate to the gig.
     * @param headliner is the headliner.
     * @param primaryKey is the primary key.
     */
    public Relationship(Gig gig, Band band, int headliner, int primaryKey) {
        super();
        this.gig = gig;
        this.band = band;
        this.headliner = headliner;
        this.primaryKey = primaryKey;
    }

    /**
     * Relationship constructor that takes in a gig, band, headliner.
     * 
     * @param gig is the id of the gig we want to relate to the band.
     * @param headliner is the headliner.
     * @param primaryKey is the primary key.s
     */
    public Relationship(Gig gig, Band band, int headliner) {
        super();
        this.gig = gig;
        this.band = band;
        this.headliner = headliner;
    }

    /**
     * Getting a gig id.
     * 
     * @return a gig id.
     */
    public Gig getgig() {
        return this.gig;
    }

    /**
     * Setting a gig id.
     * 
     * @param gig is the gig id to set.
     */
    public void setgig(Gig gig) {
        this.gig = gig;
    }

    /**
     * Getting a band id.
     * 
     * @return band id.
     */
    public Band getband() {
        return this.band;
    }

    /**
     * Setting a band id.
     * 
     * @param band is the band id to set.
     */
    public void setband(Band band) {
        this.band = band;
    }

    /**
     * Getting the headliner.
     * 
     * @return headliner.
     */
    public int getHeadliner() {
        return this.headliner;
    }

    /**
     * Setting a headliner.
     * 
     * @param headliner to set.
     */
    public void setHeadliner(int headliner) {
        this.headliner = headliner;
    }

    /**
     * Getting the primary key.
     * 
     * @return primary key.
     */
    public int getprimaryKey() {
        return this.primaryKey;
    }

    /**
     * Setting the primary key.
     * 
     * @param primary to set.
     */
    public void setprimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * Turning the relationship between the band and the gig into a string.
     */
    @Override
    public String toString() {
        String s = "The band " + this.band.getuniqueName() + " is playing at " + this.gig.getName();
        if (this.headliner == 1) {
            s += "\nThis band is also a headliner.";
        }
        return s;
    }

    /**
     * Turning the collection into a string.
     * 
     * @return collection to string.
     */
    public static String collectionToString(List<Relationship> relationships) {
        StringBuilder s = new StringBuilder();
        for (Relationship r : relationships) {
            if (r.getHeadliner() == 1) {
                s.append(r.toString());
            }
        }
        for (Relationship r : relationships) {
            if (r.getHeadliner() == 0) {
                s.append(r.toString());
            }
        }
        return s.toString();
    }
}
