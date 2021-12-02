package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Product;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProductInfo extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
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
		lblInformation.setBounds(289, 65, 126, 20);
		contentPane.add(lblInformation);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(331, 141, 123, 20);
		contentPane.add(lblId);
		label.setBounds(447, 312, 145, 41);
		contentPane.add(label);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(323, 231, 69, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(323, 334, 69, 20);
		contentPane.add(lblPicture);
		
		JPanel panel = new JPanel();
		panel.setBounds(269, 382, 146, 94);
		contentPane.add(panel);
		
		String id = p.getIdProduct()+"";
		JLabel lblId2 = new JLabel(id);
		lblId2.setBounds(323, 177, 69, 20);
		contentPane.add(lblId2);
		
		String price = p.getPrice()+"";
		JLabel lblNPrice2 = new JLabel(price);
		lblNPrice2.setBounds(333, 270, 69, 20);
		contentPane.add(lblNPrice2);
	}
}
