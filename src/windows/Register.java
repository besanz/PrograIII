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
	public static int saldo = 180000;

    private final JPanel contentPanel = new JPanel();
    private JTextField txtName;
    private JPasswordField txtPass1;
    private JPasswordField txtPass2;

    /**
     * Create the dialog.
     */
    public void setVisible(){
    	
    };
    public Register(User u) {
    	ImageIcon icon = new ImageIcon("favicon.png");
		this.setIconImage(icon.getImage());
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
        txtName.setBounds(148, 76, 136, 34);
        contentPanel.add(txtName);

        txtPass1 = new JPasswordField();
        txtPass1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        txtPass1.setBounds(148, 126, 136, 34);
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
            	
            	boolean isAdmin = false;
            	
            	if(txtPass1.getText().equals(txtPass2.getText())){
            	InsertUser.addUser(name, Password, isAdmin, saldo);
            	
            	JOptionPane.showMessageDialog(Register.this, name + ", welcome to Binance!");
            	dispose();
 
            	}
            	else{
            		JOptionPane.showMessageDialog(Register.this, "Passwords don't match");
            	}
                
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
        
        txtPass2 = new JPasswordField();
        txtPass2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        txtPass2.setBounds(148, 177, 136, 34);
        contentPanel.add(txtPass2);
        
        JLabel lblPassword2 = new JLabel("Confirm PSW:");
        lblPassword2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblPassword2.setBounds(15, 185, 118, 20);
        contentPanel.add(lblPassword2);
    }
}