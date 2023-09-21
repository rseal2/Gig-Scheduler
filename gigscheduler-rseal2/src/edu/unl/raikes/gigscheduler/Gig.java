package edu.unl.raikes.gigscheduler;

import java.util.List;

/**
 * Class for the gig objects from the table in SQL.
 *
 */
public class Gig {
    public String name;
    public String datetime;
    public String description;
    public int ticketCost;
    public String link;
    public String notes;
    public int primaryKey;

    /**
     * Constructor for gig objects.
     * 
     * @param name is the name of the gig.
     * @param datetime is the date and time at which the gig is occurring.
     * @param description is the description of the gig.
     * @param ticketCost is the cost of a ticket to attend the gig.
     * @param link is the link to a website for the gig.
     * @param notes is additional notes and information.
     * @param primaryKey is the primary key of the gig.
     */
    public Gig(String name, String datetime, String description, int ticketCost, String link, String notes,
            int primaryKey) {
        super();
        this.name = name;
        this.datetime = datetime;
        this.description = description;
        this.ticketCost = ticketCost;
        this.link = link;
        this.notes = notes;
        this.primaryKey = primaryKey;
    }

    /**
     * Getting the name of the gig.
     * 
     * @return name of the gig.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setting the name of the gig.
     * 
     * @param name is the name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getting the date and time of the gig.
     * 
     * @return datetime of the gig.
     */
    public String getDatetime() {
        return this.datetime;
    }

    /**
     * Setting the date and time of the gig.
     * 
     * @param datetime is the date and time at which the gig is occurring.
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * Getting the description of the gig.
     * 
     * @return the description of the gig.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setting the description for the gig.
     * 
     * @param description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getting the ticket cost to attend the gig.
     * 
     * @return the cost of the ticket.
     */
    public int getticketCost() {
        return this.ticketCost;
    }

    /**
     * Setting the cost of the ticket.
     * 
     * @param ticketCost is the cost of the ticket to set.
     */
    public void setticketCost(int ticketCost) {
        this.ticketCost = ticketCost;
    }

    /**
     * Getting the link to the website for the gig.
     * 
     * @return a link to the website.
     */
    public String getLink() {
        return this.link;
    }

    /**
     * Setting the link for the gig's website.
     * 
     * @param link is the link to be set.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Getting the notes for the gig.
     * 
     * @return notes for the gig.
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * Setting notes for the gig.
     * 
     * @param notes to be set.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Getting the primary key for the gig.
     * 
     * @return primary key.
     */
    public int getprimaryKey() {
        return this.primaryKey;
    }

    /**
     * Setting the primary key for the gig.
     * 
     * @param primaryKey to be set.
     */
    public void setprimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * Converting the information for a gig into a string.
     */
    @Override
    public String toString() {
        String s = "This gig is called " + this.name
                + ". They will be playing on the following date at the following time: " + this.datetime
                + ".\n The decription for this event is the following: " + this.description
                + ".\n The cost to attend this event is $" + this.ticketCost
                + ".\n Here is a link to more information about the gig: " + this.link
                + ". Lastly, there are some additional notes to be aware of: \n " + this.notes;
        return s;
    }

    /**
     * Converting the gig collections into a string.
     * 
     * @return a string.
     */
    public static String collectionToString(List<Gig> gigs) {
        StringBuilder s = new StringBuilder();
        for (Gig g : gigs) {
            s.append(g);
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object otherGig) {
        if (!(otherGig instanceof Gig)) {
            return false;
        }
        Gig gig = (Gig) otherGig;

        if (this.name.equals(gig.name) && this.datetime.equals(gig.datetime) && this.description.equals(gig.description)
                && (this.ticketCost == gig.ticketCost) && this.notes.equals(gig.notes)) {
            return true;
        }
        return false;
    }

}
