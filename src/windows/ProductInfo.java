package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProductInfo extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("");
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInfo frame = new ProductInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductInfo() {
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
		lblId.setBounds(323, 141, 69, 20);
		contentPane.add(lblId);
		label.setBounds(447, 312, 145, 41);
		contentPane.add(label);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(323, 231, 69, 20);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(269, 189, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(269, 268, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(323, 334, 69, 20);
		contentPane.add(lblPicture);
		
		JPanel panel = new JPanel();
		panel.setBounds(269, 397, 146, 94);
		contentPane.add(panel);
	}
}
