package windows;

import data.Product;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewProduct extends JFrame {

    private JPanel contentPane;
    private JTextField textField;


    public NewProduct(Product product) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(26, 78, 387, 38);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAdd.setBounds(77, 147, 115, 29);
        contentPane.add(btnAdd);

        JButton btnNewButton = new JButton("Return");
        btnNewButton.setBounds(234, 147, 115, 29);
        contentPane.add(btnNewButton);


    }
}