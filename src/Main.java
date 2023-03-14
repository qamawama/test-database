import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("db4free.net","3306","dawnsdatabase","paperdawn","oopdatabase12");
        db.connect();
        db.runQuery("select * from Student");
        db.close();
    }
}