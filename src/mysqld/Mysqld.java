package mysqld;

import java.sql.*;

public class Mysqld {

    public static Connection con = null;



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

    public static void writeRegister(String id,String email,String password,String authority){

    }

    public static boolean loginAccount(String id,String password){
        Statement sql;
        ResultSet resultSet;
        String url = "select id,password from user";
        try{
            sql = con.createStatement();
            resultSet = sql.executeQuery(url);
            while(resultSet.next()){
                if (resultSet.getString(1).equals(id)
                && resultSet.getString(2).equals(password)){
                    return true;
                }
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
