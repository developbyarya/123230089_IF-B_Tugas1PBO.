package tugasprakpbo1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developbyarya
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(){
        setTitle("Majalah App");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        setVisible(true);
    }
    
    void initComponents(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout vertikal
        
        // Padding
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
        // Welcome Label
        JLabel welcomeLabel = new JLabel("Selamat Datang, 123230089");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Deskripsi Label
        JLabel desLabel = new JLabel("Silakan pilih menu di bawah untuk membeli majalah");
        desLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        btnMajalahAnak = new MajalahButton("Majalah Anak", 10800, this);
        btnMajalahRemaja = new MajalahButton("Majalah Remaja", 15200, this);
        btnMajalahDewasa = new MajalahButton("Majalah Dewasa", 25400, this);
    
        panel.add(welcomeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        panel.add(desLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        panel.add(btnMajalahAnak);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        panel.add(btnMajalahRemaja);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        panel.add(btnMajalahDewasa);
        
        add(panel);
        
        
    }
    private MajalahButton btnMajalahAnak, btnMajalahRemaja, btnMajalahDewasa;
  
}

class MajalahButton extends JButton {
    private int harga;
    private String text;
    private JFrame parentFrame;
    public MajalahButton(String text, int harga, JFrame parentFrame) {
        super(text);
        this.harga = harga;
        this.text = text;
        this.parentFrame = parentFrame;
        
        // Button Appearance
        setFont(new Font("Arial", Font.BOLD, 14));
        setPreferredSize(new Dimension(300, 40));
        setMaximumSize(new Dimension(300, 40)); // Prevents resizing
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(200, 200, 200)); // Light gray background
        setForeground(Color.BLACK); // Text color
        setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Hover effect
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(170, 170, 170)); // Darker gray when hovered
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(200, 200, 200)); // Restore default
            }
        });
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              clickHandler();
            }
        });
        
    }
    
    private void clickHandler(){
        new PembelianFrame(harga, text);
        parentFrame.dispose();
        
    }
    
     
}
