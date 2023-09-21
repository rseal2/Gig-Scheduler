package Accessors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.unl.raikes.gigscheduler.Band;
import edu.unl.raikes.gigscheduler.ConnectionFactory;
import edu.unl.raikes.gigscheduler.Gig;
import edu.unl.raikes.gigscheduler.Relationship;

/**
 * RelationshipAccessor class that has queries which accesses the SQL database for the relationships table.
 */
public class RelationshipAccessor implements IRelationshipAccessor {
    IGigAccessor gigAcc = new GigAccessor();
    IBandAccessor bandAcc = new BandAccessor();

    @Override
    public Relationship saveRelationship(Relationship relationship) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO relationships (gig_id, band_id, headliner) values" + "(\""
                    + relationship.getgig().getprimaryKey() + "\", " + "\"" + relationship.getband().getprimaryKey()
                    + "\", " + "\"" + relationship.getHeadliner() + "\") ";
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();

            // STEP 5: Extract data from result set & display values
            int insertID = 0;
            if (rs.next()) {
                insertID = rs.getInt(1);
            }
            relationship.setprimaryKey(insertID);

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
        return relationship;
    }

    @Override
    public ArrayList<Relationship> getRelationshipByGigID(int id) {
        ArrayList<Relationship> r = new ArrayList<Relationship>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 3: Open a connection
            conn = ConnectionFactory.getConnection();

            // STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql = "";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 5: Extract data from result set & display values

            while (rs.next()) {

                // Retrieve by column name
                String uniqueName = rs.getString("unique_name");
                String hometown = rs.getString("hometown");
                String webURL = rs.getString("web_url");
                String imageURL = rs.getString("image_url");
                int primaryKey = rs.getInt("primary_key");

                // create relationship object
                Band b = new Band(uniqueName, hometown, webURL, imageURL, primaryKey);

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
        return r;
    }
}
