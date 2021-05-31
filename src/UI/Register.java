package UI;

import event.RegEvent;
import style.MyFonts;

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
    JPanel button_panel;
    JButton register_button;
    public static JTextField id_textField;
    public static JTextField email_textField;
    public static JTextField verify_textField;
    public static JPasswordField password_field;
    public static JPasswordField check_field;
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
    ImageIcon accept_img  = new ImageIcon("src/img/accept_1.png");
    ImageIcon deny_img = new ImageIcon("src/img/deny_1.png");
    JLabel password_status;
    RegEvent regEvent;
    JPanel main_panel;


    final int WIDTH = 500;
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
        main_panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        main_panel.setLayout(null);
        main_panel.setOpaque(false);
        // main_panel.setBorder(BorderFactory.createTitledBorder("Register"));

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
        password_status = new JLabel(accept_img);
        email_panel.add(email_label);
        email_panel.add(email_textField);
        // email_panel.add(password_status);
        main_panel.add(email_panel);

        // set verify
        verify_label = new JLabel("      Verify:");
        verify_label.setFont(MyFonts.plain_font);
        verify_panel = new JPanel();
        verify_panel.setLayout(flowLayout);
        verify_panel.setOpaque(false);
        verify_panel.setBounds(0,170,WIDTH,50);
        verify_textField = new JTextField(15);
        verify_textField.setFont(MyFonts.plain_font);
        verify_panel.add(verify_label);
        verify_panel.add(verify_textField);
        main_panel.add(verify_panel);

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
        button_panel = new JPanel();
        register_button = new JButton("register");
        register_button.setPreferredSize(new Dimension(110,30));
        register_button.setFont(MyFonts.button_font);
        button_panel.setLayout(flowLayout);
        button_panel.setBounds(0,350,WIDTH,50);
        button_panel.add(register_button);
        button_panel.setOpaque(false);
        main_panel.add(button_panel);

        // this.setLayout(null);
        this.add(main_panel);
        this.setTitle("Register");

        setTags();
        allEvent();
    }

    void setTags(){
        register_button.setName("register_button");
    }

    void allEvent(){
        regEvent = new RegEvent();
        register_button.addActionListener(regEvent);
    }
}
