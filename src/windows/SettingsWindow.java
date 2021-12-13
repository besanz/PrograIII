package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SettingsWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SettingsWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.setBounds(35, 279, 144, 29);
		contentPane.add(btnBackToLogin);
	}
}
