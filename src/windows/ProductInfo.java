package windows;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Product;
import data.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ProductInfo extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ProductInfo(Product p,User u) {
		
		ImageIcon icon = new ImageIcon("favicon.png");
		this.setIconImage(icon.getImage());
		setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Crypto ID ...................................");
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblId.setBounds(15, 32, 175, 20);
		contentPane.add(lblId);
		label.setBounds(447, 312, 145, 41);
		contentPane.add(label);
		
		JLabel lblPrice = new JLabel("Price .................................");
		lblPrice.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblPrice.setBounds(15, 82, 175, 20);
		contentPane.add(lblPrice);
		
		String id = p.getIdProduct()+"";
		JLabel lblId2 = new JLabel(id);
		lblId2.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lblId2.setBounds(205, 32, 69, 20);
		contentPane.add(lblId2);
		
	
		JLabel lblNPrice2 = new JLabel(p.getPrice()+"");
		lblNPrice2.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lblNPrice2.setBounds(205, 82, 69, 20);
		contentPane.add(lblNPrice2);
		
		JButton btnBack = new JButton("Return");
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Century Gothic", Font.ITALIC, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		btnBack.setBounds(60, 225, 145, 41);
		contentPane.add(btnBack);
		
		JLabel lblStock = new JLabel("Stock ..............................");
		lblStock.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblStock.setBounds(15, 139, 175, 20);
		contentPane.add(lblStock);
		
		JLabel lblStock1 = new JLabel(p.getStock()+"");
		lblStock1.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		lblStock1.setBounds(205, 139, 69, 20);
		contentPane.add(lblStock1);
	}
}
