package Interface;

import net.java.games.input.Controller;
import Controller.JInputJoystick;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;


public class VisualInterface{
    private JInputJoystick joystick = new JInputJoystick(Controller.Type.STICK, Controller.Type.GAMEPAD);

    public VisualInterface(){

        JFrame frame = new JFrame();
        frame.setTitle("Visual Interface");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ColorPanel p = new ColorPanel(Color.WHITE);

        JButton Button1 = new JButton("Button");
        JButton Button2 = new JButton("Button");

        JSlider leftSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
        JSlider rightSlider = new JSlider(JSlider.VERTICAL, -50, 50, 0);

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

        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        //options
        p.setLayout(null);

        Button1.setLocation(1250, 620);
        Button2.setLocation(100, 100);

        leftSlider.setLocation(1350,0);
        rightSlider.setLocation(1250,0);

        Button1.setSize(new Dimension(200, 100));
        Button2.setSize(new Dimension(100, 100));

        leftSlider.setSize(new Dimension(100,600));
        rightSlider.setSize(new Dimension(100,600));

        leftSlider.setBackground(new Color(44,62,80));
        rightSlider.setBackground(new Color(44,62,80));
        leftSlider.setBorder(BorderFactory.createLineBorder(Color.black,3));
        rightSlider.setBorder(BorderFactory.createLineBorder(Color.black,3));
        Button1.setBackground(new Color(44,62,80));
        Button1.setBorder(BorderFactory.createLineBorder(Color.black,3));
        Button1.setForeground(Color.white);


        p.add(Button1);
        p.add(Button2);
        p.add(leftSlider);
        p.add(rightSlider);

        frame.add(p);
        frame.revalidate();
        frame.setVisible(true);



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
            }
            if(hstick==.75){
                frame.repaint();
            }
            if(hstick==1.0){
                frame.repaint();
            }
            if(hstick==0.5){
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