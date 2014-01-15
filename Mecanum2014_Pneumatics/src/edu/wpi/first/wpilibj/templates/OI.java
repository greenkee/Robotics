
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.Compress;
import edu.wpi.first.wpilibj.templates.commands.MecanumDrive;
import edu.wpi.first.wpilibj.templates.commands.SolenoidMove;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    
    public Joystick joystick1;
    public Button gyroReset;
    public JoystickButton pneumaticsButton;

    public OI() {

        joystick1 = new Joystick(1);
	gyroReset = new JoystickButton(joystick1,RobotMap.GYRO_BUTTON_NUMBER);   
        pneumaticsButton = new JoystickButton(joystick1, RobotMap.PNEUMATICS_BUTTON_NUMBER);
        // SmartDashboard Buttons

        SmartDashboard.putData("Mecanum Drive", new MecanumDrive());
        SmartDashboard.putData("Compressor", new Compress());
        SmartDashboard.putData("Solenoids" , new SolenoidMove());
       
    }
    public Joystick getJoystick1() {
        return joystick1;
    }
    public boolean getGyroReset(){
        return gyroReset.get();
    }
        public boolean getPneumaticsButton(){
        return pneumaticsButton.get();
    }
    
    
//Axis indexes:
//1 - LeftX
//2 - LeftY
//3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
//4 - RightX
//5 - RightY
//6 - DPad Left/Right
//double axisValue = mXboxController.getRawAxis(2); // Where "2" is the index of the Y axis on the left stick (see above)
}

