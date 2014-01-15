/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author Justin
 */
public class CompressorOperator extends CommandBase {
    final double DELAY = .2;
    public CompressorOperator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(!pneumaticsSystem.compressorValue()){
            Scheduler.getInstance().add(new Compress());
            while(!Compress.compressorFinished){
                Timer.delay(DELAY);
            }
          }
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
}
