import javax.swing.*;
import java.awt.*;

public class LoginStart extends JFrame {

    JLabel bg_img_label;
    JPanel bg_img_panel;

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
        // get width and height of current screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // make window displays at center
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);

        // set background picture
        bg_img_panel = new JPanel();
        bg_img_panel.setBounds(0, 0, WIDTH, HEIGHT);
        bg_img_panel.setLayout(null);
        ImageIcon bg_img = new ImageIcon("src/img/bg_img.jpg");
        bg_img_label = new JLabel(bg_img);
        bg_img_label.setBounds(0,0,WIDTH,HEIGHT);
        bg_img_panel.add(bg_img_label);
        this.add(bg_img_panel);

    }
}
