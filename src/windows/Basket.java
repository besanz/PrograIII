package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Product;
import data.ProductBasket;
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
	public Basket(ArrayList<ProductBasket> basket,User u){//,Product p) {
		ImageIcon icon = new ImageIcon("favicon.png");
		this.setIconImage(icon.getImage());
		setTitle("Cart");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 437, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int saldo = u.getSaldo();
		//int stock= p.getStock();
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBack.setBounds(74, 465, 129, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		
		JList list = new JList();
		list.setFont(new Font("Century Gothic", Font.BOLD, 20));
		list.setBackground(Color.WHITE);
		list.setBounds(74, 74, 271, 340);
		contentPane.add(list);
		
		
		DefaultListModel<ProductBasket> model1 = new DefaultListModel<>();
		for (ProductBasket product : basket) {
			model1.addElement(product);
		}
		list.setModel(model1);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.LIGHT_GRAY);
		btnRemove.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductBasket pSeleccionado = (ProductBasket) list.getSelectedValue();
				model1.removeElement(pSeleccionado);
				JOptionPane.showMessageDialog(Basket.this, "Deleted.");
			}
		});
		btnRemove.setBounds(218, 465, 127, 29);
		contentPane.add(btnRemove);
		
		
		
		JLabel Name = new JLabel("Your basket:");
		Name.setFont(new Font("Century Gothic", Font.ITALIC, 22));
		Name.setBounds(15, 16, 269, 42);
		contentPane.add(Name);
		
		JLabel lblElPrecioFinal = new JLabel("Total Price .....................................");
		lblElPrecioFinal.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblElPrecioFinal(new Font("Yu Gothic", Font.BOLD, 16));
		lblElPrecioFinal.setBounds(74, 429, 190, 20);
		contentPane.add(lblElPrecioFinal);

		double total = 0;
		for(Object a: model1.toArray())
		{
			total += ((ProductBasket)a).getPrice()*((ProductBasket)a).getPurchaseQuantity();
		}
		
		JLabel label = new JLabel(total+" €");
		label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(270, 429, 104, 20);
		contentPane.add(label);
	

	double valor= saldo - total;
	
	JButton btnBuy = new JButton("Buy Now");
	btnBuy.setFont(new Font("Century Gothic", Font.PLAIN, 16));
	btnBuy.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0 ; i< model1.size(); i++){
				int b = u.getIdUser();
				int a = model1.getElementAt(i).getIdProduct();
				db.DBConnector.insertUserProduct(b,a);
				for(Object z: model1.toArray())
				{
					int y = ((Product)z).getStock()-1;
					int c = ((Product) z).getIdProduct();
					db.DBConnector.updateStock(c, y);
				}
				db.DBConnector.updateSaldo(b, valor);
			}			
		}
	});
	btnBuy.setBounds(74, 498, 271, 29);
	contentPane.add(btnBuy);
	
	JLabel label_1 = new JLabel("");
	label_1.setBounds(255, 38, 69, 20);
	contentPane.add(label_1);
	
	JLabel Name_1 = new JLabel(u.getUsername()+"");
	Name_1.setFont(new Font("Century Gothic", Font.ITALIC, 22));
	Name_1.setBounds(146, 16, 210, 42);
	contentPane.add(Name_1);}
	
	
	
	private void lblElPrecioFinal(Font font) {
		// TODO Auto-generated method stub
		
	}
}
