import java.sql.*;
import java.util.ArrayList;

public class DatabaseTools {
    public static Connection getConnected() {
        Connection conn = null;

        try {
            //Load MySQL database driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connection string
            String dbURL = "jdbc:mysql://localhost:3306/useraccounts";

            // Credentials
            String username = "root";
            String password = "mysql";

            // Set connection to database to Connection object
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void insert(User user) {
        // Connection to database;
        Connection myConn = DatabaseTools.getConnected();

        PreparedStatement ps = null;

        // Insert query
        String queryInsert = "INSERT INTO tbl_accounts (fnuser, lnuser, unuser, pwuser) VALUES (?, ?, ?, ?);";

        try {
            // Set PreparedStatement object to instance with query
            ps = myConn.prepareStatement(queryInsert);

            // Set values for parameters
            ps.setString(1, user.getUser_fn());
            ps.setString(2, user.getUser_ln());
            ps.setString(3, user.getUser_un());
            ps.setString(4, user.getUser_pw());

            // Execute insert on database
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseTools.closePreparedStatement(ps);
            DatabaseTools.closeConnection(myConn);
        }
    }

    public static ArrayList<User> selectAllUsers() {
        // Connection to database
        Connection conn = DatabaseTools.getConnected();

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> myUserList = new ArrayList<>();

        // Select statement
        String selectQuery = "SELECT iduser, fnuser, lnuser, unuser, pwuser FROM tbl_accounts;";

        try {
            // Create prepared statemnent object
            ps = conn.prepareStatement(selectQuery);

            // Execute query and return result set
            rs = ps.executeQuery();

            // Loop through all rows in result set
            while (rs.next()) {
                // Create user object to add to list.
                User user = new User();

                // Add values for row of result set to properties of User object
                user.setUser_id(rs.getInt("iduser"));
                user.setUser_fn(rs.getString("fnuser"));
                user.setUser_ln(rs.getString("lnuser"));
                user.setUser_un(rs.getString("unuser"));
                user.setUser_pw(rs.getString("pwuser"));

                // Add user to list
                myUserList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseTools.closePreparedStatement(ps);
            DatabaseTools.closeResultSet(rs);
            DatabaseTools.closeConnection(conn);
        }

        return myUserList;
    }

    public static void update(User user) {
        // Connection to database;
        Connection myConn = DatabaseTools.getConnected();

        PreparedStatement ps = null;

        // Update query
        String queryUpdate = "UPDATE tbl_accounts SET fnuser = ?, lnuser = ?, unuser = ?, pwuser = ? WHERE iduser = ?;";

        try {
            // Set PreparedStatement object to instance with query
            ps = myConn.prepareStatement(queryUpdate);

            // Set values for parameters
            ps.setString(1, user.getUser_fn());
            ps.setString(2, user.getUser_ln());
            ps.setString(3, user.getUser_un());
            ps.setString(4, user.getUser_pw());
            ps.setInt(5, user.getUser_id());

            // Execute update on database
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseTools.closePreparedStatement(ps);
            DatabaseTools.closeConnection(myConn);
        }
    }

    public static void delete(User user) {
        // Connection to database;
        Connection myConn = DatabaseTools.getConnected();

        PreparedStatement ps = null;

        // Update query
        String queryUpdate = "DELETE FROM tbl_accounts WHERE iduser = ?;";

        try {
            // Set PreparedStatement object to instance with query
            ps = myConn.prepareStatement(queryUpdate);

            // Set values for parameters
            ps.setInt(1, user.getUser_id());

            // Execute update on database
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseTools.closePreparedStatement(ps);
            DatabaseTools.closeConnection(myConn);
        }
    }

    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
