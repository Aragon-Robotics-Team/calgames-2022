// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  /** Creates a new Climb. */
  
  // channel 5 single solenoid is used for climb
  // don't ask what this module type is
  private Solenoid m_solenoid = new Solenoid(1, PneumaticsModuleType.CTREPCM, 5);

  public Climb() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  // this method is not needed
  public void setState(boolean bool) {
    m_solenoid.set(bool);
  }

  
  public void setUp() {
    m_solenoid.set(true);
  }

  public void setDown() {
    m_solenoid.set(false);
  }

}
