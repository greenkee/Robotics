/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Justin
 */
public class Strafe extends CommandBase {
    
    public Strafe() {
        // Use requires() here to declare subsystem dependencies
       requires(motors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(.5);
        motors.backLeft.set(-.4);
        motors.backRight.set(.4);
        motors.frontLeft.set(.4);
        motors.frontRight.set(-.4);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
                motors.backLeft.set(0);
        motors.backRight.set(0);
        motors.frontLeft.set(0);
        motors.frontRight.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        motors.backLeft.set(0);
        motors.backRight.set(0);
        motors.frontLeft.set(0);
        motors.frontRight.set(0);
    }
}
