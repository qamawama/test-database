import java.sql.*;
import java.util.List;

public class Database {
    // Database attributes
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private String url;
    private String portNum;
    private String dbName;
    private String username;
    private String password;
    private Connection con;

    // Database constructor
    public Database(String url,String portNum,String dbName, String username, String password) {
        this.url = url;
        this.portNum = portNum;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    // Method: connect database
    public void connect(){
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.url + ":" + this.portNum + "/" + this.dbName, this.username, this.password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void runQuery(String statement){
        String sqlstmt = statement;
        try {
            Statement stmt = con.createStatement(); //create a statement object
            ResultSet rs = stmt.executeQuery(sqlstmt); //execute query(sql statement in string)
            // it will return a ResultSet object (contains rows in the table)
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("ic"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close(){
        try{
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
