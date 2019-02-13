package Interface;

import Controller.JInputJoystick;
import net.java.games.input.Controller;
import java.util.Hashtable;
import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    private JInputJoystick joystick;
    double slope = 0;
    double x1S = 1070; //Side view variables
    double x2S = 1195;
    double y1S = 150;
    double y2S = 0;
    double x1F = 1070; //Front view variables
    double x2F = 1195;
    double y1F = 450;
    double y2F = 0;

    public ColorPanel(Color backcolor, JInputJoystick j) {
        setBackground(backcolor);
        joystick = j;
        repaint();
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.blue);
        g2.drawLine(920,150,1220,150); //SeaLevel Side View
        g2.drawLine(920,450,1220,450); //SeaLevel Front View

        //double box lines
        g2.setColor(Color.black);
        g2.drawLine(920, 0, 920, 600);
        g2.drawLine(920, 300, 1220, 300);
        g2.drawLine(920, 600, 1220, 600);
        g2.drawLine(920, 1, 1220, 1);
        g2.drawLine(1220, 0, 1220, 600);

        g2.setColor(Color.green);

        float hstick = 0;
        int i = 1;
        while(i==1) {
            hstick = gethpos();
            g2.setColor(Color.green);
            if(hstick!=0) {
                if (hstick == 0.25) {           //up
                    slope = slope - 0.05;
                    if (slope <= -1) {
                        slope = -1;
                    }
                    y2S = slope * (x2S - x1S) + y1S;
                    g2.drawLine((int) x1S, (int) y1S, (int) x2S, (int) y2S); //side view line
                    break;
                } else if (hstick == 0.75) {    //down
                    slope = slope + 0.05;
                    System.out.println(slope);
                    if (slope >= 1) {
                        slope = 1;
                    }
                    y2S = slope * (x2S - x1S) + y1S;
                    g2.drawLine((int) x1S, (int) y1S, (int) x2S, (int) y2S); //side view line
                    break;
                }
                if (hstick == 1.0) {            //left
                    slope = slope + 0.05;
                    if (slope >= 1) {
                        slope = 1;
                    }
                    y2F = slope * (x2F - x1F) + y1F;
                    g2.drawLine((int) x1F, (int) y1F, (int) x2F, (int) y2F); //front view line
                    break;
                } else if (hstick == 0.5) {     //right
                    slope = slope - 0.05;
                    if (slope <= -1) {
                        slope = -1;
                    }
                    y2F = slope * (x2F - x1F) + y1F;
                    g2.drawLine((int) x1F, (int) y1F, (int) x2F, (int) y2F); //front view line
                    break;
                }
            } else {
                if(slope == 0){
                    g2.drawLine((int) x1S, (int) y1S, (int) x2S, (int) y1S); //side view line
                    g2.drawLine((int) x1F, (int) y1F, (int) x2F, (int) y1F); //front view line
                }else {
                    g2.drawLine((int) x1S, (int) y1S, (int) x2S, (int) y2S); //side view line
                    g2.drawLine((int) x1F, (int) y1F, (int) x2F, (int) y2F); //front view line
                    break;
                }
            }
        }


    }
    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }
}