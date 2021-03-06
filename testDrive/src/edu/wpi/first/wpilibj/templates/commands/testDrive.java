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
public class testDrive extends CommandBase {
    
   public final double DEADBAND = .4;
    private final double SENSITIVITY = .6;
    public double xValue;
    public double yValue;
    public double twist;
    public testDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(motors);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    yValue = SENSITIVITY*fixDeadBand(oi.getJoystick1().getY(), DEADBAND);
    xValue = SENSITIVITY*fixDeadBand(oi.getJoystick1().getX(), DEADBAND);
    twist = SENSITIVITY*fixDeadBand(oi.getJoystick1().getTwist(), DEADBAND*2); //double deadband

    if ((xValue > .5)&&(yValue == 0)){
        motors.leftBackMove(.5);
    }
        if ((xValue < -.5)&&(yValue == 0)){
        motors.leftFrontMove(.5);
    }
            if ((yValue > .5)&&(xValue == 0)){
        motors.rightBackMove(.5);
    }
                if ((yValue <-.5)&&(xValue == 0)){
        motors.rightFrontMove(.5);
    }

   // Robot.driveTrain.mecanumDrive.mecDrive(yValue, xValue, twist);    
        
    //driveTrain.mecanumDrive.mecanumDrive_Cartesian(-xValue, 
           // -yValue, -twist,0); //x,y,rotation,gyroAngle
//     driveTrain.mecanumDrive.mecanumDrive_Polar(-SENSITIVITY*fixDeadBand(oi.getJoystick1().getMagnitude(),
// DEADBAND), -SENSITIVITY*fixDeadBand( oi.getJoystick1().getDirectionDegrees(),DEADBAND), -SENSITIVITY*
//         fixDeadBand(oi.getJoystick1().getTwist(), DEADBAND*2));
    
    //forward - left back (yValue negative)
    //backward - right forward
    //right - 
    
    //twist, xValue, yValue
    if(Math.abs(xValue + yValue + twist) > 0){
        System.out.println("X: " + xValue + " Y: " + yValue + " T: " + twist);
        System.out.println("FL: "+ motors.frontLeft.get() + " BL: " +
                motors.backLeft.get() + " FR: " + motors.frontRight.get() + " BR: " +
                motors.backRight.get());
    }
 

//    Robot.oi.getJoystick1().getTwist());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
     }
    
    private double fixDeadBand(double speed, double deadBand) {
        return (Math.abs(speed) > deadBand ? speed : 0.0);
    }
}
