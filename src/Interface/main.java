package Interface;
import Controller.control;
//import Serial.Serial;
//import com.fazecast.jSerialComm.SerialPort;

import Controller.JInputJoystick;
import net.java.games.input.Controller;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       //VisualInterface gui = new VisualInterface();
        GUIWindow gui = new GUIWindow();
        control logitech = new control();

       System.out.println("cool");
        System.out.println(logitech.numButtons());
       while(true){

           System.out.println(logitech.getButtonVal());
       }

    }


}
