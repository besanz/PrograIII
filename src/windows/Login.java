package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	public Login() {
		setTitle("Login");
		getContentPane().setBackground(Color.ORANGE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Login");
		this.setResizable(false);
		this.setBounds(100, 100, 503, 383);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		txtUser = new JTextField();
		txtUser.setBounds(176, 99, 205, 26);
		this.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setBounds(50, 102, 69, 20);
		this.getContentPane().add(lblNewLabel);

		txtPass = new JPasswordField();
		txtPass.setBounds(176, 156, 205, 26);
		this.getContentPane().add(txtPass);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(50, 159, 111, 20);
		this.getContentPane().add(lblNewLabel_1);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean userSelect = false;
				ArrayList<User> userslist = SelectUser.selectUser();
				String UserTxt = txtUser.getText();
				String passwordTxt = txtPass.getText();

				for (User a : userslist) {
					if (UserTxt.equals(a.getUsername()) && passwordTxt.equals(a.getPassword())) {	
						
						JOptionPane.showMessageDialog(Login.this, "Welcome "+a.getUsername()+"!");
						
						MainWindow w = new MainWindow(a);
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

		btnLogIn.setBounds(176, 198, 205, 29);
		this.getContentPane().add(btnLogIn);

		btnRegister = new JButton("Sign Up");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register r = new Register();
				r.setVisible(true);
			}
		});

		btnRegister.setBounds(176, 243, 205, 29);
		this.getContentPane().add(btnRegister);
	}

}