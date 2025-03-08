/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasprakpbo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author developbyarya
 */
public class PembelianFrame extends JFrame {
    PembelianFrame(int harga, String kategori){
        this.kategori = kategori;
        this.harga = harga;
        setTitle("Pembelian " + kategori);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        initComponents();
        setVisible(true);
        
    }
    
    void initComponents(){
        JPanel panel = new JPanel(new GridBagLayout());
        // Padding utama
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Title halaman pembelian
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Halaman Pembelian"), gbc);
        
        // Komponen Kategori
        // Kategori Label
        gbc.gridy = 1;
        panel.add(new JLabel("Kategori"), gbc);
        
        // Isi kategori
        gbc.gridx = 1;
        panel.add(new JLabel(kategori), gbc);
        
        // Komponen Harga
        // Label harga
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(new JLabel("Harga"), gbc);
        
        // Isi harga
        gbc.gridx = 1;
        panel.add(new JLabel(String.valueOf(harga)), gbc);
        
        // Jumlah pembelian
        // Label jumlah pembelian
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(new JLabel("Jumlah "), gbc);
        
        // Input
        gbc.gridx = 1;
        field_jumlah_pembelian = new JTextField(10);
        panel.add(field_jumlah_pembelian, gbc);
        
        // Button
        // Kembali Button
        btnKembali = new JButton("Kembali");
        btnKembali.setPreferredSize(new Dimension(80, 30));
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new MainFrame();
                dispose();
            }
        });
        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(btnKembali, gbc);
        
        // Beli button
        btnBeli = new JButton("Beli");
        btnBeli.setPreferredSize(new Dimension(80, 30));
        gbc.gridx = 1;
        panel.add(btnBeli, gbc);
        btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                beliActionPerformed();
            }
        });
        
       
        
        panelTotal = new JPanel(new GridBagLayout());
        // Padding utama
        panelTotal.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        panelTotal.setVisible(false);
       
        add(panel, BorderLayout.NORTH);
        // Title total pembelian
        gbc.gridx = 0;
        gbc.gridy++;
        
        panelTotal.add(new JLabel("Total Pembelian"), gbc);
        
         // Harga Satuan
        gbc.gridy++;
        panelTotal.add(new JLabel("Harga satuan"), gbc);
        gbc.gridx = 1;
        hargaLabel = new JLabel("Rp. " + String.valueOf(harga));
        panelTotal.add(hargaLabel, gbc);
        // Jumlah
         gbc.gridy++;
         gbc.gridx = 0;
        panelTotal.add(new JLabel("Jumlah"), gbc);
         gbc.gridx = 1;
        jumlahLabel = new JLabel();
        panelTotal.add(jumlahLabel, gbc);
        
        gbc.gridy++;
        gbc.gridx = 0;
        panelTotal.add(new JLabel("Harga Total"), gbc);
        
        gbc.gridx = 1;
        totalLabel = new JLabel();
        panelTotal.add(totalLabel, gbc);
        
        
        
        add(panelTotal, BorderLayout.SOUTH);
   }
   
   private void beliActionPerformed(){
       try{
            jumlah = Integer.parseInt(field_jumlah_pembelian.getText());
            jumlahLabel.setText(String.valueOf(jumlah));
            totalHarga = jumlah * harga;
            totalLabel.setText("Rp. " + String.valueOf(totalHarga));
            panelTotal.setVisible(true);
             
       } catch (Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage(), "Parsing error", JOptionPane.ERROR_MESSAGE);
       }
   }
   GridBagConstraints gbc;
   private String kategori;
   private int harga, jumlah;
   private JTextField field_jumlah_pembelian;
   private JButton btnKembali, btnBeli;
   private int totalHarga; // Output attribute kata pak edo
   private JPanel panelTotal;
   private JLabel hargaLabel, jumlahLabel, totalLabel;
}
