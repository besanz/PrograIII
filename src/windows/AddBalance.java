package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBalance extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AddBalance(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(53, 110, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAddBalance = new JButton("Add balance");
		btnAddBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String balance = textField.getText();
				int NewBalance=Integer.parseInt(balance);
				db.DBConnector.insertsaldo(NewBalance);
				Users window = new Users(u);
				window.setVisible(true);
				dispose();
			}
		});
		btnAddBalance.setBounds(253, 109, 132, 29);
		contentPane.add(btnAddBalance);
	}
}
