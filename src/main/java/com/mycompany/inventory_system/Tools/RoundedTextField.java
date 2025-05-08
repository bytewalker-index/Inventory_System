package com.mycompany.inventory_system.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {

    private int roundness = 15; 

    public RoundedTextField(int roundness) {
        this.roundness = roundness;
        setOpaque(false); 
        setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D roundedRect = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, roundness, roundness);
        g2d.setColor(getBackground());
        g2d.fill(roundedRect);

        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getForeground()); 
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, roundness, roundness);
        g2d.dispose();
    }
}