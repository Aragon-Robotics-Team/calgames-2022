// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climbCommands;

import frc.robot.subsystems.Climb;
import edu.wpi.first.wpilibj2.command.CommandBase;

// this file and the other one is replaced by an instant command
public class ClimbUp extends CommandBase {
  /** Creates a new ClimbUp. */
  private Climb m_climb;

  public ClimbUp(Climb climb) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_climb = climb;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_climb.setState(true);
    // sets solenoid to true or makes the climb goes up
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
