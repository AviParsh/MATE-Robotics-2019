package Controls;

public class gamepad {
    private JInputJoystick joystick;

    public gamepad(){
        joystick = new JInputJoystick(net.java.games.input.Controller.Type.STICK, net.java.games.input.Controller.Type.GAMEPAD);
        if (!joystick.isControllerConnected()) {
            System.out.println("No controller found!");
        }
    }

    public int getyvalr(){
        joystick.pollController();
        if (joystick.getControllerType() == net.java.games.input.Controller.Type.STICK) {
            return (joystick.getZRotationPercentage()-50)*-1;
        }
        else {
            return (joystick.getYRotationPercentage()-50)*-1;
        }
    }

    public int getxvalr(){
        joystick.pollController();
        if (joystick.getControllerType() == net.java.games.input.Controller.Type.STICK) {
            return joystick.getZAxisPercentage();
        }
        else {
            return joystick.getXRotationPercentage();
        }
    }

    public int getyvall(){
        joystick.pollController();
        return (joystick.getYAxisPercentage()-50)*-1;
    }

    public int getxvall(){
        joystick.pollController();
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

    public boolean getpolstatus(){
        return(joystick.pollController());
    }
}
