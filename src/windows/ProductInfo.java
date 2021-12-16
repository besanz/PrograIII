package windows;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Product;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ProductInfo extends JDialog {

	private JPanel contentPane;
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ProductInfo(Product p) {
		setTitle("Currency Information");
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(125, 52, 123, 20);
		contentPane.add(lblId);
		label.setBounds(447, 312, 145, 41);
		contentPane.add(label);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(125, 99, 69, 20);
		contentPane.add(lblPrice);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(125, 159, 69, 20);
		contentPane.add(lblPicture);
		
		String id = p.getIdProduct()+"";
		JLabel lblId2 = new JLabel(id);
		lblId2.setBounds(223, 52, 69, 20);
		contentPane.add(lblId2);
		
		String price = p.getPrice()+"";
		JLabel lblNPrice2 = new JLabel(price);
		lblNPrice2.setBounds(228, 99, 69, 20);
		contentPane.add(lblNPrice2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(149, 224, 115, 29);
		contentPane.add(btnNewButton);
	}
}
