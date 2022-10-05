// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// joystick place
package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Climb;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.climbCommands.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.shooterCommands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static final class Button {
    // actually get the correct button
    // we'll see if this naming system flies with Satvik
    private static final int xKey = 1;
    private static final int aKey = 2;
    private static final int bKey = 3;
    private static final int yKey = 4;
    private static final int ltKey = 7;
    private static final int rtKey = 8;
    
  }


  private final int joystickPort = 0; // joystick usb port on the driver station


  public Joystick m_joystick = new Joystick(joystickPort);

  // button x
  private JoystickButton m_UpButton = new JoystickButton(m_joystick, Button.xKey);
  // button a
  private JoystickButton m_DownButton = new JoystickButton(m_joystick, Button.aKey);

  private JoystickButton m_ShootButton = new JoystickButton(m_joystick, Button.ltKey);

  private JoystickButton m_ClimbUpButton = new JoystickButton(m_joystick, Button.bKey);
  private JoystickButton m_ClimbDownButton = new JoystickButton(m_joystick, Button.yKey);


  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Shooter m_shooter = new Shooter();
  private final Climb m_climb = new Climb();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings  

    // do stuff with the drivetrain
    configureButtonBindings();

    m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain, m_joystick));
    // if the robot isnt doing anything:
    //     arcadeDrive(); 

    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  
  private void configureButtonBindings() {
    // make a button then call a command when pressed

    // figure out how to make the button call thing work >:(
    m_UpButton.whenPressed(new MoveUp(m_shooter));
    m_DownButton.whenPressed(new MoveDown(m_shooter));
    m_ShootButton.whenPressed(new InstantCommand(m_shooter::switchUp, m_shooter));
    // what this does is when the button pressed it makes a new command based on the switch up thing


    // new InstantCommand(m_hatchSubsystem::grabHatch, m_hatchSubsystem)
    m_ClimbUpButton.whenPressed(new InstantCommand(m_climb::setUp, m_climb));
    m_ClimbDownButton.whenPressed(new InstantCommand(m_climb::setDown, m_climb));

    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public void getTeleopCommand() {
    return;
  }
}
