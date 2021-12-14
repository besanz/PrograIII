package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Product;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductInfo extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	/**
	 * @author JON ANDER ARANA
	 */

	/**
	 * Create the frame.
	 */
	public ProductInfo(Product p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformation = new JLabel("INFORMATION");
		lblInformation.setFont(new Font("Verdana", Font.BOLD, 27));
		lblInformation.setBounds(289, 65, 267, 20);
		contentPane.add(lblInformation);
		
		JLabel lblId = new JLabel("Id of the product:");
		lblId.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblId.setBounds(45, 137, 359, 20);
		contentPane.add(lblId);
		label.setBounds(447, 312, 145, 41);
		contentPane.add(label);
		
		JLabel lblPrice = new JLabel("Current Price");
		lblPrice.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblPrice.setBounds(45, 223, 176, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblPicture.setBounds(45, 312, 119, 20);
		contentPane.add(lblPicture);
		
		JPanel panel = new JPanel();
		panel.setBounds(300, 317, 146, 94);
		contentPane.add(panel);
		
		String id = p.getIdProduct()+"";
		JLabel lblId2 = new JLabel(id);
		lblId2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId2.setBounds(363, 140, 69, 20);
		contentPane.add(lblId2);
		
		String price = p.getPrice()+"";
		JLabel lblNPrice2 = new JLabel(price);
		lblNPrice2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNPrice2.setBounds(354, 226, 176, 20);
		contentPane.add(lblNPrice2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow j = new MainWindow(null);
				j.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(331, 538, 115, 29);
		contentPane.add(btnBack);
	}
}
