package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
/**
 * @author Beñat
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import data.User;
import db.SelectUser;
import java.awt.Font;

public class Login extends JFrame {

	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Login(User u) {
		setTitle("Login");
		getContentPane().setBackground(new Color(255, 215, 0));
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		this.setTitle("Login");
		this.setResizable(false);
		this.setBounds(100, 100, 451, 364);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtUser.setToolTipText("Example: Peru");
		txtUser.setBounds(167, 46, 198, 31);
		this.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 39, 111, 41);
		this.getContentPane().add(lblNewLabel);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtPass.setToolTipText("Example: Peru");
		txtPass.setBounds(167, 110, 198, 31);
		this.getContentPane().add(txtPass);
		

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 113, 111, 20);
		this.getContentPane().add(lblNewLabel_1);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean userSelect = false;
				ArrayList<User> userslist = SelectUser.selectUser();
				String UserTxt = txtUser.getText();
				String passwordTxt = txtPass.getText();

				for (User a : userslist) {
					if (UserTxt.equals(a.getUsername()) && passwordTxt.equals(a.getPassword())) {	
						
						JOptionPane.showMessageDialog(Login.this, "Welcome "+a.getUsername()+"!");
						
						MainWindow w = new MainWindow(a, null);
						w.setVisible(true);
						dispose();
						userSelect = true;
						
					}
				}
				if (!userSelect) {
					
					JOptionPane.showMessageDialog(Login.this, "User does not exist");
				}

			}
		});

		btnLogIn.setBounds(111, 177, 205, 29);
		this.getContentPane().add(btnLogIn);


		btnRegister = new JButton("Sign Up");
		btnRegister.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register r = new Register(u);
				r.setVisible(true);
			}
		});

		btnRegister.setBounds(111, 222, 205, 29);
		this.getContentPane().add(btnRegister);
	}

}