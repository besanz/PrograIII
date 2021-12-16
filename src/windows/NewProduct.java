package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.Product;
import javax.swing.JLabel;
import java.awt.Color;

public class NewProduct extends JFrame {

    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtSupply;


    public NewProduct(Product product) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 376);
        contentPane = new JPanel();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(193, 42, 167, 29);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAdd.setBounds(72, 244, 115, 29);
        contentPane.add(btnAdd);

        JButton btnNewButton = new JButton("Return");
        btnNewButton.setBounds(245, 244, 115, 29);
        contentPane.add(btnNewButton);
        
        txtPrice = new JTextField();
        txtPrice.setColumns(10);
        txtPrice.setBounds(193, 102, 167, 29);
        contentPane.add(txtPrice);
        
        txtSupply = new JTextField();
        txtSupply.setColumns(10);
        txtSupply.setBounds(193, 164, 167, 29);
        contentPane.add(txtSupply);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(72, 46, 69, 20);
        contentPane.add(lblName);
        
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(72, 106, 69, 20);
        contentPane.add(lblPrice);
        
        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(72, 168, 69, 20);
        contentPane.add(lblStock);


    }
}