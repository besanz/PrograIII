package windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.Product;
import data.ProductBasket;
import data.User;
import db.ProductDB;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author JON ANDER ARANA
 * @author Benat
 *
 */

/**
 * 
 * @author Benat 
 *
 */

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField ProductText;
	private User u;
	private ArrayList<ProductBasket> basket;

	private ArrayList<Product> DBProducts;

	public ArrayList<Product> getDBProducts() {
		return DBProducts;
	}

	public void setDBProducts(ArrayList<Product> dBProducts) {
		DBProducts = dBProducts;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public ArrayList<ProductBasket> getBasket() {
		return basket;
	}

	public void setBasket(ArrayList<ProductBasket> basket) {
		this.basket = basket;
	}

	/**
	 * Create the frame.
	 */
	public MainWindow(User u) {// ,Product p) {

		ImageIcon icon = new ImageIcon("favicon.png");
		this.setIconImage(icon.getImage());
		this.basket = new ArrayList<>();

		this.u = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 512);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage("background.jpg");
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		this.setTitle("Our cryptos for you, " + u.getUsername());

		DBProducts = db.ProductDB.selectProduct();

		DBProducts.sort(Comparator.comparing(p -> ((Product) p).getName()));

		contentPane.setLayout(null);

		JButton btnSearch = new JButton("Automatic Search");
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSearch.setBounds(15, 66, 220, 34);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ProductText.getSelectedText() != null) {
					JOptionPane.showMessageDialog(MainWindow.this, "It works automatically!");
				} else {
					JOptionPane.showMessageDialog(MainWindow.this, "You must type something first!");
				}
			}
		});

		JButton btnBasket = new JButton("Open Basket");
		MainWindow main = this;
		btnBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Basket r = new Basket(main);// (basket, u);// , p);
				r.setVisible(true);

			}
		});
		btnBasket.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBasket.setBounds(239, 393, 208, 38);
		contentPane.add(btnBasket);

		DefaultListModel<Product> model1 = new DefaultListModel<Product>();
		for (Product a : DBProducts) {
			model1.addElement(a);
		}
		JList list = new JList();
		list.setFont(new Font("Consolas", Font.PLAIN, 25));
		list.setModel(model1);
		list.setBounds(15, 161, 432, 216);
		list.setBackground(new Color(175, 238, 238));

		ProductText = new JTextField();
		ProductText.setFont(new Font("Consolas", Font.PLAIN, 18));
		ProductText.setBounds(15, 117, 220, 34);
		ProductText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// JTextField textField = (JTextField) e.getSource();

				String text = ProductText.getText();
				if (text.trim().length() > 0) {

					DefaultListModel<Product> tmp = new DefaultListModel();
					for (int i = 0; i < model1.getSize(); i++) {

						if (model1.getElementAt(i).getName().toLowerCase().contains(text.toLowerCase())) {
							tmp.addElement(model1.getElementAt(i));
						}
					}

					list.setModel(tmp);
				} else {
					list.setModel(model1);
				}
			}
		});
		ProductText.setBackground(new Color(175, 238, 238));
		contentPane.add(ProductText);
		ProductText.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 161, 432, 216);
		scrollPane.setViewportView(list);
		contentPane.add(scrollPane);

		JButton btnInformation = new JButton("Crypto Info");
		btnInformation.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnInformation.setBounds(492, 159, 150, 56);
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Product pro = (Product) list.getSelectedValue();

				if (list.getSelectedValue() != null) {
					ProductInfo window = new ProductInfo(pro, u);
					window.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(MainWindow.this, "Please, select a coin first");

				}
			}
		});
		contentPane.add(btnInformation);

		JButton btnNewProduct = new JButton("Administration");
		btnNewProduct.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewProduct.setBounds(492, 227, 150, 56);
		btnNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductManagement window = new ProductManagement(u);
				window.setVisible(true);
			}

		});
		contentPane.add(btnNewProduct);
		btnNewProduct.setEnabled(u.isAdmin());

		JButton btnViewUsers = new JButton("My Profile");
		btnViewUsers.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnViewUsers.setBounds(492, 299, 150, 56);
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users window = new Users(u);
				window.setVisible(true);

			}
		});
		contentPane.add(btnViewUsers);
		

		JButton btnNewButton = new JButton("Back to Login");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(491, 16, 151, 56);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToLogin();

			}
		});
		contentPane.add(btnNewButton);

		JButton btnAddToBasket = new JButton("Add to Basket");
		btnAddToBasket.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAddToBasket.setBounds(15, 393, 197, 38);
		btnAddToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pro = (Product) list.getSelectedValue();// catalogo
				if (pro == null)
					return;
				ProductBasket proBasket = new ProductBasket(pro.getIdProduct(), pro.getName(), pro.getPrice());
				int pos = 0;
				boolean encontrado = false;
				for (ProductBasket productBasket : basket) {
					if (proBasket.getIdProduct() == productBasket.getIdProduct()) {
						encontrado = true;
						break;
					} else
						pos++;
				}
				
				if ((u.getSaldo() - pro.getPrice())>pro.getPrice()) {
					if (pro.getStock() >= 1) {
						if (encontrado) {
							u.setSaldo(u.getSaldo() - pro.getPrice());
							basket.get(pos).setPurchaseQuantity(proBasket.getPurchaseQuantity() + 1);
						} else {
							u.setSaldo(u.getSaldo() - pro.getPrice());
							basket.add(proBasket);
						}
						JOptionPane.showMessageDialog(MainWindow.this, "Success!.");
					} else {
						JOptionPane.showMessageDialog(MainWindow.this, "Not enough stock.");
					}
				} else {
					JOptionPane.showMessageDialog(MainWindow.this, "Not enough balance.");
				}

			}
		});
		contentPane.add(btnAddToBasket);

		JButton btnManageUsers = new JButton("Manage Clients");
		btnManageUsers.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnManageUsers.setBounds(492, 371, 150, 60);
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageUsers mg = new ManageUsers(null);
				mg.setVisible(true);
				dispose();

			}
		});
		contentPane.add(btnManageUsers);
		btnManageUsers.setEnabled(u.isAdmin());

		JComboBox cbOrden = new JComboBox();
		cbOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbOrden.getSelectedItem() == "NAME ASC") {
					DBProducts.sort(Comparator.comparing(p -> ((Product) p).getName()));
					DefaultListModel<Product> model1 = new DefaultListModel<Product>();
					for (Product a : DBProducts) {
						model1.addElement(a);
					}
					list.setModel(model1);

				} // if (cbOrden.getSelectedItem() == "PRICE ASC") {
					//DBProducts.sort(Comparator.comparing(p -> ((Product) p).getPrice()));
					//DefaultListModel<Product> model1 = new DefaultListModel<Product>();
					//for (Product a : DBProducts) {
						//model1.addElement(a);
				//	}
					//list.setModel(model1);
		//		}
				if(cbOrden.getSelectedItem() == "Price"){
					DefaultListModel<Product> model3 = new DefaultListModel<Product>();
					ArrayList<Product> pro = db.SelectProduct.selectProduct();
					for (Product a: pro){
						System.out.println(a);
					}
					ArrayList<Product> products3 =new ArrayList<Product>();
					products3= recursividad.Recursion.mergeSortNum(pro);
					for(Product a:products3){
						model3.addElement(a);
					}
					list.setModel(model3);
				}

			}
		});
		cbOrden.setModel(new DefaultComboBoxModel(new String[] {"Sort by", "NAME ASC", "PRICE ASC", "Price"}));
		cbOrden.setBounds(250, 119, 140, 32);
		contentPane.add(cbOrden);

	}

	String sql = "Select id,name,Price,stock from Product ";

	DefaultTableModel tbl = new DefaultTableModel();

	ArrayList<Product> productArrayList = ProductDB.selectProduct();

	/**
	 * must check this method
	 */
	public void filtrar() {

		ArrayList<Product> products = db.ProductDB.selectProduct();
		;
		ArrayList<Product> productFiltrados = new ArrayList<>();

		for (Product p : products) {

			if (p.getName().toLowerCase().contains(this.ProductText.getText().toLowerCase())) {
				productFiltrados.add(p);
			}

		}

	}

	public void backToLogin() {

		int opcionSeleccionar = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?");

		if (opcionSeleccionar == JOptionPane.OK_OPTION) {
			dispose();
			Login l = new Login(u);
			l.setVisible(true);
		}

	}
}