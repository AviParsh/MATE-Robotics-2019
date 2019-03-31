package Interface.Panels.Graph;

import java.util.ArrayList;


public class Data {

    private ArrayList<Double> pitchValues;

    public Data(){
        pitchValues = new ArrayList<Double>();

    }

    public void updateData(String incomingString){
        String[] stringArray = incomingString.split(" ");
        switch(stringArray[0]){
            case ("Pitch:"):
                pitchValues.add(Double.parseDouble(stringArray[1].trim()));
                break;
            case ("Um:"):

        }
    }

    public String toString(){
        String output = "";

        output += "Pitch: [";
        for(int i = 0; i < pitchValues.size(); i++){
            output += Double.toString(pitchValues.get(i)) + ", ";
        }
        output += "]";

        return output;
    }

}
