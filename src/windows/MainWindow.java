package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Benat;
 *
 */

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtFilter;


	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(67, 85, 518, 347);
		contentPane.add(table);

		JComboBox orderBy = new JComboBox();
		orderBy.setBounds(447, 43, 138, 26);
		contentPane.add(orderBy);

		txtFilter = new JTextField();
		txtFilter.setBackground(Color.LIGHT_GRAY);
		txtFilter.setBounds(67, 43, 131, 26);
		contentPane.add(txtFilter);
		txtFilter.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(213, 40, 79, 29);
		contentPane.add(btnSearch);

		JButton btnBasket = new JButton("Basket");
		btnBasket.setBounds(252, 448, 115, 29);
		contentPane.add(btnBasket);
		btnBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Basket r = new Basket();
				r.setVisible(true);
			}
		});


		JLabel lblSelectedElements = new JLabel("New label");
		lblSelectedElements.setBounds(384, 452, 86, 20);
		contentPane.add(lblSelectedElements);
	}
}