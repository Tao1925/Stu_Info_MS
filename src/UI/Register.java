package UI;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame{

    JLabel id_label;
    JLabel email_label;
    JLabel verify_label;// verify email
    JLabel password_label;
    JLabel check_label;//check password
    JPanel id_panel;
    JPanel email_panel;
    JPanel verify_panel;
    JPanel password_panel;
    JPanel check_panel;
    JButton register_button;
    JPanel main_panel;


    final int WIDTH = 400;
    final int HEIGHT = 500;

    public Register(){
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate();
    }

    void init(){
        //init main panel
        main_panel = new JPanel();
        main_panel.setBounds(0, 0, WIDTH, HEIGHT);
        main_panel.setLayout(null);

        // get width and height of current screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // make window displays at center
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);

        this.setLayout(null);
        this.add(main_panel);

    }
}
