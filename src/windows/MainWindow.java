package windows;

import data.Client;
import data.Product;
import data.User;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private JTextField ProductText;


	/**
	 * Create the frame.
	 */
	public MainWindow(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		ArrayList<Product> selectProduct = db.SelectProduct.selectProduct();
		

		

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSearch.setBounds(161, 118, 79, 29);
		contentPane.add(btnSearch);

		

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

ProductText = new JTextField();
		
        ProductText.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {//Se ejecuta cuando se libera una tecla
                JTextField textField = (JTextField) e.getSource();
                //obtiene contenido del textfield
                String text = ProductText.getText();
                if (text.trim().length() > 0) {
                    //nuevo Model temporal
                    DefaultListModel<Product> tmp = new DefaultListModel();
                    for (int i = 0; i < model1.getSize(); i++) {//recorre Model original
                        //si encuentra coincidencias agrega a model temporal
                        if (model1.getElementAt(i).getName().toLowerCase().contains(text.toLowerCase())) {
                            tmp.addElement(model1.getElementAt(i));
                        }
                    }
                    //agrega nuevo modelo a JList
                    list.setModel(tmp);
                } else {//si esta vacio muestra el Model original
                    list.setModel(model1);
                }
            }
        });
		ProductText.setBackground(Color.LIGHT_GRAY);
		ProductText.setBounds(15, 119, 131, 26);
		contentPane.add(ProductText);
		ProductText.setColumns(10);
		JButton btnInformation = new JButton("Information");
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pro = (Product) list.getSelectedValue();
				ProductInfo window = new ProductInfo(pro);
				window.setVisible(true);
				dispose();
			}
		});
		btnInformation.setBounds(462, 159, 138, 29);
		contentPane.add(btnInformation);

		

		JButton btnNewProduct_1_1 = new JButton("View Info");
		btnNewProduct_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Users window = new Users(u);
				window.setVisible(true);
				dispose();
				
			
			}
		});
		
		JButton btnBasket = new JButton("Add to Basket");
		btnBasket.setBounds(236, 448, 131, 29);
		contentPane.add(btnBasket);
		btnBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product p = (Product) list.getSelectedValue();
				
				
				
				DefaultListModel<Product> model = new DefaultListModel<Product>();
				ArrayList<Product> products = db.SelectUserProduct.selectProductUser(u);
				for(Product pro : products){
					model.addElement(pro);
				}
				
				list.setModel(model);
				
			
				
			
				Basket r = new Basket(u, null);
				r.setVisible(true);
			}
		});
		btnNewProduct_1_1.setBounds(462, 244, 138, 29);
		contentPane.add(btnNewProduct_1_1);

		JButton btnNewProduct_1_1_1 = new JButton("Settings");
		btnNewProduct_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewProduct_1_1_1.setBounds(462, 287, 138, 29);
		contentPane.add(btnNewProduct_1_1_1);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(462, 448, 138, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AddProduct");
		btnNewButton_1.setVisible(false);
		if(u.isAdmin()){
			btnNewButton_1.setVisible(true);
		}
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductToAdd window = new ProductToAdd();
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(462, 199, 138, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblName = new JLabel(u.getUsername()+"");
		lblName.setBounds(494, 16, 92, 55);
		contentPane.add(lblName);




	}
	String sql = "Selecct id,name,Price,stock from Product ";

	DefaultTableModel  tbl = new DefaultTableModel();

	ArrayList<Product> productArrayList= SelectProduct.selectProduct();
}