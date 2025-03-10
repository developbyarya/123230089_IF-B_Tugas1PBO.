/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasprakpbo1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author developbyarya
 */
public class LoginFrame extends JFrame {
    public LoginFrame()
    {
        setTitle("Login App");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        setVisible(true);
    }
    
         
    void initComponents(){
        JPanel panel = new JPanel(new GridBagLayout());
        // Padding pada sekitar panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 5, 3, 5); // Default spacing antar element
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
       // Komponen username label
       gbc.gridx = 0;
       gbc.gridy = 0;
       
       username_label = new JLabel("username: ");
       panel.add(username_label, gbc);
       
       // Koponene username field
       username_field = new JTextField(15);
       gbc.gridy = 1;
       panel.add(username_field, gbc);
       
       // Komponen password label
       gbc.gridy = 2;
       
       password_label = new JLabel("Password: ");
       panel.add(password_label, gbc);
       
       // Koponene password field
       password_field = new JPasswordField(25);
       gbc.gridy = 3;
       panel.add(password_field, gbc);
       
       
       // Komponen login button
       gbc.gridy = 4;
       JButton loginButton = new JButton("Login");
       loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              loginButtonActionListener();
            }
       
       });
       panel.add(loginButton, gbc);
       

       
       
       add(panel);
       
       
    }
    
    private void loginButtonActionListener() {
        String inputted_username = username_field.getText();
        String inputted_password = new String(password_field.getPassword());
        try {
            attempLogin(inputted_username, inputted_password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void attempLogin(String username, String password) throws Exception{
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)){
            System.out.println("Login berhasil");
            new MainFrame();
            dispose();
            return;
            
        }
        throw new Exception("Username or password wrong!");
        
    }
    
    private JTextField username_field;
    private JPasswordField password_field;
    private JLabel username_label, password_label;
    private JButton login_button;
    
    private final String CORRECT_USERNAME = "123230089"; 
    private final String CORRECT_PASSWORD = "pass12345"; 
    
}
