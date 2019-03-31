package Controller;

import net.java.games.input.Controller;

public class Controller {
    private JInputJoystick joystick;

    public Controller(){
        joystick = new JInputJoystick(net.java.games.input.Controller.Type.STICK, net.java.games.input.Controller.Type.GAMEPAD);
    }

    public int getyvalr(){
        if (joystick.getControllerType() == net.java.games.input.Controller.Type.STICK) {
            return (joystick.getZRotationPercentage()-50)*-1;
        }
        else {
            return (joystick.getYRotationPercentage()-50)*-1;
        }
    }

    public int getxvalr(){
        if (joystick.getControllerType() == net.java.games.input.Controller.Type.STICK) {
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

    public int numButtons() {
        joystick.pollController();
        return joystick.getNumberOfButtons(); }

    //following function is to get dpad pos
    public float gethpos(){
        return joystick.getHatSwitchPosition();
    }

    public float getButtonVal (){
        joystick.pollController();
        for(int i = 0; i<10; i++){
            if(joystick.getButtonValue(i)) {
                return i;
            }

        }

        return 90;
    }
}
