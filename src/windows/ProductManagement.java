package windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import data.Product;
import data.User;

import java.awt.Color;

public class ProductManagement extends JFrame {

    private JPanel contentPane;
    private JTextField NameText;
    private JTextField PriceText;
    private JTextField StockText;


    public ProductManagement(User u) {
    	setTitle("Crypto management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 436);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        
        NameText = new JTextField();
        NameText.setFont(new Font("Consolas", Font.PLAIN, 17));
        NameText.setBounds(132, 186, 203, 29);
        contentPane.add(NameText);
        NameText.setColumns(10);
        
        PriceText = new JTextField();
        PriceText.setFont(new Font("Consolas", Font.PLAIN, 17));
        PriceText.setBounds(132, 126, 203, 29);
        contentPane.add(PriceText);
        PriceText.setColumns(10);
        
        StockText = new JTextField();
        StockText.setFont(new Font("Consolas", Font.PLAIN, 17));
        StockText.setBounds(132, 70, 203, 29);
        contentPane.add(StockText);
        StockText.setColumns(10);
        
        JLabel lblProductName = new JLabel("Name:");
        lblProductName.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblProductName.setBounds(42, 72, 87, 20);
        contentPane.add(lblProductName);
        
        JLabel lblProdcutPrice = new JLabel("Price:");
        lblProdcutPrice.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblProdcutPrice.setBounds(42, 128, 87, 20);
        contentPane.add(lblProdcutPrice);
        
        JLabel lblProductStock = new JLabel("Stock:");
        lblProductStock.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblProductStock.setBounds(42, 190, 87, 20);
        contentPane.add(lblProductStock);

        JButton btnAdd = new JButton("Add Crypto");
        btnAdd.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            	String name = NameText.getText();
            	String ProductPricex = PriceText.getText();
            	int ProductPrice=Integer.parseInt(ProductPricex);
            	String Stockx = StockText.getText();
            	int  Stock = Integer.parseInt(Stockx);
            	
            	db.DBConnector.insertProduct(name, ProductPrice, Stock);
            }
        });
        btnAdd.setBounds(42, 266, 126, 55);
        contentPane.add(btnAdd);

        JButton btnBack = new JButton("Return");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		MainWindow window = new MainWindow(u, null);
        		window.setVisible(true);
        		dispose();
        	}
        });
        btnBack.setBounds(216, 266, 119, 55);
        contentPane.add(btnBack);
        
        ArrayList<Product> selectProduct = db.SelectProduct.selectProduct();
		
		DefaultListModel<Product>model3=new DefaultListModel<Product>();
		for(Product p1: selectProduct)
		{
		model3.addElement(p1);
		}

		JList list3 = new JList();
		list3.setFont(new Font("Consolas", Font.PLAIN, 18));
		list3.setBackground(new Color(224, 255, 255));
		list3.setBounds(442, 52, 410, 194);
		list3.setModel(model3);
		contentPane.add(list3);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(442, 52, 410, 194);
		scrollPane.setViewportView(list3);
		contentPane.add(scrollPane);

		
		JButton btnDelete = new JButton("Delete Crypto");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Product product = (Product) list3.getSelectedValue();
				int ok = JOptionPane.showConfirmDialog(ProductManagement.this, "Are you sure you want to delete "+product.getName()+"?");
				if(ok == JOptionPane.OK_OPTION){
				db.DeleteDb.deleteP(product.getName());
				DefaultListModel<Product> model = new DefaultListModel<Product>();
				ArrayList<Product> newList = db.SelectProduct.selectProduct();
				for(Product p : newList){
					model.addElement(p);
				}
				list3.setModel(model);
				JOptionPane.showMessageDialog(ProductManagement.this, product.getName()+" has been deleted successfully!");
				}
		
			}
		});
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnDelete.setBounds(548, 266, 191, 55);
		contentPane.add(btnDelete);
	}

   

}