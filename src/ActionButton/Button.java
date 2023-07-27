/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author PhamNgocMinh
 */
public class Button extends JButton {

    private boolean mouse;

    public Button() {
        setIcon(new ImageIcon("Delete.png"));
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(4, 4, 4, 4));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gs = (Graphics2D) g.create();
        gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int hight = getHeight();
        int size = Math.min(width, hight);
        int x = (width - size) / 2;
        int y = (hight - size) / 2;
        if (mouse) {
            gs.setColor(new Color(158, 158, 158));
        } else {
            gs.setColor(new Color(190, 190, 190));
        }
        gs.fill(new Ellipse2D.Double(x, y, size, size));
        gs.dispose();
        super.paintComponent(g);
    }

}
