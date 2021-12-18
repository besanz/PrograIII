package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import data.Product;
import data.User;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
		
		ImageIcon icon = new ImageIcon("favicon.png");
		this.setIconImage(icon.getImage());
		setTitle("User Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<User> selectUser = db.SelectUser.selectUser();
		
		DefaultListModel<User>model2=new DefaultListModel<User>();
		for(User a: selectUser)
		{
		model2.addElement(a);
		}

		JList list2 = new JList();
		list2.setFont(new Font("Consolas", Font.PLAIN, 18));
		list2.setBackground(new Color(175, 238, 238));
		list2.setBounds(80, 54, 463, 399);
		list2.setModel(model2);
		contentPane.add(list2);
		
		
	//	JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(15, 161, 432, 216);
		//scrollPane.setViewportView(list2);
		//contentPane.add(scrollPane);
		
		

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToLogin(u);
			}
		});
		btnBack.setBounds(405, 493, 138, 29);
		contentPane.add(btnBack);
		
		JButton btnDelete = new JButton("Delete User");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = (User) list2.getSelectedValue();
				
				db.DeleteDb.delete(user.getUsername());
				DefaultListModel<User> model = new DefaultListModel<User>();
				ArrayList<User> listaNueva = db.SelectUser.selectUser();
				for(User u : listaNueva){
					model.addElement(u);
				}
				list2.setModel(model);
				
			}
		});
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDelete.setBounds(108, 493, 131, 29);
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
