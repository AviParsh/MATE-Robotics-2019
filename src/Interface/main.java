package Interface;
import Controls.Controller;

//import Serial.Serial;
//import com.fazecast.jSerialComm.SerialPort;


public class main {
    public static void main(String[] args) {
       VisualInterface gui = new VisualInterface();
        //GUIWindow gui = new GUIWindow();
        Controller logitech = new Controller();

       System.out.println("cool");
        System.out.println(logitech.numButtons());
       while(true){

           System.out.println(logitech.getButtonVal());
       }

    }


}
