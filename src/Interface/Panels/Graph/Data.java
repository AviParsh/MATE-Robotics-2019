package Interface.Panels.Graph;

import java.util.ArrayList;


public class Data {

    private ArrayList<Double> Values;


    public Data(){
        Values = new ArrayList<Double>();
        int i;

        i = 0;

    }

    public void updateData(String incomingString){
        String[] stringArray = incomingString.split(" ");
        int i = 0;

        while (i<stringArray.length) {
            switch (stringArray[0]) {
                case ("Pitch:"):
                    Values.add(Double.parseDouble(stringArray[i].trim()));
                    break;
                case ("Um:"):

            }
            i++;

        }

    }


    public ArrayList<Double> getData(String in){
        updateData(in);
        return Values;
    }





    public String toString(){
        String output = "";

        output += "Pitch: [";
        for(int i = 0; i < Values.size(); i++){
            output += Double.toString(Values.get(i)) + ", ";
        }
        output += "]";

        return output;
    }

}
