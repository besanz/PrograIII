package Windows;

/**
 * @author Beñat
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        setTitle("AranaBanana");
        getContentPane().setBackground(Color.BLACK);
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.setTitle("AranaBanana");
        this.setResizable(true);
        this.setBounds(100, 100, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        getContentPane().setLayout(null);

        txtUser = new JTextField();
        txtUser.setBounds(176, 99, 205, 26);
        this.getContentPane().add(txtUser);
        txtUser.setColumns(10);

        JLabel lblNewLabel = new JLabel("User:");
        lblNewLabel.setBounds(50, 102, 69, 20);
        this.getContentPane().add(lblNewLabel);

        txtPass = new JPasswordField();
        txtPass.setBounds(176, 156, 205, 26);
        this.getContentPane().add(txtPass);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setBounds(50, 159, 111, 20);
        this.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Log In");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        btnNewButton.setBounds(176, 198, 205, 29);
        this.getContentPane().add(btnNewButton);

    }

    /**
     * Method to login into main window.
     */
    private void login(){

        if(this.txtUser.getText().equals("admin") && this.txtPass.getText().equals("admin")){

            JOptionPane.showMessageDialog(this, "Welcome!" );
        }else{
            JOptionPane.showMessageDialog(this, "Error 303" );
        }


    }


}