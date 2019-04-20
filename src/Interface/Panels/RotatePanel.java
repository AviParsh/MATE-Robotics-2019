package Interface.Panels;

import Controls.JInputJoystick;
import Interface.Line;
import net.java.games.input.Controller;

import javax.swing.*;
import java.awt.*;

public class RotatePanel extends JPanel {
    private Line line;
    private String type;
    private JInputJoystick joystick = new JInputJoystick(Controller.Type.STICK, Controller.Type.GAMEPAD);


    public RotatePanel(int rad,String type,Dimension d){
        //this.setSize(d.width/2,d.height/2);


        int width = d.width/2;
        int height = d.height;
        if(type.equals("pitch")) {
            line = new Line((width / 2 )- rad, height / 2, ( width/ 2) + rad ,  height/ 2);
            this.type = type;
        }else if(type.equals("yaw")){
            line = new Line(width/2,height/2-rad,width/2,height/2+rad);
            this.type = type;


        }

        repaint();
        setLayout(new GridLayout());

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;



        float hstick;

        int i = 1;

        while(i==1){
            hstick = gethpos();
            System.out.println(hstick);

            if (!joystick.pollController()) {
                System.out.println("Controller disconnected!");
                break;
            }

            if(hstick==0.25){
                g2.setColor(Color.green);
                System.out.println("up");

                break;
            }
            else if(hstick==0.75) {
                g2.setColor(Color.green);

                break;
            } else if(hstick==1.0) { //left
                g2.setColor(Color.green);
                line.draw(g2);
                line.rotate("cc");

                break;
            } else if(hstick==0.5) { //right
                g2.setColor(Color.green);
                System.out.println("aye");

                line.draw(g2);
                line.rotate("c");

                break;
            } else {
                g2.setColor(Color.green);

                break;
            }

        }
        line.draw(g2);





    }

    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }






}

