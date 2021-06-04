package event;

import UI.ChangeAccount;
import main.Main;
import mysqld.Mysqld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountEvent implements ActionListener {

    JMenuItem menuItem;

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            menuItem = (JMenuItem) e.getSource();
            if (menuItem.getName().equals("item1_1")){
                Mysqld.onlineAccount();
            }else if (menuItem.getName().equals("item1_2")){
                Mysqld.allAccount();
            }else if (menuItem.getName().equals("item1_3")){
                ChangeAccount changeAccount = new ChangeAccount();
            }else if (menuItem.getName().equals("item2_1")){
                Mysqld.setStatus(Mysqld.login_id,"0");
                LoginEvent.manage.dispose();
                Main.loginStart.show();
            }else if (menuItem.getName().equals("item2_2")){
                Mysqld.setStatus(Mysqld.login_id,"0");
                LoginEvent.manage.dispose();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
