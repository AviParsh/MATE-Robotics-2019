

import Controls.gamepad;
import Interface.Panels.*;
import Interface.Panels.Graph.GraphPanel;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;
import java.awt.*;

public class GUIWindow extends JFrame {
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private gamepad logitech;
    private boolean runningStatus;

    public GUIWindow(){
        intializeWindow();

        logitech = new gamepad();
        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.setLayout(new GridLayout(1, 7));
        middlePanel.setLayout(new GridLayout(1, 3));
        bottomPanel.setLayout(new GridLayout(1, 2));

        //top panels
        GraphPanel graph1 = new GraphPanel();
        GraphPanel graph2 = new GraphPanel();
        GraphPanel graph3 = new GraphPanel();
        GraphPanel graph4 = new GraphPanel();
        GraphPanel graph5 = new GraphPanel();
        GraphPanel graph6 = new GraphPanel();
        GraphPanel graph7 = new GraphPanel();

        //middle panels
        ViewPanel views = new ViewPanel();
        SliderPanel sliders = new SliderPanel();
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setImageSizeDisplayed(true);

        topPanel.add(graph1);
        topPanel.add(graph2);
        topPanel.add(graph3);
        topPanel.add(graph4);
        topPanel.add(graph5);
        topPanel.add(graph6);
        topPanel.add(graph7);

        sliders.setBackground(new Color(84, 110, 122));
        webcamPanel.setBackground(new Color(84, 110, 122));

        middlePanel.add(views);
        middlePanel.add(webcamPanel);
        middlePanel.add(sliders);

        //bottom panels
        LabelPanel label = new LabelPanel();
        ButtonPanel buttons = new ButtonPanel();

        bottomPanel.add(label);
        bottomPanel.add(buttons);


        Container pane = this.getContentPane();

        pane.setLayout(new GridLayout(3, 1));


        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(middlePanel, BorderLayout.CENTER);
        pane.add(bottomPanel, BorderLayout.SOUTH);


        while(runningStatus == true){
            if (logitech.getpolstatus()==false) {
                System.out.println("gamepad disconnected!");
                break;
            }
            sliders.setLeftSliderpos(logitech.getyvall());
            sliders.setRightSliderpos(logitech.getyvalr());
            sliders.update(sliders.getHeight()); //updates height when form is resized
        }

    }

    private void intializeWindow(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1500,750);
        this.setResizable(true);
        runningStatus = true;
    }


}
