package com.mycompany.inventory_system.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {

    private int roundness = 20; 

    public RoundedPanel(int roundness) {
        this.roundness = roundness;
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
        RoundRectangle2D roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundness, roundness);
        g2d.setColor(getBackground()); 
        g2d.fill(roundedRect);

        super.paintComponent(g);
        g2d.dispose();
    }
}