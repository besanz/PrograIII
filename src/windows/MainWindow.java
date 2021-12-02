package windows;

import data.Product;
import db.SelectProduct;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author JON ANDER ARANA;
 *
 */

public class MainWindow extends JFrame {

	private JPanel contentPane;
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
		
		

		ArrayList<Product> selectProduct = db.SelectProduct.selectProduct(sql);
		DefaultListModel<Product>model=new DefaultListModel<Product>();


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
		
		DefaultListModel<Product>model1=new DefaultListModel<Product>();
		for(Product a: selectProduct)
		{
		model1.addElement(a);
		}
		JList list = new JList();
		list.setModel(model1);
		list.setBounds(15, 161, 432, 216);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 161, 432, 216);
		scrollPane.setViewportView(list);
		contentPane.add(scrollPane);
		
		JButton btnPrice = new JButton("Price");
		btnPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product selec=(Product)list.getSelectedValue();
				JOptionPane.showMessageDialog(MainWindow.this, selec.getPrice());
			}
		});
		btnPrice.setBounds(470, 202, 115, 29);
		contentPane.add(btnPrice);
		
		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product selec=(Product)list.getSelectedValue();
				JOptionPane.showMessageDialog(MainWindow.this, selec.getStock());

				
			}
		});
		btnQuantity.setBounds(470, 247, 115, 29);
		contentPane.add(btnQuantity);
		
		JButton btnLogo = new JButton("Logo");
		btnLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnLogo.setBounds(470, 292, 115, 29);
		contentPane.add(btnLogo);
		
		JButton btnId = new JButton("Id");
		btnId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product selec=(Product)list.getSelectedValue();
				JOptionPane.showMessageDialog(MainWindow.this, selec.getIdProduct());
			}
		});
		btnId.setBounds(470, 159, 115, 29);
		contentPane.add(btnId);
		
		
		
		
	}
	String sql = "Selecct id,name,Price,stock from Product ";

	DefaultTableModel  tbl = new DefaultTableModel();

	ArrayList<Product> productArrayList= SelectProduct.selectProduct(sql);
}