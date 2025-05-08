package com.mycompany.inventory_system.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private int roundness = 20;

    public RoundedButton(String text, int roundness) {
        super(text);
        this.roundness = roundness;
        setContentAreaFilled(false); 
        setFocusPainted(false); 
        setBorderPainted(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundness, roundness);
        g2d.setColor(getModel().isArmed() ? getBackground().darker() : getBackground()); 
        g2d.fill(roundedRect);

        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        
    }
}