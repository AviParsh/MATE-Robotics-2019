package Interface.Panels;

import javax.swing.*;
import java.awt.*;
import Graphics.CircleButton;

public class ButtonPanel extends JPanel {

    private JButton killButton;
    private JButton shutDownButton;
    private JButton button1;
    private JButton button2;

    public ButtonPanel(){
        setBorder(BorderFactory.createLineBorder(Color.white,3));
        setBackground(new Color(84, 110, 122));
        shutDownButton = new CircleButton("Terminate");
        killButton = new CircleButton("Kill Thrusters");
        button1 = new CircleButton("button1");
        button2 = new CircleButton("button2");
        this.setLayout(new GridLayout(1, 4));

        shutDownButton.setForeground(Color.RED);
        shutDownButton.setBackground(Color.blue);
        shutDownButton.setForeground(Color.blue);

        this.add(killButton);
        this.add(shutDownButton);
        this.add(button1);
        this.add(button2);
    }


}
