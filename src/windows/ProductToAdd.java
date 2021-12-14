package windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ProductToAdd extends JFrame {

    private JPanel contentPane;
    private JTextField idText;
    private JTextField NameText;
    private JTextField PriceText;
    private JTextField StockText;


    public ProductToAdd() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 811, 711);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        idText = new JTextField();
        idText.setBounds(227, 114, 387, 38);
        contentPane.add(idText);
        idText.setColumns(10);

       
        
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
        lblNewProduct.setBounds(227, 32, 263, 20);
        contentPane.add(lblNewProduct);
        
        JLabel lblNewLabel = new JLabel("Product Id");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(42, 123, 170, 20);
        contentPane.add(lblNewLabel);
        
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
            public void actionPerformed(ActionEvent e) {
            	
            	String idProductx = idText.getText();
            	int idProduct = Integer.parseInt(idProductx);
            	String name =NameText.getText();
            	String ProductPricex = PriceText.getText();
            	int ProductPrice=Integer.parseInt(ProductPricex);
            	String Stockx = StockText.getText();
            	int  Stock = Integer.parseInt(Stockx);
            	
            	//db.DBConnector.insertProduct(idProduct, name, ProductPrice, Stock);
            	
            	MainWindow w = new MainWindow(null);
				w.setVisible(true);
				dispose();
                

            }
        });
        btnAdd.setBounds(140, 585, 115, 29);
        contentPane.add(btnAdd);

        JButton btnNewButton = new JButton("Return");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(558, 585, 115, 29);
        contentPane.add(btnNewButton);

    }
}