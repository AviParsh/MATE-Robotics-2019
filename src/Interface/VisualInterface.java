package Interface;

import Interface.Panels.ColorPanel;
import net.java.games.input.Controller;
import Controls.JInputJoystick;
import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;


public class VisualInterface{
    private JInputJoystick joystick = new JInputJoystick(Controller.Type.STICK, Controller.Type.GAMEPAD);

    public VisualInterface(){

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Visual Interface");
        JPanel panel = new JPanel();
        //ColorPanel linepanel = new ColorPanel();
        Container c = frame.getContentPane();

        JSlider leftSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        Dimension dl = leftSlider.getPreferredSize();
        leftSlider.setPreferredSize(new Dimension(dl.width+50,dl.height+550));
        leftSlider.setBounds(0,0,100,200);

        JSlider rightSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        Dimension dr = rightSlider.getPreferredSize();
        rightSlider.setPreferredSize(new Dimension(dr.width+50,dr.height+550));
        rightSlider.setBounds(0,0,100,200);

        leftSlider.setPaintLabels(true);
        rightSlider.setPaintLabels(true);

        // Add positions label in the slider
        Hashtable position = new Hashtable();
        JLabel l1 = new JLabel("-50");
        JLabel l2 = new JLabel("0");
        JLabel l3 = new JLabel("50");
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l3.setForeground(Color.white);

        position.put(-50, l1);
        position.put(0, l2);
        position.put(50, l3);

        // Set the label to be drawn
        leftSlider.setLabelTable(position);
        rightSlider.setLabelTable(position);
        panel.add(leftSlider,BorderLayout.WEST);
        panel.add(rightSlider,BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.white,3));
        frame.add(panel,BorderLayout.EAST);
       // frame.add(linepanel);
        frame.setSize(1500,800);
        frame.setVisible(true);
        leftSlider.setBackground(new Color(44,62,80));
        rightSlider.setBackground(new Color(44,62,80));
        panel.setBackground(new Color(84, 110, 122));

        c.setBackground(new Color(44,62,80));



        // Check if the controller was found.
        if (!joystick.isControllerConnected()) {
            System.out.println("No controller found!");
        }

        int yvall, yvalr;
        float hstick;
        int t = 1;
        while(t==1) {
            // Get current state of joystick! And check, if joystick is disconnected.
            if (!joystick.pollController()) {
                System.out.println("Controller disconnected!");
                break;
            }

            yvall = getyvall();
            yvalr = getyvalr();
            hstick = gethpos();
            leftSlider.setValue(yvall);
            rightSlider.setValue(yvalr);
            //System.out.println(hstick);

            if(hstick==.25){
                frame.repaint();
                System.out.println("left");

            }
            if(hstick==.75){
                frame.repaint();
            }

        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //following 4 functions are to get joystick pos
    public int getyvalr(){
        if (joystick.getControllerType() == Controller.Type.STICK) {
            return (joystick.getZRotationPercentage()-50)*-1;
        }
        else {
            return (joystick.getYRotationPercentage()-50)*-1;
        }
    }
    public int getxvalr(){
        if (joystick.getControllerType() == Controller.Type.STICK) {
            return joystick.getZAxisPercentage();
        }
        else {
            return joystick.getXRotationPercentage();
        }
    }
    public int getyvall(){
        return (joystick.getYAxisPercentage()-50)*-1;
    }
    public int getxvall(){
        return joystick.getXAxisPercentage();
    }

    //following function is to get dpad pos
    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }
}