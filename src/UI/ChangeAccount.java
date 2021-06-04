package UI;

import event.ChangeEvent;
import style.MyFonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChangeAccount extends JFrame {

    JLabel id_label;
    JLabel email_label;
    JLabel password_label;
    JLabel check_label;
    public static JTextField id_textField;
    public static JTextField email_textField;
    public static JPasswordField password_field;
    public static JPasswordField check_field;
    JButton change_button;
    JPanel main_panel;
    JPanel email_panel;
    JPanel id_panel;
    JPanel password_panel;
    JPanel check_panel;

    final int WIDTH = 500;
    final int HEIGHT = 300;

    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);

    public ChangeAccount(){
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate(); // make components work
    }

    void init(){
        // set main
        this.setLayout(flowLayout);

        //init main panel
        main_panel = new JPanel();
        main_panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        main_panel.setLayout(flowLayout);
        main_panel.setOpaque(false);


        // get width and height of current screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // make window displays at center
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);

        // set id
        id_label = new JLabel("            ID:");
        id_label.setFont(MyFonts.plain_font);
        id_panel = new JPanel();
        id_panel.setLayout(flowLayout);
        id_panel.setOpaque(false);
        id_panel.setBounds(0,50,WIDTH,50);
        id_textField = new JTextField(15);
        id_textField.setFont(MyFonts.plain_font);
        id_panel.add(id_label);
        id_panel.add(id_textField);
        main_panel.add(id_panel);

        // set email
        email_label = new JLabel("       Email:");
        email_label.setFont(MyFonts.plain_font);
        email_panel = new JPanel();
        email_panel.setLayout(flowLayout);
        email_panel.setOpaque(false);
        email_panel.setBounds(0,110,WIDTH,50);
        email_textField = new JTextField(15);
        email_textField.setFont(MyFonts.plain_font);
        email_panel.add(email_label);
        email_panel.add(email_textField);
        // email_panel.add(password_status);
        main_panel.add(email_panel);

        // set password
        password_label = new JLabel("Password:");
        password_label.setFont(MyFonts.plain_font);
        password_panel = new JPanel();
        password_panel.setLayout(flowLayout);
        password_panel.setOpaque(false);
        password_panel.setBounds(0,230,WIDTH,50);
        password_field = new JPasswordField(15);
        password_field.setFont(MyFonts.plain_font);
        password_panel.add(password_label);
        password_panel.add(password_field);
        main_panel.add(password_panel);

        // set check
        check_label = new JLabel("      Check:");
        check_label.setFont(MyFonts.plain_font);
        check_panel = new JPanel();
        check_panel.setLayout(flowLayout);
        check_panel.setOpaque(false);
        check_panel.setBounds(0,290,WIDTH,50);
        check_field = new JPasswordField(15);
        check_field.setFont(MyFonts.plain_font);
        check_panel.add(check_label);
        check_panel.add(check_field);
        main_panel.add(check_panel);

        // set button
        change_button = new JButton("Change");
        change_button.setPreferredSize(new Dimension(110,30));
        change_button.setFont(MyFonts.button_font);
        main_panel.add(change_button);

        // this.setLayout(null);
        this.add(main_panel);
        this.setTitle("Change Account Info");

        setName();
        allEvent();
    }
    void setName(){
        change_button.setName("change");
    }
    void allEvent(){
        ChangeEvent changeEvent = new ChangeEvent();
        change_button.addActionListener(changeEvent);
    }

}
