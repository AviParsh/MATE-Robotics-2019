package Interface;

import Controller.JInputJoystick;
import net.java.games.input.Controller;
import java.util.Hashtable;
import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    private JInputJoystick joystick;
    int inity1=150;
    int inity2=150;
    int initx1=1070;
    int initx2=1070;

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
        while(i==1){
            hstick = gethpos();
            //System.out.println(hstick);

            if(hstick==0.25){
                g2.setColor(Color.green);
                inity1+=1;
                inity2-=1;
                g2.drawLine(initx1,325,initx2,575);
                g2.drawLine(945,inity1,1195,inity2); //SeaLevel
                break;
            }
            else if(hstick==0.75) {
                g2.setColor(Color.green);
                inity1-=1;
                inity2+=1;
                g2.drawLine(initx1,325,initx2,575);
                g2.drawLine(945, inity1, 1195, inity2); //SeaLevel
                break;
            } else if(hstick==1.0) {
                g2.setColor(Color.green);
                initx1-=1;
                initx2+=1;
                g2.drawLine(945, inity1, 1195, inity2);
                g2.drawLine(initx1,325,initx2,575);
                break;
            } else if(hstick==0.5) {
                g2.setColor(Color.green);
                initx1+=1;
                initx2-=1;
                g2.drawLine(945, inity1, 1195, inity2);
                g2.drawLine(initx1,325,initx2,575);
                break;
            } else {
                g2.setColor(Color.green);
                g2.drawLine(945, inity1, 1195, inity2); //SeaLevel
                g2.drawLine(initx1,325,initx2,575);
                break;
            }
        }
        //sup

    }
    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }
}