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
import java.awt.Color;

public class ProductToAdd extends JFrame {

    private JPanel contentPane;
    private JTextField NameText;
    private JTextField PriceText;
    private JTextField StockText;


    public ProductToAdd() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 811, 711);
        contentPane = new JPanel();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        
        NameText = new JTextField();
        NameText.setBounds(227, 224, 387, 38);
        contentPane.add(NameText);
        NameText.setColumns(10);
        
        PriceText = new JTextField();
        PriceText.setBounds(227, 339, 387, 38);
        contentPane.add(PriceText);
        PriceText.setColumns(10);
        
        StockText = new JTextField();
        StockText.setBounds(227, 464, 387, 38);
        contentPane.add(StockText);
        StockText.setColumns(10);
        
        JLabel lblNewProduct = new JLabel("NEW PRODUCT");
        lblNewProduct.setFont(new Font("Verdana", Font.BOLD, 25));
        lblNewProduct.setBounds(291, 113, 263, 20);
        contentPane.add(lblNewProduct);
        
        JLabel lblProductName = new JLabel("Product Name");
        lblProductName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        lblProductName.setBounds(42, 233, 133, 20);
        contentPane.add(lblProductName);
        
        JLabel lblProdcutPrice = new JLabel("Product Price");
        lblProdcutPrice.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        lblProdcutPrice.setBounds(42, 348, 133, 20);
        contentPane.add(lblProdcutPrice);
        
        JLabel lblProductStock = new JLabel("Product Stock");
        lblProductStock.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        lblProductStock.setBounds(42, 473, 133, 20);
        contentPane.add(lblProductStock);

        JButton btnAdd = new JButton("Add");
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
            	
            	db.DBConnector.insertProduct(34, name, ProductPrice, Stock);
            	
           // 	MainWindow w = new MainWindow(null);
			//	w.setVisible(true);
				dispose();
                

            }
        });
        btnAdd.setBounds(250, 585, 115, 29);
        contentPane.add(btnAdd);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		backToLogin();
        	}
        });
        btnBack.setBounds(496, 585, 115, 29);
        contentPane.add(btnBack);

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