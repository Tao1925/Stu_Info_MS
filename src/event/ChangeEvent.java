package event;

import mysqld.Mysqld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeEvent implements ActionListener {

    JButton button;

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            button = (JButton) e.getSource();
            if (button.getName().equals("change")){
                // System.out.println("happened");
                Mysqld.changeAccInfoEvent();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
