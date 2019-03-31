//import Interface.Panels.Graph.Serial.Interface.Panels.Graph.Serial;
//import com.fazecast.jSerialComm.SerialPort;

import Interface.Panels.Graph.Data;
import Interface.Panels.Graph.Serial;

public class main {
    public static void main(String[] args) {
       // VisualInterface gui = new VisualInterface();
       // GUIWindow gui = new GUIWindow();

        Serial ser = new Serial();
        Data d = new Data();

        d.updateData(ser.getReading());
        d.updateData(ser.getReading());

        System.out.println(d.toString());

//
//       Interface.Panels.Graph.Serial s = new Interface.Panels.Graph.Serial(1);
//       int t = 1;
//       while(t==1) {
//           System.out.println(s.getPitcb());
//       }
    }

}
