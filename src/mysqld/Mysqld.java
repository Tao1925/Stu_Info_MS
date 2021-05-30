package mysqld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysqld {

    Connection con = null;

    public Mysqld(String account,String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("load driver successfully");
        }catch (Exception e){
            System.out.println("load driver failed");
        }
        // String url = "jdbc:mysql://localhost:3306/datasystemcon?characterEncoding=utf-8&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/sims_db?characterEncoding=utf-8&useSSL=false";
        try {
            con = DriverManager.getConnection(url,account,password);
            System.out.println("connect DB successfully");
        }catch (SQLException e){
            System.out.println("connect DB failed");
        }

    }

}
