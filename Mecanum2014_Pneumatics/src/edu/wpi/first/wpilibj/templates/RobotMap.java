package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int LEFT_MOTOR_BACK = 3;
    public static final int LEFT_MOTOR_FRONT = 4;
    public static final int RIGHT_MOTOR_BACK = 1;
    public static final int RIGHT_MOTOR_FRONT = 2;
    public static final int GYRO_PORT = 2;
    public static final int GYRO_BUTTON_NUMBER = 3;
    public static final int PNEUMATICS_BUTTON_NUMBER =1;
    public static final int DOUBLE_SOLENOID_1_PORT = 1;
    public static final int DOUBLE_SOLENOID_2_PORT = 2;
    public static final int COMPRESSOR_PORT = 1;
            
}
