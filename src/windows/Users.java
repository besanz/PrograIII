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
import java.awt.Color;
import javax.swing.UIManager;

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
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdOfThe = new JLabel("Id of the user:");
		lblIdOfThe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblIdOfThe.setBounds(48, 150, 295, 20);
		contentPane.add(lblIdOfThe);
		
		JLabel lblNameOfThe = new JLabel("Name of the user:");
		lblNameOfThe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblNameOfThe.setBounds(48, 239, 303, 20);
		contentPane.add(lblNameOfThe);
		
		JLabel lblIdAdminOr = new JLabel("Balance:");
		lblIdAdminOr.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblIdAdminOr.setBounds(48, 322, 303, 20);
		contentPane.add(lblIdAdminOr);
		
		JLabel lblInformation = new JLabel("INFORMATION");
		lblInformation.setFont(new Font("Verdana", Font.BOLD, 27));
		lblInformation.setBounds(138, 53, 267, 20);
		contentPane.add(lblInformation);
		
		
		JLabel lblNewLabel = new JLabel(u.getIdUser()+"");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(372, 153, 134, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(u.getUsername()+"");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(372, 242, 167, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(u.getSaldo()+"");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(372, 325, 167, 20);
		contentPane.add(lblNewLabel_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.GREEN);
		btnBack.setForeground(UIManager.getColor("Button.focus"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MainWindow window = new MainWindow(u);
				//		window.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(340, 406, 115, 29);
		contentPane.add(btnBack);
		
		JButton btnAddBalance = new JButton("Add Balance");
		btnAddBalance.setBackground(Color.GREEN);
		btnAddBalance.setForeground(new Color(0, 0, 0));
		btnAddBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingsWindow add = new SettingsWindow(u);
				add.setVisible(true);
				dispose();
			}
		});
		btnAddBalance.setBounds(48, 406, 134, 29);
		contentPane.add(btnAddBalance);
	}
}