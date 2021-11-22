package windows;

/**
 * @author Beñat
 */

import javax.swing.*;

import data.User;
import db.SelectUser;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Window;

public class Login extends JFrame {

	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		setTitle("Login");
		getContentPane().setBackground(Color.GREEN);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("BTC -- 100'000$");
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
						MainWindow w = new MainWindow();
						w.setVisible(true);
						dispose();
						userSelect = true;
					}
				}
				if (!userSelect) {
					Register r = new Register();
					r.setVisible(true);
					dispose();
					//JOptionPane.showMessageDialog(Login.this, "User does not exist");
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