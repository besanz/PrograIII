package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Product;
import data.User;

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
		setBounds(100, 100, 664, 672);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(74, 465, 129, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow window = new MainWindow(u);
				window.setVisible(true);
				dispose();
			}
		});
		
		
		
		JList list = new JList();
		list.setBounds(188, 96, 271, 322);
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
		btnRemove.setBounds(447, 465, 127, 29);
		contentPane.add(btnRemove);
		
		JButton btnBuy = new JButton("Buy Now");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnBuy.setBounds(188, 550, 271, 29);
		contentPane.add(btnBuy);
		
		JLabel Name = new JLabel(u.getUsername()+"");
		Name.setBounds(333, 33, 69, 20);
		contentPane.add(Name);
		
		JLabel lblElPrecioFinal = new JLabel("El precio final es");
		lblElPrecioFinal.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblElPrecioFinal(new Font("Yu Gothic", Font.BOLD, 16));
		lblElPrecioFinal.setBounds(7, 304, 194, 20);
		contentPane.add(lblElPrecioFinal);

		double total = 0;
		for(Object a: model1.toArray())
		{
			total += ((Product)a).getPrice();
		}
		
		JLabel label = new JLabel(total+" €");
		label.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		label.setBounds(74, 340, 120, 20);
		contentPane.add(label);
	}

	private void lblElPrecioFinal(Font font) {
		// TODO Auto-generated method stub
		
	}
}
