// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drivetrain extends SubsystemBase {
  // motor ports
  public static final int leftPrimaryMotorID = 4;
  public static final int leftSecondaryMotorID = 3;
  public static final int rightPrimaryMotorID = 2;
  public static final int rightSecondaryMotorID = 1;

  
  // change to wpi_talon to avoid inheritance problems 
  // may need to add final stuff
  private WPI_TalonFX leftPrimaryTalon = new WPI_TalonFX(leftPrimaryMotorID);
  private WPI_TalonFX rightPrimaryTalon = new WPI_TalonFX(rightPrimaryMotorID);
  private WPI_TalonFX leftSecondaryTalon = new WPI_TalonFX(leftSecondaryMotorID);
  private WPI_TalonFX rightSecondaryTalon = new WPI_TalonFX(rightSecondaryMotorID);

  //via encapsulation
  private DifferentialDrive m_differentialDrive = new DifferentialDrive(leftPrimaryTalon, rightPrimaryTalon);
 

  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {

    leftSecondaryTalon.follow(leftPrimaryTalon);
    rightSecondaryTalon.follow(rightPrimaryTalon);

    // must invert all 4 motors 
    // why invert? https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html?#axis-conventions - look here
    // simply, ccw rotations are positive, and ccw goes backwards
    rightSecondaryTalon.setInverted(true);
    rightPrimaryTalon.setInverted(true);
    /*
    leftVictor.setInverted(true);
    rightVictor.setInverted(true);
    */


  }

  // encapsulation of diff drive 
  public DifferentialDrive getDiffDrive() {
    return m_differentialDrive;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // ref arcade drive command from robotcontainer setdefaultcommand
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}


