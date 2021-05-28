import javax.swing.*;
import java.awt.*;

public class LoginStart extends JFrame {

    final int WIDTH = 600;
    final int HEIGHT = 400;

    public LoginStart(){
        setVisible(true);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate(); // make components work
        init();
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
        setBounds(x, y, WIDTH, HEIGHT);
    }
}
