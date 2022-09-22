package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends CommandBase { 

    private Drivetrain drivetrain;
    private Joystick driveJoystick;

    
    public ArcadeDrive(Drivetrain m_drivetrain, Joystick joystick) {
        // use getDiffDrive() to get the differential
        driveJoystick = joystick;
        drivetrain = m_drivetrain;
    }   

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        // this is the arcade drive part
        drivetrain.getDiffDrive().arcadeDrive(-driveJoystick.getY(), driveJoystick.getX());
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}


// todo

// make arcade drive in here