package event;


import UI.Register;
import mysqld.Mysqld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegEvent implements ActionListener {


    JButton reg_button;

    @Override
    public void actionPerformed(ActionEvent e) {
        reg_button = (JButton) e.getSource();
        if (reg_button.getName().equals("register_button")){
            System.out.println("registered successfully");
            func();
        }
    }

    void func(){
        String id = Register.id_textField.getText();
        String email = Register.email_textField.getText();
        String verity = Register.verify_textField.getText();
        char[] str = Register.password_field.getPassword();
        String password = new String(str);
        str = Register.check_field.getPassword();
        String check = new String(str);

        if (id.equals("")){
            JOptionPane.showMessageDialog(null,"ID can't be null","Warning",JOptionPane.WARNING_MESSAGE);
        }else if (email.equals("")){
            JOptionPane.showMessageDialog(null,"Email can't be null","Warning",JOptionPane.WARNING_MESSAGE);
        }else if (!verity.equals("123456")){
            JOptionPane.showMessageDialog(null,"Wrong verify code","Warning",JOptionPane.WARNING_MESSAGE);
        }else if (password.equals("")){
            JOptionPane.showMessageDialog(null,"Password can't be null","Warning",JOptionPane.WARNING_MESSAGE);
        }else if (!check.equals(password)){
            JOptionPane.showMessageDialog(null,"Password check failed","Warning",JOptionPane.WARNING_MESSAGE);
        }else {
            Connection con = Mysqld.con;
            PreparedStatement preSql;
            String sql = "insert into user values(?,?,?,?)";
            try {
                preSql = con.prepareStatement(sql);
                preSql.setString(1,id);
                preSql.setString(2,email);
                preSql.setString(3,password);
                preSql.setString(4,"1");
                preSql.executeUpdate();
                // Statement sql = con.createStatement();
                JOptionPane.showMessageDialog(null,"Registered successfully","Note",JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }
}
