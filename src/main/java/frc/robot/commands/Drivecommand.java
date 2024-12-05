package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.XRPDrivetrain;

public class Drivecommand extends Command{
    private final XRPDrivetrain drive;
    private final DoubleSupplier LeftSpeed;
    private final DoubleSupplier RightSpeed;
    public Drivecommand(XRPDrivetrain drive, DoubleSupplier Left, DoubleSupplier Right){
            this.drive = drive;
            this.LeftSpeed = Left;
            this.RightSpeed = Right;
            addRequirements(drive);
    }




@Override
public void initialize(){

}
@Override
public void execute(){
   
    
    drive.tankDrive(LeftSpeed.getAsDouble(),RightSpeed.getAsDouble());


}
@Override
public void end(boolean l){
    drive.tankDrive(0.0, 0.0);

}
@Override
public boolean isFinished(){
    return false;

}
}