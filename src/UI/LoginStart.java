package UI;

import event.RegEvent;
import style.MyFonts;

import javax.swing.*;
import java.awt.*;

public class LoginStart extends JFrame {

    JLabel bg_img_label;
    JPanel bg_img_panel;
    JPanel title_panel;
    JLabel title_label;
    JLabel id_label;
    JPanel id_panel;
    JTextField id_textField;
    JLabel password_label;
    JPanel password_panel;
    JPasswordField password_field;
    JButton login_button;
    JButton register_button;
    JPanel button_panel;
    FlowLayout flowLayout; // set layout
    JPanel main_panel;

    RegEvent regEvent;

    final int WIDTH = 600;
    final int HEIGHT = 400;

    public LoginStart(){
        // init() func should be at first
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate(); // make components work
        //init();
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



        // set title
        title_panel = new JPanel();
        flowLayout = new FlowLayout(FlowLayout.CENTER);
        title_label = new JLabel("Student Info MS");
        title_label.setFont(MyFonts.title_font);
        title_label.setForeground(Color.WHITE);
        title_panel.setBounds(0,20,WIDTH,100);
        title_panel.setLayout(flowLayout);
        title_panel.setOpaque(false);// tou ming
        title_panel.add(title_label);
        main_panel.add(title_panel);


        // set ID panel
        id_panel = new JPanel();
        id_label = new JLabel("            ID: ");
        id_label.setFont(MyFonts.plain_font);
        id_label.setForeground(Color.WHITE);
        id_textField = new JTextField(15);
        id_textField.setFont(MyFonts.plain_font);
        id_panel.setBounds(0,100,WIDTH,50);
        id_panel.setLayout(flowLayout);
        id_panel.setOpaque(false);
        id_panel.add(id_label);
        id_panel.add(id_textField);
        main_panel.add(id_panel);

        // set password panel
        password_panel = new JPanel();
        password_label = new JLabel("password: ");
        password_label.setFont(MyFonts.plain_font);
        password_label.setForeground(Color.WHITE);
        password_field = new JPasswordField(15);
        password_field.setFont(MyFonts.plain_font);
        password_panel.setBounds(0,150,WIDTH,50);
        password_panel.setLayout(flowLayout);
        password_panel.setOpaque(false);
        password_panel.add(password_label);
        password_panel.add(password_field);
        main_panel.add(password_panel);

        // set button panel
        button_panel = new JPanel();
        login_button = new JButton("login");
        register_button = new JButton("register");
        login_button.setPreferredSize(new Dimension(110,30));
        login_button.setFont(MyFonts.button_font);
        register_button.setPreferredSize(new Dimension(110,30));
        register_button.setFont(MyFonts.button_font);
        button_panel.setLayout(flowLayout);
        button_panel.setBounds(0,200,WIDTH,50);
        button_panel.add(login_button);
        button_panel.add(register_button);
        button_panel.setOpaque(false);
        main_panel.add(button_panel);

        // set background picture
        bg_img_panel = new JPanel();
        bg_img_panel.setBounds(0, 0, WIDTH, HEIGHT);
        bg_img_panel.setLayout(null);
        ImageIcon bg_img = new ImageIcon("src/img/bg_img.jpg");
        bg_img_label = new JLabel(bg_img);
        bg_img_label.setBounds(0,0,WIDTH,HEIGHT);
        bg_img_panel.add(bg_img_label);
        main_panel.add(bg_img_panel);


        this.add(main_panel);
        this.setTitle("Login");

        allEvent();
    }

    void allEvent(){
        regEvent = new RegEvent();
        register_button.addMouseListener(regEvent);
    }
}
