package Accessors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.Relationship;

/**
 * BandAccessor class that has queries which accesses the SQL database for the band table.
 *
 */
public class BandAccessor implements IBandAccessor {

    @Override
    public Band getBandByName(String name) {
        Connection conn = null;
        Statement stmt = null;
        Band b = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();
            // IS THIS WRONG???
            String sql = "SELECT * FROM band where unique_name = '" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set & display values

            while (rs.next()) {

                // Retrieve by column name
                String uniqueName = rs.getString("unique_name");
                String hometown = rs.getString("hometown");
                String webURL = rs.getString("web_url");
                String imageURL = rs.getString("image_url");
                int primaryKey = rs.getInt("primary_key");

                // create band object
                b = new Band(uniqueName, hometown, webURL, imageURL, primaryKey);

                // Display values
                System.out.println(b);
            }
            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                // do nothing
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return b;
    }

    @Override
    public Band saveBand(Band band) {
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();
            if (band.getwebURL().equals("") && band.getimageURL().equals("")) {
                sql = "INSERT INTO band (unique_name, hometown) values" + "(\"" + band.getuniqueName() + "\", " + "\""
                        + band.getHometown() + "\") ";
            } else if (!band.getwebURL().equals("") && band.getimageURL().equals("")) {
                sql = "INSERT INTO band (unique_name, hometown, web_url) values" + "(\"" + band.getuniqueName() + "\", "
                        + "\"" + band.getHometown() + "\", " + "\"" + band.getwebURL() + "\") ";
            } else if (band.getwebURL().equals("") && !band.getimageURL().equals("")) {
                sql = "INSERT INTO band (unique_name, hometown, image_url) values" + "(\"" + band.getuniqueName()
                        + "\", " + "\"" + band.getHometown() + "\", " + "\"" + band.getimageURL() + "\") ";
            } else {
                sql = "INSERT INTO band (unique_name, hometown, web_url, image_url) values" + "(\""
                        + band.getuniqueName() + "\", " + "\"" + band.getHometown() + "\", " + "\"" + band.getwebURL()
                        + "\", " + "\"" + band.getimageURL() + "\") ";
            }
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();

            // STEP 5: Extract data from result set & display values
            int insertID = 0;
            if (rs.next()) {
                insertID = rs.getInt(1);
            }
            band.setprimaryKey(insertID);

            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Yess band!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                // do nothing
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return band;
    }

    @Override
    public Band getBandsByGigID(int id) {
        Band b = null;
        Connection conn = null;
        Statement stmt = null;
        // is this function even written correctly? should it be in the band class and i write something else here?
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT DISTINCT * FROM relationships JOIN gigs ON gigs.primary_key = "
                    + "relationships.gig_id JOIN band ON band.primary_key = relationships.band_id "
                    + "WHERE gigs.primary_key = '" + id + "'ORDER BY headliner DESC;";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set & values

            while (rs.next()) {

                // Retrieve by column name
                String uniqueName = rs.getString("unique_name");
                String hometown = rs.getString("hometown");
                String webURL = rs.getString("web_url");
                String imageURL = rs.getString("image_url");
                int headliner = rs.getInt("headliner");
                int primaryKey = rs.getInt("primary_key");

                System.out.println(headliner);

                // create relationship object
                b = new Band(uniqueName, hometown, webURL, imageURL, primaryKey, headliner);

                // Display values
                System.out.println(b);
                System.out.println();
            }
            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                // do nothing
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return b;
    }
}
