package mysqld;

import UI.ChangeAccount;
import UI.Manage;

import javax.swing.*;
import java.sql.*;

public class Mysqld {

    public static Connection con = null;

    public static String login_id;

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
                    login_id = id;
                    setStatus(id,"1");
                    return true;
                }
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void onlineAccount(){
        if (!login_id.equals("root")){
            JOptionPane.showMessageDialog(null,"UNAUTHORIZED","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Statement sql;
        ResultSet resultSet;
        String url = "select * from user";
        try{
            sql = con.createStatement();
            resultSet = sql.executeQuery(url);
            Manage.result_textArea.setText("ID\temail\t\tstatus\n");
            while(resultSet.next()){
                String ID = resultSet.getString(1);
                String email = resultSet.getString(2);
                String status = resultSet.getString(5);
                if (status.equals("1")){
                    String pre = Manage.result_textArea.getText();
                    pre += ID + "\t" + email + "\t\t" + "online" + "\n";
                    Manage.result_textArea.setText(pre);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void allAccount() {
        Statement sql;
        ResultSet resultSet;
        String url = "select * from user";
        try {
            sql = con.createStatement();
            resultSet = sql.executeQuery(url);
            Manage.result_textArea.setText("ID\temail\t\tstatus\n");
            while (resultSet.next()) {
                String ID = resultSet.getString(1);
                String email = resultSet.getString(2);
                String status = resultSet.getString(5);
                if (status.equals("1")) {
                    String pre = Manage.result_textArea.getText();
                    pre += ID + "\t" + email + "\t\t" + "online" + "\n";
                    Manage.result_textArea.setText(pre);
                } else if (status.equals("0")) {
                    String pre = Manage.result_textArea.getText();
                    pre += ID + "\t" + email + "\t\t" + "offline" + "\n";
                    Manage.result_textArea.setText(pre);
                }
                // System.out.println(Manage.result_textArea.getText());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeAccInfoEvent(){
        Statement sql;
        PreparedStatement preSql;
        ResultSet resultSet;
        String id = ChangeAccount.id_textField.getText();
        String email = ChangeAccount.email_textField.getText();
        String password = new String(ChangeAccount.password_field.getPassword());
        String check = new String(ChangeAccount.check_field.getPassword());
        if (id.equals("")){
            JOptionPane.showMessageDialog(null,"ID can't be null","Warning",JOptionPane.WARNING_MESSAGE);
        }else if (email.equals("")){
            JOptionPane.showMessageDialog(null,"Email can't be null","Warning",JOptionPane.WARNING_MESSAGE);
        }else if (password.equals("")){
            JOptionPane.showMessageDialog(null,"Password can't be null","Warning",JOptionPane.WARNING_MESSAGE);
        }else if (!check.equals(password)){
            JOptionPane.showMessageDialog(null,"Password check failed","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            String url = "update user set id=?,password=? where email=?";
            try{
                preSql = con.prepareStatement(url);
                preSql.setString(1,id);
                preSql.setString(2,password);
                preSql.setString(3,email);
                preSql.executeUpdate();
                JOptionPane.showMessageDialog(null,"Change successfully","Note",JOptionPane.PLAIN_MESSAGE);
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"No such account","Warning",JOptionPane.WARNING_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    public static void setStatus(String id,String status){
        PreparedStatement preSql;
        String sql = "update user set status=? where id=?";
        try{
            preSql = con.prepareStatement(sql);
            preSql.setString(1,status);
            preSql.setString(2,id);
            preSql.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static String findStatus(String id){
        PreparedStatement preSql;
        String sql = "select status from user where id=?";
        try{
            preSql=con.prepareStatement(sql);
            preSql.setString(1,id);
            ResultSet resultSet = preSql.executeQuery();
            while(resultSet.next()){
                return resultSet.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    // cls for class
    public static void addStu(String stu_id,String sex,String age,String cls,String name){
        PreparedStatement preSql;
        String sql = "insert into stu(stuid,sex,age,class,name) values (?,?,?,?,?)";
        try{
            preSql=con.prepareStatement(sql);
            preSql.setString(1,stu_id);
            preSql.setString(2,sex);
            preSql.setString(3,age);
            preSql.setString(4,cls);
            preSql.setString(5,name);
            preSql.executeUpdate();
            JOptionPane.showMessageDialog(null,"Add data successfully","Note",JOptionPane.PLAIN_MESSAGE);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Stu ID already exists","Warning",JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
        showData();
    }

    public static void delStu(String stu_id){
        PreparedStatement preSql;
        String sql = "delete from stu where stuid=?";
        try{
            preSql=con.prepareStatement(sql);
            preSql.setString(1,stu_id);
            preSql.executeUpdate();
            JOptionPane.showMessageDialog(null,"Delete data successfully","Note",JOptionPane.PLAIN_MESSAGE);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"No such stu ID ","Warning",JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
        showData();
    }

    public static void showData(){

        int row_count =  Manage.model.getRowCount();;
        while(row_count > 0){
            Manage.model.removeRow(0);
            row_count--;
        }

        String[] row = new String[5];
        PreparedStatement preSql;
        String sql = "select * from stu";
        try{
            preSql=con.prepareStatement(sql);
            ResultSet resultSet = preSql.executeQuery();
            while(resultSet.next()){
                for(int i = 0; i < 5; i++) row[i] = resultSet.getString(i + 1);
                Manage.model.addRow(row);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
