package Interface;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    public ColorPanel(Color backcolor) {
        setBackground(backcolor);
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //vertical line
        g.setColor(Color.red);
        g.drawLine(20, 20, 20, 120);

        //horizontal line
        g.setColor(Color.green);
        g.drawLine(20, 20, 120, 20);

        //diagonal line
        g.setColor(Color.blue);
        g.drawLine(20, 20, 120, 120);

    }
}
