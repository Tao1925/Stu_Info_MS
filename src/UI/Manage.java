package UI;

import event.AccountEvent;
import style.MyFonts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Manage extends JFrame {



    JMenuBar menuBar;
    JMenu menu1,menu2;
    JMenuItem menuItem1_1,menuItem1_2,menuItem1_3;
    JMenuItem menuItem2_1,menuItem2_2;
    JPanel info_panel;
    JLabel name_label;
    JTextField name_textField;
    JLabel age_label;
    JTextField age_textField;
    JLabel class_label;
    JTextField class_textField;
    JLabel stuId_label;
    JTextField stuId_textField;
    ButtonGroup sex_buttonGroup;
    JRadioButton men_radioButton,women_radioButton;
    JButton add_button;
    JButton delete_button;
    JButton change_button;
    JButton find_button;
    JButton reset_button;
    JPanel form_panel;
    JPanel main_panel;
    public static JTextArea result_textArea;
    ActionListener menu1_listener,menu2_listener;
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);

    final int WIDTH = 850;
    final int HEIGHT = 800;
    // form data
    Object[] columns = {"Name","Sex","Age","Class","StuID"};
    static Object[][] a; //  title info
    static int row;
    static DefaultTableModel model;
    static TableColumnModel columnModel;
    JTable my_table = null;
    JScrollPane scrollPane;
    static Vector rwo;

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
        menu1 = new JMenu("Manage");
        menuItem1_1 = new JMenuItem("Show online account");
        menuItem1_2 = new JMenuItem("Show all account");
        menuItem1_3 = new JMenuItem("Change account info");
        menu2 = new JMenu("Setting");
        menuItem2_1 = new JMenuItem("Log out");
        menuItem2_2 = new JMenuItem("Exit");
        menu1.add(menuItem1_1);
        menu1.add(menuItem1_2);
        menu1.add(menuItem1_3);
        menuBar.add(menu1);
        menu2.add(menuItem2_1);
        menu2.add(menuItem2_2);
        menuBar.add(menu2);

        // set info panel
        info_panel = new JPanel();
        info_panel.setLayout(flowLayout);
        info_panel.setBorder(BorderFactory.createTitledBorder("basic info manage"));
        info_panel.setBounds(0,0,WIDTH,100);

        name_label = new JLabel("Name");
        name_label.setFont(MyFonts.plain_font);
        name_textField = new JTextField(6);
        name_textField.setFont(MyFonts.plain_font);
        info_panel.add(name_label);
        info_panel.add(name_textField);

        men_radioButton = new JRadioButton("Men");
        men_radioButton.setFont(MyFonts.plain_font);
        women_radioButton = new JRadioButton("Women");
        women_radioButton.setFont(MyFonts.plain_font);
        sex_buttonGroup = new ButtonGroup();
        sex_buttonGroup.add(men_radioButton);
        sex_buttonGroup.add(women_radioButton);
        info_panel.add(men_radioButton);
        info_panel.add(women_radioButton);

        age_label = new JLabel("Age:");
        age_label.setFont(MyFonts.plain_font);
        age_textField = new JTextField(2);
        age_textField.setFont(MyFonts.plain_font);
        info_panel.add(age_label);
        info_panel.add(age_textField);

        class_label = new JLabel("Class:");
        class_label.setFont(MyFonts.plain_font);
        class_textField = new JTextField(4);
        class_textField.setFont(MyFonts.plain_font);
        info_panel.add(class_label);
        info_panel.add(class_textField);

        stuId_label = new JLabel("Student ID:");
        stuId_label.setFont(MyFonts.plain_font);
        stuId_textField = new JTextField(6);
        stuId_textField.setFont(MyFonts.plain_font);
        info_panel.add(stuId_label);
        info_panel.add(stuId_textField);

        add_button = new JButton("Add");
        add_button.setFont(MyFonts.button_font);
        info_panel.add(add_button);
        delete_button = new JButton("Delete");
        delete_button.setFont(MyFonts.button_font);
        info_panel.add(delete_button);
        change_button = new JButton("Change");
        change_button.setFont(MyFonts.button_font);
        info_panel.add(change_button);
        find_button = new JButton("Find");
        find_button.setFont(MyFonts.button_font);
        info_panel.add(find_button);
        reset_button = new JButton("Reset");
        reset_button.setFont(MyFonts.button_font);
        info_panel.add(reset_button);
        main_panel.add(info_panel);

        // set form panel
        form_panel = new JPanel();
        form_panel.setLayout(flowLayout);
        form_panel.setBounds(0,100,WIDTH,300);
        form_panel.setBorder(BorderFactory.createTitledBorder("showing data"));
        table();
        // form_panel.add(my_table);
        form_panel.add(scrollPane);
        main_panel.add(form_panel);

        // set result TextArea
        result_textArea = new JTextArea();
        result_textArea.setBounds(0,410,WIDTH,150);
        result_textArea.setBorder(BorderFactory.createTitledBorder("account info"));
        result_textArea.setEditable(false);
        main_panel.add(result_textArea);

        this.setJMenuBar(menuBar);
        this.add(main_panel);

        setAllName();
        allEvent();
    }

    void table(){
        my_table = getTable();
        scrollPane = new JScrollPane(my_table);
        scrollPane.setPreferredSize(new Dimension(WIDTH-30,260));
        my_table.setPreferredSize(new Dimension(WIDTH-30,1000));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);// put scrollbar in a view
    }

    JTable getTable(){
        if (my_table == null){
            my_table = new JTable();
            int[] columnWidth = {100, 100, 100, 100, 100};
            model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.setColumnIdentifiers(columns);
            my_table.setModel(model);
            columnModel=my_table.getColumnModel();
            my_table.getTableHeader().setReorderingAllowed(false);
            my_table.getTableHeader().setResizingAllowed(false);
            int count  = columnModel.getColumnCount();
            for (int i = 0; i < count; i++){
                TableColumn column = columnModel.getColumn(i);
                column.setPreferredWidth(columnWidth[i]);
            }
            rwo = new Vector(5);
        }
        return my_table;
    }

    void setAllName(){
        menuItem1_1.setName("item1_1");
        menuItem1_2.setName("item1_2");
        menuItem1_3.setName("item1_3");
        menuItem2_1.setName("item2_1");
        menuItem2_2.setName("item2_2");
    }

    void allEvent(){
        menu1_listener = new AccountEvent();
        menuItem1_1.addActionListener(menu1_listener);
        menuItem1_2.addActionListener(menu1_listener);
        menuItem1_3.addActionListener(menu1_listener);
        menu2_listener = new AccountEvent();
        menuItem2_1.addActionListener(menu2_listener);
        menuItem2_2.addActionListener(menu2_listener);
    }
}
