package windows;

/**
 * @author JON ANDER ARANA
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtidUser;
    private JTextField txtName;
    private JPasswordField txtPass1;
    private JPasswordField txtAdmin;

    /**
     * Create the dialog.
     */
    public void setVisible(){
    	
    };
    public Register() {
        this.setModal(true);
        setTitle("Register");
        setBounds(100, 100, 337, 433);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("idUser:");
        lblNewLabel.setBounds(15, 55, 69, 20);
        contentPanel.add(lblNewLabel);

        txtidUser = new JTextField();
        txtidUser.setBounds(138, 49, 146, 26);
        contentPanel.add(txtidUser);
        txtidUser.setColumns(10);

        JLabel lblName = new JLabel("Your Name:");
        lblName.setBounds(15, 112, 108, 20);
        contentPanel.add(lblName);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(138, 106, 146, 26);
        contentPanel.add(txtName);

        txtPass1 = new JPasswordField();
        txtPass1.setBounds(138, 165, 146, 25);
        contentPanel.add(txtPass1);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(15, 170, 69, 20);
        contentPanel.add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("Admin");
        lblConfirmPassword.setBounds(15, 227, 108, 20);
        contentPanel.add(lblConfirmPassword);

        txtAdmin = new JPasswordField();
        txtAdmin.setBounds(138, 222, 146, 25);
        contentPanel.add(txtAdmin);

        JButton btnNewButton = new JButton("Sign Up");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String idUserx = txtidUser.getText();
            	int idUser = 100;
            	String name = txtName.getText();
            	String Password = txtPass1.getText();
            	boolean  Admin = false;
            	
            	db.DBConnector.insertUser(idUser, name, Password, Admin);
            	
            	MainWindow w = new MainWindow(null);
				w.setVisible(true);
                
            }
        });
        btnNewButton.setBounds(138, 273, 146, 26);
        contentPanel.add(btnNewButton);

        JButton btnBack = new JButton("Back to Login");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnBack.setBounds(138, 315, 146, 26);
        contentPanel.add(btnBack);
    }
}