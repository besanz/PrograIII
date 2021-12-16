package windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.User;

import java.awt.Color;

public class ProductToAdd extends JFrame {

    private JPanel contentPane;
    private JTextField NameText;
    private JTextField PriceText;
    private JTextField StockText;


    public ProductToAdd(User u) {
    	setTitle("Add a new Crypto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 415, 436);
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

            /**
             * have to check id, need to increment automatically.
             * @param e
             */
            public void actionPerformed(ActionEvent e) {

            	String name =NameText.getText();
            	String ProductPricex = PriceText.getText();
            	int ProductPrice=Integer.parseInt(ProductPricex);
            	String Stockx = StockText.getText();
            	int  Stock = Integer.parseInt(Stockx);
            	
            	db.DBConnector.insertProduct(name, ProductPrice, Stock);
            	
           // 	MainWindow w = new MainWindow(null);
			//	w.setVisible(true);
				dispose();
                

            }
        });
        btnAdd.setBounds(42, 266, 126, 55);
        contentPane.add(btnAdd);

        JButton btnBack = new JButton("Return");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backToLogin(u);
        	}
        });
        btnBack.setBounds(216, 266, 119, 55);
        contentPane.add(btnBack);

    }
    
	public void backToLogin(User u){
		
		int opcionSeleccionar = JOptionPane.showConfirmDialog(this, "Are you sure?");
	
		if(opcionSeleccionar == JOptionPane.OK_OPTION){
			dispose();
			Login l = new Login(u);
			l.setVisible(true);
		}
	
	}
}