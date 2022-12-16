/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author lopez
 */
public class MyButton extends JButton {

    public MyButton() {
//        super(texto);
        //init color
        setColor(Color.WHITE);
        colorOver = new Color(255,244,153);
        bordeColor = new Color(7, 35, 140);
        bg = new Color(253,254,97);
        colorClick = new Color(255, 255, 0);
        
        setContentAreaFilled(false);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e){
                setBackground(bg);
            }
            
            @Override
            public void mouseEntered(MouseEvent e){
                setBackground(colorOver);
            }
            
            @Override
            public void mousePressed(MouseEvent e){
                setBackground(colorClick);
            }
        });

    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBordeColor() {
        return bordeColor;
    }

    public void setBordeColor(Color bordeColor) {
        this.bordeColor = bordeColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color bg;
    private Color colorClick;
    private Color bordeColor;
    private int radius = 0;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //pintar bordes
        g2.setColor(bordeColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //border set 2 pixeles
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(g);
    }
    
//    @Override
//    protected void paintChildren(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        GradientPaint g1 = new GradientPaint(0,0,Color.decode("#fffc00"), 0,getHeight(),Color.decode("#ffffff"));
//        g2.setPaint(g1);
//        g.fillRoundRect(0, 0, getWidth(), getWidth(), radius, radius);
//        super.paintChildren(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//
//    }

}
