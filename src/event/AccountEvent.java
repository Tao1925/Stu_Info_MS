package event;

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
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
