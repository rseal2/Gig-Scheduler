package edu.unl.raikes.gigscheduler;

import java.util.List;

/**
 * Class for the band objects from the table in SQL.
 *
 */
public class Band {
    public String uniqueName;
    public String hometown;
    public String webURL;
    public String imageURL;
    public int primaryKey;
    public int headliner;

    /**
     * Constructor for band objects.
     * 
     * @param uniqueName is the unique name of the band.
     * @param hometown is where the band is from.
     * @param webURL is the url to a band's information and other details.
     * @param imageURL is a link to a picture of the band.
     * @param primaryKey is the primary key of the band.
     */
    public Band(String uniqueName, String hometown, String webURL, String imageURL, int primaryKey, int headliner) {
        super();
        this.uniqueName = uniqueName;
        this.hometown = hometown;
        this.webURL = webURL;
        this.imageURL = imageURL;
        this.primaryKey = primaryKey;
        this.headliner = headliner;
    }

    /**
     * Band constructor without the headliner value.
     * 
     * @param uniqueName is the unique name of the band.
     * @param hometown is where the band is from.
     * @param webURL is the url to a band's information and other details.
     * @param imageURL is a link to a picture of the band.
     * @param primaryKey is the primary key of the band.
     */
    public Band(String uniqueName, String hometown, String webURL, String imageURL, int primaryKey) {
        super();
        this.uniqueName = uniqueName;
        this.hometown = hometown;
        this.webURL = webURL;
        this.imageURL = imageURL;
        this.primaryKey = primaryKey;
    }

    /**
     * Constructor for band objects.
     * 
     * @param uniqueName is the unique name of the band.
     * @param hometown is where the band is from.
     * @param webURL is the url to a band's information and other details.
     * @param imageURL is a link to a picture of the band.
     * @param primaryKey is the primary key of the band.
     */
    public Band(String uniqueName, String hometown, String webURL, String imageURL) {
        super();
        this.uniqueName = uniqueName;
        this.hometown = hometown;
        this.webURL = webURL;
        this.imageURL = imageURL;
    }

    /**
     * Getting the name of the band.
     * 
     * @return the name of the band.
     */
    public String getuniqueName() {
        return this.uniqueName;
    }

    /**
     * Setting the name of the band.
     * 
     * @param uniqueName is the name to be set.
     */
    public void setuniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    /**
     * Getting the hometown of the band.
     * 
     * @return the hometown that the band is from.
     */
    public String getHometown() {
        return this.hometown;
    }

    /**
     * Setting the hometown of the band.
     * 
     * @param hometown is the hometown to be set.
     */
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * Getting the link to the band's website.
     * 
     * @return the website url.
     */
    public String getwebURL() {
        return this.webURL;
    }

    /**
     * Setting the website link.
     * 
     * @param webURL is the link to be set.
     */
    public void setwebURL(String webURL) {
        this.webURL = webURL;
    }

    /**
     * Getting the link to an image of the band.
     * 
     * @return a link to the image.
     */
    public String getimageURL() {
        return this.imageURL;
    }

    /**
     * Setting the image url.
     * 
     * @param imageURL is the url to be set.
     */
    public void setimageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Getting the primary key of the band.
     * 
     * @return the primary key of the band.
     */
    public int getprimaryKey() {
        return this.primaryKey;
    }

    /**
     * Setting the primary key of the band.
     * 
     * @param primaryKey is the number of the key to set.
     */
    public void setprimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    /**
     * Converting the information of a band into a string.
     */
    @Override
    public String toString() {
        if (this.webURL == null) {
            this.webURL = "not available yet";
        }
        if (this.imageURL == null) {
            this.imageURL = "not available yet";
        }
        String s = "The band playing at this gig is called " + this.uniqueName + "\n and they are from " + this.hometown
                + ".\n The link to their website is " + this.webURL + "." + "\n The link to a picture of them is "
                + this.imageURL + ".";
        if (this.headliner == 1) {
            s += "\n This band is also a headliner.";
        }
        return s;
    }

    /**
     * Converting the band collections to a string.
     * 
     * @return a string.
     */
    public static String collectionToString(List<Band> bands) {
        StringBuilder s = new StringBuilder();
        for (Band b : bands) {
            s.append(b);
        }
        return s.toString();
    }
}
