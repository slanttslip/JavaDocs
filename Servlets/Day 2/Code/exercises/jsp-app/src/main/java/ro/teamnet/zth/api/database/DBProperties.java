package ro.teamnet.zth.api.database;

public interface DBProperties {

    String IP = "192.168.99.100";
//    String PORT = "3306";
    String PORT = "49161";
    String SCHEMA = "XE";
    String USER = "acalancea";
    String PASS = "slanttslip";
//    String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    boolean IS_ORACLE = true;
    boolean IS_MYSQL = false;
}
