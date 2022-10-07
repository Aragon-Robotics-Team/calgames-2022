// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;



/*
for intake:
- hopper using a talonsrx port 10
- getting the ball using a cansparkmax

todo:
- intake
=== button pressed --> pneumatics out
// false in
// true out
=== button held --> rollers take in ball --- use when pressed/when released
=== button pressed --> pneumatics in 
- talon srx for pneumatics
- cansparkmax for the rolelrs

- hopper
=== while button is pressed --> do motors (that get the ball rdy into slingshot position)
*/

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  // is it really brushless
  // arm roller controller
  private final CANSparkMax m_intake = new CANSparkMax(3, MotorType.kBrushless);
  // hopper roller controller
  private final TalonSRX m_roller = new TalonSRX(10); // port numero 10

  private final Solenoid m_solenoid = new Solenoid(1, PneumaticsModuleType.CTREPCM, 0); 
  // used to control the arm

  // get the ball
  private static final double intakeSpeed = 1.0;

  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // make the API here
  
  // move arm out
  public void armOut() {
    m_solenoid.set(true);
  }

  public void armIn() {
    m_solenoid.set(false);
  }

  // spin ball in
  public void intakeBall() {
    m_intake.set(1.0);
    m_roller.set(ControlMode.PercentOutput, 0.5);
  }

  // eject ball
  public void reverseBall() {
    m_intake.set(-1.0);
    m_roller.set(ControlMode.PercentOutput, -0.5);
  }

  public void resetMotors() {
    m_intake.set(0.0);
    m_roller.set(ControlMode.PercentOutput, 0.0);
  }
}
