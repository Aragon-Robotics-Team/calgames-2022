// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class MoveUp extends CommandBase {
  /** Creates a new MoveUp. */
  private Shooter m_shooter;

  public MoveUp(Shooter shooter) {
    m_shooter = shooter;
    // Use addRequirrements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.resetServo();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // this part acts as a periodic()

    // move it up
    m_shooter.setMotorSpeed(Shooter.kRunningSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // figure out how to call this function in this command
    return m_shooter.getUpperLimit();
  }
}
