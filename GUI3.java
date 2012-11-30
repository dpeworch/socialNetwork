
package socialnetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI3 extends JFrame {
    
    private static int windowWidth = 800;
    private static int windowHeight = 600;
    
    private int userID;
    
    private boolean loggedIn = false; //temporary, just for testing
    
    private Database db;
    
    //User Bar variable declarations
    private JPanel topPanel; //information displayed at the top of the screen, composed of userBar and title
    private JPanel userBar; //a button panel with user options
    private JPanel title; //panel for the page title
    private JTextField searchField;
    private JButton searchButton;
    private JButton userPageButton;
    private JButton addPostButton;
    private JButton registerButton;
    private JButton loginLogoutButton;
    private JLabel pageTitle;

    private JPanel centerPanel;
    private JPanel formPanel;

    //Login and Register variable declarations
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JButton registerSubmit;
    private JButton loginSubmit;
    private JPanel buttonPanel;


    JLabel[] tweeters = new JLabel[2];
    JLabel[] messages = new JLabel[2];
    JButton older;
    JButton newer;



    
    public GUI3() {
        initComponents();
    }
    
    private void initComponents() {
        db = new Database();
        userID = -1;
        
        setLayout(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        userBar = new JPanel();
        searchField = new JTextField("");
        searchField.setPreferredSize(new Dimension(65, 30));
        searchButton = new JButton("GO");
        searchButton.setPreferredSize(new Dimension(55, 30));
        userPageButton = new JButton("My Page");
        userPageButton.setPreferredSize(new Dimension(85, 30));
        userPageButton.setEnabled(false);
        addPostButton = new JButton("Post");
        addPostButton.setPreferredSize(new Dimension(85, 30));
        addPostButton.setEnabled(false);
        registerButton = new JButton("Register Page");
        registerButton.setPreferredSize(new Dimension(115, 30));
        loginLogoutButton = new JButton("Login Page");
        loginLogoutButton.setPreferredSize(new Dimension(100, 30));
        userBar.add(searchField);
        userBar.add(searchButton);
        userBar.add(userPageButton);
        userBar.add(addPostButton);
        userBar.add(registerButton);
        userBar.add(loginLogoutButton);
        title = new JPanel();
        pageTitle = new JLabel("Welcome to Not-Twitter!");
        pageTitle.setFont(new Font("Serif", Font.PLAIN, 24));
        title.add(pageTitle);
        topPanel.add(userBar, BorderLayout.NORTH);
        topPanel.add(title, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.PAGE_START);

        formPanel = new JPanel(new FormLayout(windowWidth));
        centerPanel = new JPanel(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        buttonPanel = new JPanel(new FlowLayout());

        usernameLabel = new JLabel("Enter your username: ");
        usernameField = new JTextField(15);
        passwordLabel = new JLabel("Enter your password: ");
        passwordField = new JTextField(15);
        emailLabel = new JLabel("Enter your email address: ");
        emailField = new JTextField(15);
        registerSubmit = new JButton("Register");
        registerSubmit.setPreferredSize(new Dimension(85, 30));
        loginSubmit = new JButton("Login");
        loginSubmit.setPreferredSize(new Dimension(85, 30));

        tweeters[0] = new JLabel("First Person");
        tweeters[0].setForeground(Color.BLUE);
        tweeters[1] = new JLabel("Second Person");
        tweeters[1].setForeground(Color.BLUE);
        messages[0] = new JLabel("I am going to the mall #beermall");
        messages[1] = new JLabel("I am going to the beer #mallbeer");
        older = new JButton("OLDER");
        older.setPreferredSize(new Dimension(85, 30));
        newer = new JButton("NEWER");
        newer.setPreferredSize(new Dimension(85, 30));

        db.addNewUser("person", "secret");

        registerPage();

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

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        loginLogoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginLogoutActionPerformed(evt);
            }
        });
        
        registerSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerSubmitActionPerformed(evt);
            }
        });
        
        loginSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginSubmitActionPerformed(evt);
            }
        });

        //pack();
    }

    private void searchActionPerformed(ActionEvent evt) {
        
    }

    private void userPageActionPerformed(ActionEvent evt) {
        
    }

    private void registerActionPerformed(ActionEvent evt) {
        registerPage();
    }

    private void loginLogoutActionPerformed(ActionEvent evt) {
        if (loggedIn) {
            loggedIn = false;
            loginLogoutButton.setText("Login Page");
            userPageButton.setEnabled(false);
            addPostButton.setEnabled(false);
            registerButton.setEnabled(true);
        }
        loginPage();
    }
    
    private void registerSubmitActionPerformed(ActionEvent evt) {
        
    }
    
    private void loginSubmitActionPerformed(ActionEvent evt) {
	// call function to actually log in
	// function returns userid -> userID;
	// userID = db.login(username, password);
	// if (userID >= 0) {

        String username = usernameField.getText();
        String password = passwordField.getText();
        userID = db.findUser(username, password);
        if (userID >= 0) {
            loggedIn = true;
            loginLogoutButton.setText("Logout");
            userPageButton.setEnabled(true);
            registerButton.setEnabled(false);
            addPostButton.setEnabled(true);
            homePage();
        }
        else {
            loginPage();
        }
	//}
	// else {
	// userID = -1;
	//loginPage();
	// }
    }

    private void homePage() { //hardcoded for now
        pageTitle.setText("Home Page");
        formPanel.removeAll();
        buttonPanel.removeAll();
        centerPanel.removeAll();
        formPanel.add(tweeters[0], 0, 0);
        formPanel.add(messages[0], 0, 1);
        formPanel.add(tweeters[1], 0, 0);
        formPanel.add(messages[1], 0, 1);
        buttonPanel.add(older);
        buttonPanel.add(newer);
        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        older.setVisible(true);
        newer.setVisible(true);
        registerSubmit.setVisible(false);
        loginSubmit.setVisible(false);
    }

    private void registerPage() {
        pageTitle.setText("Welcome to Not-Twitter!  Register here.");
        formPanel.removeAll();
        buttonPanel.removeAll();
        centerPanel.removeAll();
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        buttonPanel.add(registerSubmit);
        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        registerSubmit.setVisible(true);
        loginSubmit.setVisible(false);
        older.setVisible(false);
        newer.setVisible(false);
        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");
    }

    private void loginPage() {
        pageTitle.setText("Welcome to Not-Twitter!  Login here.");
        formPanel.removeAll();
        buttonPanel.removeAll();
        centerPanel.removeAll();
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        buttonPanel.add(loginSubmit);
        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        loginSubmit.setVisible(true);
        registerSubmit.setVisible(false);
        older.setVisible(false);
        newer.setVisible(false);
        usernameField.setText("");
        passwordField.setText("");
    }

    private void searchResultPage() {

    }

    private void userPage() {
        
    }

    private void yourPage() {
    
    }

    private void subsPage() {

    }

    private void forAllPages() {
        // search, login/logout, notifications
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       GUI3 gui = new GUI3();
       gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
       gui.setResizable(false);
       gui.setSize(windowWidth, windowHeight);
       gui.setBounds(screenSize.width/2 - windowWidth/2, 5, windowWidth, windowHeight);
       gui.setVisible(true);

       /*EventQueue.invokeLater(new Runnable() {
        public void run() {
            new GUI().setVisible(true);
        }
        });*/
    }
}
