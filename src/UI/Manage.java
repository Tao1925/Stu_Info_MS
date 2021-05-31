package UI;

import javax.swing.*;
import java.awt.*;

public class Manage extends JFrame {



    JMenuBar menuBar;
    JMenu menu;
    JMenuItem item;
    JPanel main_panel;

    final int WIDTH = 500;
    final int HEIGHT = 280;

    public Manage(){
        init();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        validate();
    }

    void init(){
        this.setLayout(null);
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

        // set menu bar
        menuBar = new JMenuBar();
        menu = new JMenu("Help");
        item = new JMenuItem("Setting");
        menu.add(item);
        menuBar.add(menu);

        this.setJMenuBar(menuBar);
        this.add(main_panel);
    }

}
