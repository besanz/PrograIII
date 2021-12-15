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
<<<<<<< HEAD
=======
import javax.swing.JLabel;
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
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

/**
 *
 * @author JON ANDER ARANA
 * @author Benat
 *
 */

public class MainWindow extends JFrame {

	private JPanel contentPane;
<<<<<<< HEAD
	private JTextField txtFiltro;
=======
	private JTextField ProductText;
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
	private User u;


	/**
	 * Create the frame.
	 */
	public MainWindow(User u) {
		this.u = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 571);
		contentPane = new JPanel(){  
              public void paintComponent(Graphics g) {  
              Image img = Toolkit.getDefaultToolkit().getImage("background.jpg");  
			                      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			                }  
			            };  
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
<<<<<<< HEAD
		ArrayList<Product> selectProduct = db.SelectProduct.selectProduct(sql);
		DefaultListModel<Product>model=new DefaultListModel<Product>();


		txtFiltro = new JTextField();
		txtFiltro.setBackground(Color.CYAN);
		txtFiltro.setBounds(15, 119, 131, 26);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);
=======
		ArrayList<Product> selectProduct = db.SelectProduct.selectProduct();
		DefaultListModel<Product>model=new DefaultListModel<Product>();

>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8

		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(161, 118, 79, 29);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				if(txtFiltro.getSelectedText() != null){
=======
				if(ProductText.getSelectedText() != null){
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
				filtrar();
				}else{
					JOptionPane.showMessageDialog(MainWindow.this, "You must type something first!");
				}
			}
		});

		JButton btnBasket = new JButton("Basket");
		btnBasket.setBounds(230, 448, 137, 29);
		contentPane.add(btnBasket);
		btnBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Basket r = new Basket();
				r.setVisible(true);
			}
		});
		
		DefaultListModel<Product>model1=new DefaultListModel<Product>();
		for(Product a: selectProduct)
		{
		model1.addElement(a);
		}
		JList list = new JList();
		list.setModel(model1);
		list.setBounds(15, 161, 432, 216);
		list.setBackground(Color.CYAN);
<<<<<<< HEAD
=======

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
		ProductText.setBackground(Color.CYAN);
		ProductText.setBounds(15, 119, 131, 26);
		contentPane.add(ProductText);
		ProductText.setColumns(10);
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 161, 432, 216);
		scrollPane.setViewportView(list);
		contentPane.add(scrollPane);
		
		JButton btnInformation = new JButton("Information");
		btnInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product pro = (Product) list.getSelectedValue();
				
				if(list.getSelectedValue() != null){
				ProductInfo window = new ProductInfo(pro);
				window.setVisible(true);
				dispose();}else{
					JOptionPane.showMessageDialog(MainWindow.this, "Please, select a coin first" );
					
				}
			}
		});
		btnInformation.setBounds(462, 159, 138, 29);
		contentPane.add(btnInformation);
		
		JButton btnNewProduct = new JButton("New Product");
<<<<<<< HEAD
=======
		btnNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductToAdd window = new ProductToAdd();
				window.setVisible(true);
				dispose();
			}
			
		});
		
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
		btnNewProduct.setBounds(462, 204, 138, 29);
		contentPane.add(btnNewProduct);
		btnNewProduct.setEnabled(u.isAdmin());
		
<<<<<<< HEAD
		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
=======
		JLabel lblName = new JLabel(u.getUsername()+"");
		lblName.setBounds(494, 16, 92, 55);
		contentPane.add(lblName);

		
		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users window = new Users(u);
				window.setVisible(true);
				dispose();
				
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
			}
		});
		btnViewUsers.setBounds(462, 244, 138, 29);
		contentPane.add(btnViewUsers);
		btnViewUsers.setEnabled(u.isAdmin());
<<<<<<< HEAD
		btnViewUsers.setEnabled(u.isAdmin());
=======
		
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSettings.setBounds(462, 287, 138, 29);
		contentPane.add(btnSettings);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToLogin();
				
			}
		});
		btnNewButton.setBounds(462, 448, 138, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAddToBasket = new JButton("Add to Basket");
		btnAddToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddToBasket.setBounds(77, 448, 138, 29);
		contentPane.add(btnAddToBasket);
		
		
		
		
	}
	String sql = "Selecct id,name,Price,stock from Product ";

	DefaultTableModel  tbl = new DefaultTableModel();

<<<<<<< HEAD
	ArrayList<Product> productArrayList= SelectProduct.selectProduct(sql);
=======
	ArrayList<Product> productArrayList= SelectProduct.selectProduct();
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
	
	
	/**
	 * must check this method
	 */
	public void filtrar(){
		

<<<<<<< HEAD
		ArrayList<Product> products = db.SelectProduct.selectProduct(sql);;
=======
		ArrayList<Product> products = db.SelectProduct.selectProduct();;
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
		ArrayList<Product> productFiltrados = new ArrayList<>();
		
		for (Product p : products) {
			
<<<<<<< HEAD
			if(p.getName().toLowerCase().contains(this.txtFiltro.getText().toLowerCase())){
=======
			if(p.getName().toLowerCase().contains(this.ProductText.getText().toLowerCase())){
>>>>>>> 03a077756366fe22c0f07e1b36c3e2ca37be94d8
				productFiltrados.add(p);
			}
			
			 
		}
		
		
	}
	

	public void backToLogin(){
		
		int opcionSeleccionar = JOptionPane.showConfirmDialog(this, "Are you sure?");
	
		if(opcionSeleccionar == JOptionPane.OK_OPTION){
			dispose();
			Login l = new Login();
			l.setVisible(true);
		}
	
	}
}