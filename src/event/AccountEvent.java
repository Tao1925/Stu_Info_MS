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
            Mysqld.onlineAccount();
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
