// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch.Type;

public class Shooter extends SubsystemBase {
  /*
  to make:
  in 3 new commands:
  - make a command to move the motor until its at the highest point
  - do the same ^ but lowest
  - release/switch th
  */

  // make all the functions here "API"


  public static final double kRunningSpeed = 0.75;

  // why is this giving me errors
  // make the motor (this is the thing that pushes the ball)
  // speed: 7
  private final CANSparkMax m_motor = new CANSparkMax(7, MotorType.kBrushless);

  // don't ask me why there's a 9 here
  private final Servo m_servo = new Servo(9);

  public Shooter() {
    m_motor.setInverted(false);
    // figure out how to run the function from here
  }

  public boolean getUpperLimit() {
    return m_motor.getReverseLimitSwitch(Type.kNormallyClosed).isPressed();
  }

  public boolean getLowerLimit() {
    return m_motor.getForwardLimitSwitch(Type.kNormallyClosed).isPressed();
  }

  // do i make this static or-
  public void setMotorSpeed(double speed){
    m_motor.set(speed);
  }
  // probably a second func is needed here


}
