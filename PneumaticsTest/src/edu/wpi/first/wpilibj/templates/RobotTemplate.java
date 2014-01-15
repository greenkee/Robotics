/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    DoubleSolenoid solenoid1 = new DoubleSolenoid(6,7);
    DoubleSolenoid solenoid2 = new DoubleSolenoid(4,5);
    Compressor compressor = new Compressor(2,3); //pressureSwitchChannel, compressorRelayChannel
    Joystick stick = new Joystick (1);
    Button trigger = new JoystickButton(stick,1);
    boolean solenoidPosition = false; //true is forwards
    boolean compressing = false;
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        System.out.println("Teleop");
        while (true){
            if((!compressor.getPressureSwitchValue()) && (!compressing)){
                compressor.start();
                compressing = true;
            }
            if (compressor.getPressureSwitchValue()){
                compressor.stop();
                compressing = false;
            }
            if (trigger.get()){
                if(solenoidPosition){
                    solenoid1.set(DoubleSolenoid.Value.kForward);
                     solenoid2.set(DoubleSolenoid.Value.kForward);
                    solenoidPosition = false;
                    System.out.println(solenoidPosition);
                    Timer.delay(.5);
                   }
                else{
                    solenoid1.set(DoubleSolenoid.Value.kReverse);
                    solenoid2.set(DoubleSolenoid.Value.kReverse);
                    solenoidPosition = true;
                    System.out.println(solenoidPosition);
                   Timer.delay(.5);
                }
            }
        }

    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
