package Accessors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.Gig;

/**
 * GigAccessor class that has queries which accesses the SQL database for the gigs table.
 *
 */
public class GigAccessor implements IGigAccessor {

    @Override
    public Gig getGigByID(int id) {
        Connection conn = null;
        Statement stmt = null;
        Gig g = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM gigs where primary_key = " + id + ";";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set & display values

            while (rs.next()) {

                // Retrieve by column name
                String name = rs.getString("name");
                String datetime = rs.getString("start_date_time");
                String description = rs.getString("description");
                int ticketCost = rs.getInt("ticket_cost");
                String link = rs.getString("link");
                String notes = rs.getString("notes");
                int primaryKey = rs.getInt("primary_key");

                // create band object
                g = new Gig(name, datetime, description, ticketCost, link, notes, primaryKey);

                // Display values
                System.out.println(g);
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
        return g;
    }

    @Override
    public Gig saveGig(Gig gig) {
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();
            if (gig.getLink().equals("")) {
                sql = "INSERT INTO gigs (name, start_date_time, description, ticket_cost, notes) values" + "(\""
                        + gig.getName() + "\", " + "\"" + gig.getDatetime() + "\", " + "\"" + gig.getDescription()
                        + "\", " + "\"" + gig.getticketCost() + "\", " + "\"" + gig.getNotes() + "\") ";
            } else {
                sql = "INSERT INTO gigs (name, start_date_time, description, ticket_cost, link, notes) values" + "(\""
                        + gig.getName() + "\", " + "\"" + gig.getDatetime() + "\", " + "\"" + gig.getDescription()
                        + "\", " + "\"" + gig.getticketCost() + "\", " + "\"" + gig.getLink() + "\", " + "\""
                        + gig.getNotes() + "\") ";
            }
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();

            // STEP 5: Extract data from result set & display values
            int insertID = 0;
            if (rs.next()) {
                insertID = rs.getInt(1);
            }
            gig.setprimaryKey(insertID);

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
        return gig;
    }

    @Override
    public ArrayList<Gig> returnOrderedGigs(String startDate, String endDate) {
        Connection conn = null;
        Statement stmt = null;
        Gig g = null;
        ArrayList<Gig> orderedGigs = new ArrayList<Gig>();
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM gigs WHERE start_date_time > " + "\"" + startDate + "\""
                    + " AND start_date_time < " + "\"" + endDate + "\"" + "ORDER BY start_date_time ASC" + ";";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set & display values

            while (rs.next()) {

                // Retrieve by column name
                String name = rs.getString("name");
                String datetime = rs.getString("start_date_time");
                String description = rs.getString("description");
                int ticketCost = rs.getInt("ticket_cost");
                String link = rs.getString("link");
                String notes = rs.getString("notes");
                int primaryKey = rs.getInt("primary_key");

                // create band object
                g = new Gig(name, datetime, description, ticketCost, link, notes, primaryKey);
                orderedGigs.add(g);

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
        return orderedGigs;
    }
}
