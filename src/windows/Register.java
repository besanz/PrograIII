package windows;

/**
 * @author JON ANDER ARANA
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import data.User;
import db.DBConnector;
import db.InsertUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtName;
    private JPasswordField txtPass1;

    /**
     * Create the dialog.
     */
    public void setVisible(){
    	
    };
    public Register(User u) {
        this.setModal(true);
        setTitle("Register (It's free!)");
        setBounds(100, 100, 339, 447);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(240, 255, 240));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblName = new JLabel("Username:");
        lblName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblName.setBounds(15, 79, 108, 20);
        contentPanel.add(lblName);

        txtName = new JTextField();
        txtName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        txtName.setColumns(10);
        txtName.setBounds(138, 76, 146, 34);
        contentPanel.add(txtName);

        txtPass1 = new JPasswordField();
        txtPass1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        txtPass1.setBounds(138, 126, 146, 34);
        contentPanel.add(txtPass1);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblPassword.setBounds(15, 132, 92, 20);
        contentPanel.add(lblPassword);

        JButton btnNewButton = new JButton("Sign Up");
        btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	String name = txtName.getText();
            	String Password = txtPass1.getText();
            	
            	
            	InsertUser.addUser(name, Password);
            	
            	
            	dispose();
                
            }
        });
        btnNewButton.setBounds(74, 245, 172, 41);
        contentPanel.add(btnNewButton);

        JButton btnBack = new JButton("Back to Login");
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnBack.setBounds(74, 302, 172, 41);
        contentPanel.add(btnBack);
    }
}