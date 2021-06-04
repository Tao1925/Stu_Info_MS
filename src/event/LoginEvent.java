package event;

import UI.LoginStart;
import UI.Manage;
import UI.Register;
import main.Main;
import mysqld.Mysqld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginEvent implements ActionListener{

    JButton button;
    public static Manage manage;
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            button = (JButton) e.getSource();
            if (button.getName().equals("login_button")){
                String id = LoginStart.id_textField.getText();
                String password = new String(LoginStart.password_field.getPassword());
                if (Mysqld.loginAccount(id, password)){
                    Main.loginStart.dispose();
                    manage = new Manage();
                }else{
                    JOptionPane.showMessageDialog(null,"wrong ID or password","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }else if (button.getName().equals("register_button")){
                Register register = new Register();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}