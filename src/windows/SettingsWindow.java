package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

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
		
		JLabel lblYourProfile = new JLabel("Your Profile");
		lblYourProfile.setBounds(61, 67, 69, 20);
		contentPane.add(lblYourProfile);
	}
}
