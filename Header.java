/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author ahmed
 */
public class Header {
        
    private final javax.swing.JPanel headerPanel;
    private final javax.swing.JLabel headerTitle;
    private final javax.swing.JLabel headerIcon;
    private final javax.swing.JLabel back;
    private final javax.swing.JLabel minimize;
    private final javax.swing.JLabel exit;
    private final int ScreenWidth;
    private JFrame backTo;
    int posX,posY;
    

    public Header (final JFrame frame, JPanel parentPanel){
        
        frame.setLocationRelativeTo(null);
        
        ScreenWidth = frame.getContentPane().getSize().width;
        
        headerPanel = new javax.swing.JPanel();
        headerTitle = new javax.swing.JLabel();
        headerIcon = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        
        headerPanel.setBackground(new Color(150, 40, 27));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        parentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 40, 27), 5)); 
        parentPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, ScreenWidth-10, 125));
        
        headerPanel.add(headerTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 35, -1, -1));
        headerPanel.add(headerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));
        headerPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, -1, -1));
        headerPanel.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(ScreenWidth-180, 35, -1, -1));
        headerPanel.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(ScreenWidth-100, 35, -1, -1));
        
        headerTitle.setFont(new java.awt.Font("Dialog", 1, 42)); 
        headerTitle.setForeground(new java.awt.Color(255, 255, 255));
        
        minimize.setIcon(new javax.swing.ImageIcon("icons\\icons8_Subtract_50px.png"));
        exit.setIcon(new javax.swing.ImageIcon("icons\\icons8_Delete_50px_1.png"));
        
        
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.setState(JFrame.ICONIFIED);
            }
        });
        
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.setVisible(false);
                backTo.setVisible(true);
            }
        });
        
        headerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                posX=evt.getX();
                posY=evt.getY();
            }
        });
        
        headerPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                frame.setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
            }
        });
        
    }
    
    public void setTitle(String header,String icon){
        headerTitle.setText(header);
        headerIcon.setIcon(new javax.swing.ImageIcon(icon));
    }
    
    public void setBackTo(JFrame frame){
        back.setIcon(new javax.swing.ImageIcon("icons\\icons8_Back_50px.png"));
        backTo = frame;
    }
}
