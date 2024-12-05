// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.XRPDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final XRPDrivetrain m_subsystem;
  private Object resetEncoders;
//
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(XRPDrivetrain subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.resetEncoders(); 
  }//setting it up


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    m_subsystem.arcadeDrive(1.0, 0);
  } // repeatly running the code
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.arcadeDrive(0, 0);

  } // puts a end/stops the code

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { //gets called everytime the excute its called
    if(m_subsystem.getRightDistanceInch()>=196.850394)
    {
      return true;
    }

    return false;
  }
}
