// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.XRPDrivetrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Follow_line extends Command {
  private XRPReflectanceSensor linesensor = new XRPReflectanceSensor(); 
  private XRPDrivetrain m_Drivetrain;
  
  }
  /** Creates a new Follow_line. */
  public Follow_line(XRPDrivetrain drivetrain){
    // Use addRequirements() here to declare subsystem dependencies.
    
      m_Drivetrain = drivetrain;
      addRequirements(drivetrain);
    SmartDashboard.putData(this);
  }

  
  @Override
  public void initSendable(SendableBuilder builder){
    super.initSendable(builder); //send data to driver station.
                                   //down:is string         get the double value       doesn't have a value
    builder.addDoubleProperty("Left Line Sensor",linesensor::getLeftReflectanceValue, null);
    builder.addDoubleProperty("Right Line Sensor",linesensor::getRightReflectanceValue, null);

  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
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
    return false;
  }
}
