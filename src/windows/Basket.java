package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import data.Product;
import data.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Benat;
 *
 */

public class Basket extends JDialog {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Basket(User u ,Product a) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(74, 103, 271, 306);
		contentPane.add(table);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(218, 425, 127, 29);
		contentPane.add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(74, 425, 129, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnBuy = new JButton("Buy Now");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuy.setBounds(74, 470, 271, 29);
		contentPane.add(btnBuy);
	}

}
