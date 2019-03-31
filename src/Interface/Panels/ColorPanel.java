package Interface.Panels;

import Controls.JInputJoystick;
import Interface.Line;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    private JInputJoystick joystick;
    private Line Hor;
    private Line l2;



    public ColorPanel(Color backcolor, JInputJoystick j) {
        setBackground(backcolor);
        joystick = j;
        Hor = new Line(920,150,1220,150);
        l2 = new Line(920,200,1220,200);


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

                break;
            }
            else if(hstick==0.75) {
                g2.setColor(Color.green);

                break;
            } else if(hstick==1.0) { //left
                g2.setColor(Color.green);
                Hor.draw(g2);
                Hor.rotate("cc");

                break;
            } else if(hstick==0.5) { //right
                g2.setColor(Color.green);
                Hor.draw(g2);
                Hor.rotate("c");

                break;
            } else {
                g2.setColor(Color.green);

                break;
            }

        }
        Hor.draw(g2);
        l2.rotateto(70);
        l2.draw(g2);


    }
    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }
}