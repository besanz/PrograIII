package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.User;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ManageUsers extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ManageUsers(User u) {
		setTitle("User Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setFont(new Font("Consolas", Font.PLAIN, 18));
		list.setBackground(new Color(175, 238, 238));
		list.setBounds(62, 46, 290, 164);
		contentPane.add(list);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToLogin(u);
			}
		});
		btnBack.setBounds(220, 234, 138, 29);
		contentPane.add(btnBack);

		JButton btnDelete = new JButton("Delete User");
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDelete.setBounds(62, 234, 131, 29);
		contentPane.add(btnDelete);
	}

	public void backToLogin(User u) {

		int opcionSeleccionar = JOptionPane.showConfirmDialog(this, "Are you sure?");

		if (opcionSeleccionar == JOptionPane.OK_OPTION) {
			dispose();
			Login l = new Login(u);
			l.setVisible(true);
		
	}
}
}
