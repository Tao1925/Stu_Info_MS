import javax.swing.*;
import java.awt.*;

public class LoginStart extends JFrame {

    JLabel bg_img_label;
    JPanel bg_img_panel;
    JPanel title_panel;
    JLabel title_label;
    FlowLayout flowLayout; // set layout
    JPanel main_panel;

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
        Font title_font = new Font("Microsoft YaHei",Font.BOLD,30);
        title_panel = new JPanel();
        flowLayout = new FlowLayout(FlowLayout.CENTER);
        title_label = new JLabel("Student Info MS");
        title_label.setFont(title_font);
        title_label.setForeground(Color.WHITE);
        title_panel.setBounds(0,0,WIDTH,100);
        title_panel.setLayout(flowLayout);
        title_panel.setOpaque(false);// tou ming
        title_panel.add(title_label);
        main_panel.add(title_panel);

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


    }
}
