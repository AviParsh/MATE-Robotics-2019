package Interface;

import Interface.Panels.CameraPanel;
import Interface.Panels.Graph.GraphPanel;
import Interface.Panels.SliderPanel;
import Interface.Panels.ViewPanel;
import Interface.Panels.LabelPanel;
import Interface.Panels.ButtonPanel;


import javax.swing.*;
import java.awt.*;

public class GUIWindow extends JFrame {

    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;

    public GUIWindow(){
        intializeWindow();

        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.setLayout(new GridLayout(1, 7));
        middlePanel.setLayout(new GridLayout(1, 2));
        bottomPanel.setLayout(new GridLayout(1, 2));

        GraphPanel graph1 = new GraphPanel();
        GraphPanel graph2 = new GraphPanel();
        GraphPanel graph3 = new GraphPanel();
        GraphPanel graph4 = new GraphPanel();
        GraphPanel graph5 = new GraphPanel();
        GraphPanel graph6 = new GraphPanel();
        GraphPanel graph7 = new GraphPanel();

        CameraPanel camera = new CameraPanel();

        JPanel rightPanel = new JPanel(new GridLayout(1, 2));
        ViewPanel views = new ViewPanel();
        SliderPanel sliders = new SliderPanel();

        rightPanel.add(views);
        rightPanel.add(sliders);

        graph1.setBackground(Color.RED);
        graph2.setBackground(Color.orange);
        graph3.setBackground(Color.yellow);
        graph4.setBackground(Color.green);
        graph5.setBackground(Color.blue);
        graph6.setBackground(Color.magenta);
        graph7.setBackground(Color.black);

        topPanel.add(graph1);
        topPanel.add(graph2);
        topPanel.add(graph3);
        topPanel.add(graph4);
        topPanel.add(graph5);
        topPanel.add(graph6);
        topPanel.add(graph7);

        camera.setBackground(Color.cyan);

        middlePanel.add(camera);
        middlePanel.add(rightPanel);

        LabelPanel label = new LabelPanel();
        ButtonPanel buttons = new ButtonPanel();

        bottomPanel.add(label);
        bottomPanel.add(buttons);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(3, 1));

        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(middlePanel, BorderLayout.CENTER);
        pane.add(bottomPanel, BorderLayout.SOUTH);

    }

    private void intializeWindow(){
        System.out.println("GUI initialized.");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);
    }

}
