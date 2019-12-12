import java.sql.*;
import java.util.ArrayList;

public class DatabaseTools {
    public static Connection getConnected() {
        Connection conn = null;

        try {
            //Load MySQL database driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connection string
            String dbURL = "jdbc:mysql://localhost:3306/max";

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

    public static void insert(String fn, String ln, String un, String pw) {
        // Connection to database;
        Connection myConn = DatabaseTools.getConnected();

        PreparedStatement ps = null;

        // Insert query
        String queryInsert = "INSERT INTO tbl_users (user_fn, user_ln, user_un, user_pw) VALUES (?, ?, ?, ?);";

        try {
            // Set PreparedStatement object to instance with query
            ps = myConn.prepareStatement(queryInsert);

            // Set values for parameters
            ps.setString(1, fn);
            ps.setString(2, ln);
            ps.setString(3, un);
            ps.setString(4, pw);

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
        ArrayList<User> myUserList = new ArrayList<User>();

        // Select statement
        String selectQuery = "SELECT user_id, user_fn, user_ln, user_un, user_pw FROM tbl_users;";

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
                user.setIdUser(rs.getInt("user_id"));
                user.setFnUser(rs.getString("user_fn"));
                user.setLnUser(rs.getString("user_ln"));
                user.setUnUser(rs.getString("user_un"));
                user.setPwUser(rs.getString("user_pw"));

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
