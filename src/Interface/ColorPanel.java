package Interface;

import Controller.JInputJoystick;
import net.java.games.input.Controller;
import java.util.Hashtable;
import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    private JInputJoystick joystick = new JInputJoystick(Controller.Type.STICK, Controller.Type.GAMEPAD);
    int inity1=150;
    int inity2=150;
    int initx1=1175;
    int initx2=1175;
    public ColorPanel(Color backcolor) {
        setBackground(backcolor);
        repaint();
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.black);


        g2.drawLine(1000, 0, 1000, 600);   //vertical line
        g2.drawLine(1000, 300, 1500, 300); //horizontal line
        g2.drawLine(1000, 600, 1500, 600);
        g2.setColor(Color.blue);
        g2.drawLine(1000,150,1500,150); //SeaLevel
        g2.drawLine(1175,300,1175,600);
        g2.setColor(Color.green);
        //g2.drawLine(1025,150,1300,150); //SeaLevel
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
                g2.drawLine(1025,inity1,1300,inity2); //SeaLevel
                break;
            }
            else if(hstick==0.75) {
                g2.setColor(Color.green);
                inity1-=1;
                inity2+=1;
                g2.drawLine(initx1,325,initx2,575);
                g2.drawLine(1025, inity1, 1300, inity2); //SeaLevel
                break;
            } else if(hstick==1.0) {
                g2.setColor(Color.green);
                initx1-=1;
                initx2+=1;
                g2.drawLine(1025, inity1, 1300, inity2);
                g2.drawLine(initx1,325,initx2,575);
                break;
            } else if(hstick==0.5) {
                g2.setColor(Color.green);
                initx1+=1;
                initx2-=1;
                g2.drawLine(1025, inity1, 1300, inity2);
                g2.drawLine(initx1,325,initx2,575);
                break;
            } else {
                g2.setColor(Color.green);
                g2.drawLine(1025, inity1, 1300, inity2); //SeaLevel
                g2.drawLine(initx1,325,initx2,575);
                break;
            }
        }

    }
    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }
}
