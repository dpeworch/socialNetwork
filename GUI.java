
package socialnetwork;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    //ArrayList<User> users = new ArrayList<User>();
    private boolean loggedIn = true; //temporary, just for testing

    //GUI variables declaration
    private JPanel userBar;
    private JTextField searchField;
    private JButton searchButton;
    private JButton userPageButton;
    private JButton loginLogoutButton;
    private JPanel mainPanel;

    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        userBar = new JPanel();
        searchButton = new JButton();
        userPageButton = new JButton();
        searchField = new JTextField();
        loginLogoutButton = new JButton();
        mainPanel = new JPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        searchField.setText("Search");

        searchButton.setText("GO");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        userPageButton.setText("My Page");
        userPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                userPageActionPerformed(evt);
            }
        });

        if (loggedIn) {
            loginLogoutButton.setText("Logout");
        }
        else{
            loginLogoutButton.setText("Login");
        }
        loginLogoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginLogoutActionPerformed(evt);
            }
        });

        GroupLayout userBarLayout = new GroupLayout(userBar);
        userBar.setLayout(userBarLayout);
        userBarLayout.setHorizontalGroup(
            userBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, userBarLayout.createSequentialGroup()
                .addComponent(searchField, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addGap(20, 20, 20)
                .addComponent(userPageButton)
                .addGap(18, 18, 18)
                .addComponent(loginLogoutButton))
        );
        userBarLayout.setVerticalGroup(
            userBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(userBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(searchButton)
                .addComponent(userPageButton)
                .addComponent(loginLogoutButton))
        );

        GroupLayout mainLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userBar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }

    private void searchActionPerformed(ActionEvent evt) {
        
    }

    private void userPageActionPerformed(ActionEvent evt) {
        
    }

    private void loginLogoutActionPerformed(ActionEvent evt) {
        if (loggedIn) {
            loggedIn = false;
            loginLogoutButton.setText("Login");
        }
        else{
            loggedIn = true;
            loginLogoutButton.setText("Logout");
        }
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

}
