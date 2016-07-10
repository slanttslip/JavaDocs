package ro.teamnet.zth.api.database;


import java.sql.*;

/**
 * Created by Adrian.Calancea on 7/8/16.
 */
public class DBManager {
    static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT;

    private DBManager() throws UnsupportedOperationException {
    }

    private static void registerDriver() throws ClassNotFoundException {
        Class.forName(DBProperties.DRIVER_CLASS);
    }

    static public Connection getConnection() throws ClassNotFoundException, SQLException {
        registerDriver();
        Connection con = (Connection) DriverManager.getConnection(CONNECTION_STRING,DBProperties.User,DBProperties.PASS);

        return con;
    }

    public static int checkConnection(Connection con) throws SQLException, ClassNotFoundException {
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT 1 FROM DUAL");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}