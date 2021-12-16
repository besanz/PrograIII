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

public class ManageUsers extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ManageUsers(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(62, 46, 290, 164);
		contentPane.add(list);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToLogin(u);
			}
		});
		btnBack.setBounds(227, 234, 131, 29);
		contentPane.add(btnBack);

		JButton btnDelete = new JButton("Delete User");
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
