package windows;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.User;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

public class SettingsWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtSaldoInicial;

	/**
	 * Create the frame.
	 */
	public SettingsWindow(User u) {
		ImageIcon icon = new ImageIcon("favicon.png");
		this.setIconImage(icon.getImage());
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToLogin();
			}
		});
		btnBackToLogin.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnBackToLogin.setBounds(55, 273, 399, 47);
		contentPane.add(btnBackToLogin);
		btnBackToLogin.setEnabled(false);
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnBackToMenu.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnBackToMenu.setBounds(55, 215, 399, 47);
		contentPane.add(btnBackToMenu);
		
		JLabel lblThisFeatureWill = new JLabel("This feature will be improved in the next");
		lblThisFeatureWill.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblThisFeatureWill.setBounds(15, 16, 409, 38);
		contentPane.add(lblThisFeatureWill);
		
		JLabel lblVersionOfThe = new JLabel("version of the app.");
		lblVersionOfThe.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblVersionOfThe.setBounds(25, 44, 399, 38);
		contentPane.add(lblVersionOfThe);
		
		txtSaldoInicial = new JTextField();
		txtSaldoInicial.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtSaldoInicial.setBounds(241, 98, 226, 38);
		contentPane.add(txtSaldoInicial);
		txtSaldoInicial.setColumns(10);
		
		JButton btnSetSaldo = new JButton("Change Initial Budget");
		btnSetSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSetSaldo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnSetSaldo.setBounds(55, 152, 399, 47);
		contentPane.add(btnSetSaldo);
		
		JLabel lblSaldo = new JLabel("Set Initial Budget: ");
		lblSaldo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblSaldo.setBounds(55, 106, 156, 20);
		contentPane.add(lblSaldo);
	}
	
	public void backToLogin(){
		
		int opcionSeleccionar = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?");
	
		if(opcionSeleccionar == JOptionPane.OK_OPTION){
			dispose();
			Login l = new Login(null);
			l.setVisible(true);
		}
	
	}
}
