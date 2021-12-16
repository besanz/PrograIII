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

import javax.swing.DefaultListModel;
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
import data.User;
import db.SelectProduct;
import java.awt.Font;

/**
 *
 * @author JON ANDER ARANA
 * @author Benat
 *
 */

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField ProductText;
	private User u;
	private ArrayList<Product> basket;


	/**
	 * Create the frame.
	 */
	public MainWindow(User u) {
		this.basket = new ArrayList<>();
		
		this.u = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 512);
		contentPane = new JPanel(){  
              public void paintComponent(Graphics g) {  
              Image img = Toolkit.getDefaultToolkit().getImage("background.jpg");  
			                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			                }  
			            };  
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setTitle("Our cryptos for you, "+u.getUsername());
		
		ArrayList<Product> selectProduct = db.SelectProduct.selectProduct();
		DefaultListModel<Product>model=new DefaultListModel<Product>();
		contentPane.setLayout(null);


		
		JButton btnSearch = new JButton("Automatic Search");
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSearch.setBounds(250, 117, 197, 34);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProductText.getSelectedText() != null){
				filtrar();
				}else{
					JOptionPane.showMessageDialog(MainWindow.this, "You must type something first!");
				}
			}
		});

		JButton btnBasket = new JButton("Open Basket");
		btnBasket.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBasket.setBounds(250, 393, 197, 38);
		contentPane.add(btnBasket);
		btnBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Basket r = new Basket(basket, u);
				r.setVisible(true);
			}
		});
		
		DefaultListModel<Product>model1=new DefaultListModel<Product>();
		for(Product a: selectProduct)
		{
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
		ProductText.setBackground(new Color(175, 238, 238));
		contentPane.add(ProductText);
		ProductText.setColumns(10);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 161, 432, 216);
		scrollPane.setViewportView(list);
		contentPane.add(scrollPane);
		
		JButton btnInformation = new JButton("Information");
		btnInformation.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnInformation.setBounds(492, 159, 150, 56);
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product pro = (Product) list.getSelectedValue();
				
				if(list.getSelectedValue() != null){
				ProductInfo window = new ProductInfo(pro);
				window.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(MainWindow.this, "Please, select a coin first" );
					
				}
			}
		});
		contentPane.add(btnInformation);
		
		JButton btnNewProduct = new JButton("New Product");
		btnNewProduct.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewProduct.setBounds(492, 231, 150, 38);
		btnNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductToAdd window = new ProductToAdd(u);
				window.setVisible(true);
				dispose();
			}
			
		});
		contentPane.add(btnNewProduct);
		btnNewProduct.setEnabled(u.isAdmin());

		
		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnViewUsers.setBounds(492, 285, 150, 38);
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users window = new Users(u);
				window.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnViewUsers);
		btnViewUsers.setEnabled(u.isAdmin());
		
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnSettings.setBounds(15, 16, 113, 38);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingsWindow sw = new SettingsWindow();
				sw.setVisible(true);
			}
		});
		contentPane.add(btnSettings);
		btnSettings.setEnabled(u.isAdmin());
		
		JButton btnNewButton = new JButton("Back to Login");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(491, 16, 151, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToLogin();
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnAddToBasket = new JButton("Add to Basket");
		btnAddToBasket.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAddToBasket.setBounds(25, 393, 180, 38);
		btnAddToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basket.add((Product) list.getSelectedValue());
			}
		});
		contentPane.add(btnAddToBasket);
		
		JButton btnManageUsers = new JButton("Manage Users");
		btnManageUsers.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnManageUsers.setBounds(492, 339, 150, 38);
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnManageUsers);
		btnManageUsers.setEnabled(u.isAdmin());
		
		
		
		
	}
	String sql = "Select id,name,Price,stock from Product ";

	DefaultTableModel  tbl = new DefaultTableModel();

	ArrayList<Product> productArrayList= SelectProduct.selectProduct();
	
	
	/**
	 * must check this method
	 */
	public void filtrar(){
		

		ArrayList<Product> products = db.SelectProduct.selectProduct();;
		ArrayList<Product> productFiltrados = new ArrayList<>();
		
		for (Product p : products) {
			
			if(p.getName().toLowerCase().contains(this.ProductText.getText().toLowerCase())){
				productFiltrados.add(p);
			}
			
			 
		}
		
		
	}
	

	public void backToLogin(){
		
		int opcionSeleccionar = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?");
	
		if(opcionSeleccionar == JOptionPane.OK_OPTION){
			dispose();
			Login l = new Login(u);
			l.setVisible(true);
		}
	
	}
}