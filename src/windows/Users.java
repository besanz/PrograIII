package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.User;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Users extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Users(User u) {
		ImageIcon icon = new ImageIcon("favicon.png");
		this.setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdOfThe = new JLabel("Id of the user:");
		lblIdOfThe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblIdOfThe.setBounds(48, 150, 359, 20);
		contentPane.add(lblIdOfThe);
		
		JLabel lblNameOfThe = new JLabel("Name of the user:");
		lblNameOfThe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblNameOfThe.setBounds(48, 239, 359, 20);
		contentPane.add(lblNameOfThe);
		
		JLabel lblIdAdminOr = new JLabel("Id admin or not:");
		lblIdAdminOr.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblIdAdminOr.setBounds(48, 322, 359, 20);
		contentPane.add(lblIdAdminOr);
		
		JLabel lblInformation = new JLabel("INFORMATION");
		lblInformation.setFont(new Font("Verdana", Font.BOLD, 27));
		lblInformation.setBounds(272, 49, 267, 20);
		contentPane.add(lblInformation);
		
		
		JLabel lblNewLabel = new JLabel(u.getIdUser()+"");
		lblNewLabel.setBounds(372, 153, 244, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(u.getUsername()+"");
		lblNewLabel_1.setBounds(372, 242, 167, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(u.getSaldo()+"");
		lblNewLabel_2.setBounds(372, 325, 167, 20);
		contentPane.add(lblNewLabel_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MainWindow window = new MainWindow(u);
				//		window.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(232, 407, 115, 29);
		contentPane.add(btnBack);
	}
}