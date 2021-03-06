
package socialnetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI3 extends JFrame {
    
    private static int windowWidth = 800;
    private static int windowHeight = 600;
    private Database db;
    
    //User Bar variable declarations
    private JPanel topPanel; //information displayed at the top of the screen, composed of userBar and title
    private JPanel userBar; //a button panel with user options
    private JPanel title; //panel for the page title
    private JTextField searchField; //in UserBar
    private JButton searchButton; //in UserBar
    private JButton userPageButton; //in UserBar
    private JButton addPostButton; //in UserBar
    private JButton registerButton; //in UserBar
    private JButton loginLogoutButton; //in UserBar
    private JLabel pageTitle; //in title

    private JPanel centerPanel; //main panel for all pages
    private JPanel formPanel; //panel for forms

    //Login and Register variable declarations
    private JLabel usernameLabel; //label for username field
    private JTextField usernameField; //field for entering username
    private JLabel passwordLabel; //label for password field
    private JPasswordField passwordField; //field for entering password
    private JLabel emailLabel; //label for email field
    private JTextField emailField; //field for entering email
    private JButton registerSubmit; //submit button for registering
    private JButton loginSubmit; //submit button for logging in
    private JPanel buttonPanel; //panel for submiting form info or displaying different tweets

    private JPanel messagePanel; //panel for displaying error messages
    private JLabel message; //label for displaying an error message

    private JLabel[] tweeters = new JLabel[2]; //hardcoded tweet posters
    private JLabel[] tweetBody = new JLabel[2]; //hardcoded tweet messages
    private JButton older; //button to show older tweets
    private JButton newer; //button to show newer tweets
    private JPanel subscribePanel; //panel with buttons that subscribe to users
    private JButton subscribeTo0; //button to subscribe to user 0
    private JButton subscribeTo1; //button to subscribe to user 1
    private JButton subscribeTo2; //button to subscribe to user 2
    private JButton subscribeTo3; //button to subscribe to user 3
    private JButton unsubscribeFrom0; //button to subscribe to user 0
    private JButton unsubscribeFrom1; //button to subscribe to user 1
    private JButton unsubscribeFrom2; //button to subscribe to user 2
    private JButton unsubscribeFrom3; //button to subscribe to user 3

    public GUI3() {
        initComponents();
    }
    
    private void initComponents() {
        db = new Database();        
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
        pageTitle = new JLabel();
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
        passwordField = new JPasswordField(15);
        emailLabel = new JLabel("Enter your email address: ");
        emailField = new JTextField(15);
        registerSubmit = new JButton("Register");
        registerSubmit.setPreferredSize(new Dimension(85, 30));
        loginSubmit = new JButton("Login");
        loginSubmit.setPreferredSize(new Dimension(85, 30));

        messagePanel = new JPanel();
        message = new JLabel();
        message.setFont(new Font("Serif", Font.PLAIN, 18));
        messagePanel.add(message);

        tweeters[0] = new JLabel("First Person");
        tweeters[0].setForeground(Color.BLUE);
        tweeters[1] = new JLabel("Second Person");
        tweeters[1].setForeground(Color.BLUE);
        tweetBody[0] = new JLabel("I am going to the mall #beermall");
        tweetBody[1] = new JLabel("I am going to the beer #mallbeer");
        older = new JButton("OLDER");
        older.setPreferredSize(new Dimension(85, 30));
        newer = new JButton("NEWER");
        newer.setPreferredSize(new Dimension(85, 30));
        subscribePanel = new JPanel(new GridLayout(2,4));
        subscribeTo0 = new JButton("Subscribe 0");
        subscribeTo1 = new JButton("Subscribe 1");
        subscribeTo2 = new JButton("Subscribe 2");
        subscribeTo3 = new JButton("Subscribe 3");
        unsubscribeFrom0 = new JButton("Un-subscribe 0");
        unsubscribeFrom1 = new JButton("Un-subscribe 1");
        unsubscribeFrom2 = new JButton("Un-subscribe 2");
        unsubscribeFrom3 = new JButton("Un-subscribe 3");
        subscribePanel.add(subscribeTo0);
        subscribePanel.add(subscribeTo1);
        subscribePanel.add(subscribeTo2);
        subscribePanel.add(subscribeTo3);
        subscribePanel.add(unsubscribeFrom0);
        subscribePanel.add(unsubscribeFrom1);
        subscribePanel.add(unsubscribeFrom2);
        subscribePanel.add(unsubscribeFrom3);

        registerPage(-1);

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

        subscribeTo0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subscribeToActionPerformed(evt, 0);
            }
        });

        subscribeTo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subscribeToActionPerformed(evt, 1);
            }
        });

        subscribeTo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subscribeToActionPerformed(evt, 2);
            }
        });

        subscribeTo3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subscribeToActionPerformed(evt, 3);
            }
        });

        unsubscribeFrom0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                unsubscribeFromActionPerformed(evt, 0);
            }
        });

        unsubscribeFrom1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                unsubscribeFromActionPerformed(evt, 1);
            }
        });

        unsubscribeFrom2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                unsubscribeFromActionPerformed(evt, 2);
            }
        });

        unsubscribeFrom3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                unsubscribeFromActionPerformed(evt, 3);
            }
        });
    }

    private void searchActionPerformed(ActionEvent evt) {
        
    }

    private void userPageActionPerformed(ActionEvent evt) {
        
    }

    private void registerActionPerformed(ActionEvent evt) {
        registerPage(-1);
    }

    private void loginLogoutActionPerformed(ActionEvent evt) {
        if (db.getCurrentUser() != null) {
            db.logout();
            loginLogoutButton.setText("Login Page");
            userPageButton.setEnabled(false);
            addPostButton.setEnabled(false);
            registerButton.setEnabled(true);
        }
        loginPage(false);
    }
    
    private void registerSubmitActionPerformed(ActionEvent evt) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
        int situation = db.validateRegistrationInfo(username, password, email);
        if (situation == 5) {
            db.addNewUser(username, password, email);
        }
        registerPage(situation);
    }
    
    private void loginSubmitActionPerformed(ActionEvent evt) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        User current = db.findUser(username, password);
        if (current != null) {
            db.login(current);
            loginLogoutButton.setText("Logout");
            userPageButton.setEnabled(true);
            registerButton.setEnabled(false);
            addPostButton.setEnabled(true);
            homePage();
        }
        else {
            loginPage(true);
        }
    }

    private void subscribeToActionPerformed(ActionEvent evt, int id) {
        if (db.getUsers().size() > id &&
                db.getCurrentUser().getUserId() != id &&
                !db.getCurrentUser().subscribesTo(id)) {
            db.addSubscription(db.getCurrentUser(), id);
        }
    }

    private void unsubscribeFromActionPerformed(ActionEvent evt, int id) {
        db.removeSubscription(db.getCurrentUser(), id);
    }

    private void homePage() { //hardcoded for now
        pageTitle.setText("Home Page of " + db.getCurrentUser().getUsername());
        formPanel.removeAll();
        buttonPanel.removeAll();
        centerPanel.removeAll();
        formPanel.add(tweeters[0], 0, 0);
        formPanel.add(tweetBody[0], 0, 1);
        formPanel.add(tweeters[1], 0, 0);
        formPanel.add(tweetBody[1], 0, 1);
        buttonPanel.add(older);
        buttonPanel.add(newer);
        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(subscribePanel, BorderLayout.SOUTH);
        older.setVisible(true);
        newer.setVisible(true);
        subscribeTo0.setVisible(true);
        subscribeTo1.setVisible(true);
        unsubscribeFrom0.setVisible(true);
        unsubscribeFrom1.setVisible(true);
        registerSubmit.setVisible(false);
        loginSubmit.setVisible(false);
    }

    private void registerPage(int situation) {
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
        centerPanel.add(messagePanel, BorderLayout.SOUTH);
        if (situation == -1) {
            message.setText("");
            usernameField.setText("");
            passwordField.setText("");
            emailField.setText("");
        }
        else if (situation == 0) {
            message.setForeground(Color.RED);
            message.setText("You forgot to enter at least one of the fields.  Please try again.");
        }
        else if (situation == 1) {
            message.setForeground(Color.RED);
            message.setText("There is already a user with that username.  Please pick a different username.");
        }
        else if (situation == 2) {
            message.setForeground(Color.RED);
            message.setText("Your username cannot contain a space.  Please try again.");
        }
        else if (situation == 3) {
            message.setForeground(Color.RED);
            message.setText("Your password cannot contain a space.  Please try again.");
        }
        else if (situation == 4) {
            message.setForeground(Color.RED);
            message.setText("Your email is not in the correct form.  Please try again.");
        }
        else{
            message.setForeground(Color.GREEN);
            message.setText("You were registered successfully!");
            usernameField.setText("");
            passwordField.setText("");
            emailField.setText("");
        }
        registerSubmit.setVisible(true);
        loginSubmit.setVisible(false);
        older.setVisible(false);
        newer.setVisible(false);
        subscribeTo0.setVisible(false);
        subscribeTo1.setVisible(false);
        unsubscribeFrom0.setVisible(false);
        unsubscribeFrom1.setVisible(false);
    }

    private void loginPage(boolean error) {
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
        centerPanel.add(messagePanel, BorderLayout.SOUTH);
        if (error) {
            message.setForeground(Color.RED);
            message.setText("You entered the wrong username or password.  Try again.");
        }
        else{
            message.setText("");
            usernameField.setText("");
            passwordField.setText("");
        }
        loginSubmit.setVisible(true);
        registerSubmit.setVisible(false);
        older.setVisible(false);
        newer.setVisible(false);
        subscribeTo0.setVisible(false);
        subscribeTo1.setVisible(false);
        unsubscribeFrom0.setVisible(false);
        unsubscribeFrom1.setVisible(false);
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
