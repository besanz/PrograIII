package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import data.Product;
import data.User;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * 
 * @author Benat;
 *
 */

public class Basket extends JDialog {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Basket(ArrayList<Product> basket,User u) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(74, 425, 129, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow window = new MainWindow(u);
				window.setVisible(true);
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
		
		JList list = new JList();
		list.setBounds(74, 74, 271, 322);
		contentPane.add(list);
		
		
		DefaultListModel<Product> model1 = new DefaultListModel<>();
		for (Product product : basket) {
			model1.addElement(product);
		}
		list.setModel(model1);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product pSeleccionado = (Product) list.getSelectedValue();
				model1.removeElement(pSeleccionado);
			}
		});
		btnRemove.setBounds(218, 425, 127, 29);
		contentPane.add(btnRemove);
		
		JLabel Name = new JLabel(u.getUsername()+"");
		Name.setBounds(333, 33, 69, 20);
		contentPane.add(Name);
	}
}
