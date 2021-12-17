package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import data.Product;
import data.User;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DeleteProduct extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DeleteProduct(Product p,User u) {
		setTitle("User Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Product> selectProduct = db.SelectProduct.selectProduct();
		
		DefaultListModel<Product>model3=new DefaultListModel<Product>();
		for(Product p1: selectProduct)
		{
		model3.addElement(p1);
		}

		JList list3 = new JList();
		list3.setFont(new Font("Consolas", Font.PLAIN, 18));
		list3.setBackground(new Color(175, 238, 238));
		list3.setBounds(80, 54, 410, 399);
		list3.setModel(model3);
		contentPane.add(list3);
		
		
	//	JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(15, 161, 432, 216);
		//scrollPane.setViewportView(list2);
		//contentPane.add(scrollPane);
		
		

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login(u);
				l.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(405, 493, 138, 29);
		contentPane.add(btnBack);
		
		JButton btnDelete = new JButton("Delete Product");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = (Product) list3.getSelectedValue();
				
				db.DeleteDb.deleteP(product.getName());
				DefaultListModel<Product> model = new DefaultListModel<Product>();
				ArrayList<Product> newList = db.SelectProduct.selectProduct();
				for(Product p : newList){
					model.addElement(p);
				}
				list3.setModel(model);
				
			}
		});
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDelete.setBounds(108, 493, 151, 29);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(467, 54, 34, 129);
		contentPane.add(scrollPane);
	}

	

}

