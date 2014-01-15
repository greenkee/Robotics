
/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
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

    
    static final int JOYSTICK_PORT = 1;
    static final int SHOOTER_PORT = 5;
    static final int CAMSHAFT_PORT = 4;
    static final double DEADBAND = .1;
    
    Victor shooter = new Victor(SHOOTER_PORT);
    Victor camShaft = new Victor(CAMSHAFT_PORT);
    
    Joystick stick = new Joystick(JOYSTICK_PORT);
    Button camButton = new JoystickButton(stick, 2);
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public double getY(){
	if (stick.getY()>1.0){
	 return 1;}
	else if (stick.getY() < 0){
	return 0;}
	else {
	return stick.getY();}
  
        //return ((stick.getY() > 1.0) ? 1.0: ((stick.getY() < 0)? 0: stick.getY()));
    }
    public boolean getCamButton(){
        return camButton.get();
    }
    
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        System.out.println("Operator control enabled");
        while(isOperatorControl() && isEnabled()){
            if(getY() > DEADBAND){
                shooter.set(getY());
                System.out.println(stick.getY());
                
                

             //   Timer.delay(.1);
            } 
            if(getCamButton()){
                    camShaft.set(1);
                 }else{
camShaft.set(0);

}
//            else{
  //              shooter.set(0);
    //            camShaft.set(0);
      //      }  
            //time to run each loop
            Timer.delay(.1);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }

}


