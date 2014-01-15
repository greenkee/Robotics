/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin
 */
package edu.wpi.first.wpilibj.templates.commands;
public class Compress extends CommandBase {

    /**
     *
     */
    public static boolean compressorFinished;
    public Compress() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
     }

    // Called just before this Command runs the first time
    protected void initialize() {
        pneumaticsSystem.startCompressor();
        compressorFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pneumaticsSystem.compressorValue();
    }

    // Called once after isFinished returns true
    protected void end() {
        pneumaticsSystem.stopCompressor();
        compressorFinished = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        pneumaticsSystem.stopCompressor();
          compressorFinished = true;
    }
}
