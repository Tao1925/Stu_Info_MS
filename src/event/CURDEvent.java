package event;

import UI.Manage;
import mysqld.Mysqld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CURDEvent implements ActionListener {

    JButton button;
    @Override
    public void actionPerformed(ActionEvent e) {
        button = (JButton) e.getSource();
        String stu_id = Manage.stuId_textField.getText();
        String sex = "MAN";
        if (Manage.women_radioButton.isSelected()){
            sex = "WOMAN";
        }
        String age = Manage.age_textField.getText();
        String cls = Manage.class_textField.getText();
        String name = Manage.name_textField.getText();
        if (button.getName().equals("add")){
            Mysqld.addStu(stu_id,sex,age,cls,name);
        }else if (button.getName().equals("delete")){
            Mysqld.delStu(stu_id);
        }else if (button.getName().equals("change")){

        }else if (button.getName().equals("find")){

        }else if (button.getName().equals("show")){
            Mysqld.showData();
        }
    }
}
