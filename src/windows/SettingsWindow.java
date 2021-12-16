package windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class SettingsWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SettingsWindow() {
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnBackToLogin.setBounds(55, 249, 399, 47);
		contentPane.add(btnBackToLogin);
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBackToMenu.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnBackToMenu.setBounds(55, 172, 399, 47);
		contentPane.add(btnBackToMenu);
		
		JLabel lblThisFeatureWill = new JLabel("This feature will be added in the next");
		lblThisFeatureWill.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblThisFeatureWill.setBounds(74, 55, 363, 38);
		contentPane.add(lblThisFeatureWill);
		
		JLabel lblVersionOfThe = new JLabel("version of the app.");
		lblVersionOfThe.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblVersionOfThe.setBounds(74, 77, 399, 38);
		contentPane.add(lblVersionOfThe);
	}
}
