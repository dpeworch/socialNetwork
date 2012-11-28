
package socialnetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI3 extends JFrame {

    private int view = 0;

    private boolean loggedIn = false; //temporary, just for testing

    //GUI variables declaration
    private JPanel topPanel;
    private JPanel userBar;
    private JPanel title;
    private JTextField searchField;
    private JButton searchButton;
    private JButton userPageButton;
    private JButton loginLogoutButton;
    private JLabel pageTitle;

    private JPanel centerPanel;

    public GUI3() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        userBar = new JPanel();
        searchField = new JTextField("");
        searchField.setPreferredSize(new Dimension(65, 30));
        searchButton = new JButton("GO");
        searchButton.setPreferredSize(new Dimension(55, 30));
        userPageButton = new JButton("My Page");
        userPageButton.setPreferredSize(new Dimension(85, 30));
        loginLogoutButton = new JButton("Login");
        loginLogoutButton.setPreferredSize(new Dimension(75, 30));
        userBar.add(searchField);
        userBar.add(searchButton);
        userBar.add(userPageButton);
        userBar.add(loginLogoutButton);
        title = new JPanel();
        pageTitle = new JLabel("Login or Register");
        pageTitle.setFont(new Font("Serif", Font.PLAIN, 24));
        title.add(pageTitle);
        topPanel.add(userBar, BorderLayout.PAGE_START);
        topPanel.add(title, BorderLayout.PAGE_END);
        add(topPanel, BorderLayout.PAGE_START);

        if (view == 0) {
            loginPage();
        }
        else{
            homePage();
        }

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        userPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                userPageActionPerformed(evt);
            }
        });

        loginLogoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginLogoutActionPerformed(evt);
            }
        });

        //pack();
    }

    private void searchActionPerformed(ActionEvent evt) {
        
    }

    private void userPageActionPerformed(ActionEvent evt) {
        
    }

    private void loginLogoutActionPerformed(ActionEvent evt) {
        if (loggedIn) {
            loggedIn = false;
            loginLogoutButton.setText("Login");
            pageTitle.setText("Login or Register");
            view = 0;
            loginPage();
        }
        else{
            loggedIn = true;
            loginLogoutButton.setText("Logout");
            pageTitle.setText("Home Page");
            view = 1;
            homePage();
        }
    }

    private void homePage() { //hardcoded for now
        //Container pane = getContentPane();
        //pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        //centerPanel = new JPanel(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        centerPanel = new JPanel(new GridLayout(10,1));
        JPanel[] tweets = new JPanel[2];
        JLabel[] tweeters = new JLabel[2];
        JLabel[] messages = new JLabel[2];
        tweets[0] = new JPanel(new FlowLayout());
        tweets[1] = new JPanel(new FlowLayout());
        tweeters[0] = new JLabel("Person");
        tweeters[0].setForeground(Color.BLUE);
        tweeters[1] = new JLabel("Other Person");
        tweeters[1].setForeground(Color.BLUE);
        messages[0] = new JLabel("I am going to the mall #beermall");
        messages[1] = new JLabel("I am going to the beer #mallbeer");
        tweets[0].add(tweeters[0]);
        tweets[0].add(messages[0]);
        tweets[1].add(tweeters[1]);
        tweets[1].add(messages[1]);
        centerPanel.add(tweets[0]);
        centerPanel.add(tweets[1]);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void loginPage() {
        centerPanel = new JPanel();
        centerPanel.add(new JLabel("EMPTY PAGE!!!"));
        add(centerPanel, BorderLayout.CENTER);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        GUI3 gui = new GUI3();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setResizable(false);
        gui.setSize(500, 500);
        gui.setVisible(true);
        /*EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });*/
    }

}
