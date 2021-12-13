package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.User;
import db.InsertUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JPasswordField txtPass1;
	private JPasswordField txtPass2;

	/**
	 * Create the dialog.
	 */
	public Register() {
		setFont(new Font("Jokerman", Font.PLAIN, 12));
		this.setModal(true);
		setTitle("Welcome to our App!");
		setBounds(100, 100, 337, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(15, 45, 108, 20);
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 42, 146, 26);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		txtPass1 = new JPasswordField();
		txtPass1.setBounds(138, 84, 146, 25);
		contentPanel.add(txtPass1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(15, 87, 108, 20);
		contentPanel.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirm PassW:");
		lblConfirmarPassword.setBounds(15, 128, 118, 20);
		contentPanel.add(lblConfirmarPassword);
		
		txtPass2 = new JPasswordField();
		txtPass2.setBounds(138, 125, 146, 25);
		contentPanel.add(txtPass2);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser();
			}
		});
		btnNewButton.setBounds(80, 185, 146, 26);
		contentPanel.add(btnNewButton);
		
		JButton btnVolver = new JButton("Back");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(80, 227, 146, 26);
		contentPanel.add(btnVolver);
	}
	
	public void createUser(){
		
		if(this.txtPass1.getText().equals(this.txtPass2.getText())){
			
			//We need to add autoIncrementation.
			int idUser = 1;
			
			String username = this.txtNombre.getText();
			String password = this.txtPass1.getText();
			boolean isAdmin = false;
			
/**
 * Have to check this methods.
 * Previous version: 04-12-21
 * Last version: 13-12-21
 */
			InsertUser.addUser(idUser, username, password, isAdmin);
			
			
		}else{
			JOptionPane.showMessageDialog(this, "Passwords don't match!" );
		}
		
	}
}