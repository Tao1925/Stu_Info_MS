package event;

import mysqld.Mysqld;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowsEvent extends WindowAdapter {

    // for closing JFrame using cha in you shang
    public void windowClosing(WindowEvent e){
        // System.out.println(Mysqld.login_id+" change to 0");
        Mysqld.setStatus(Mysqld.login_id,"0");
        // System.out.println("it is closed");
    }

}
