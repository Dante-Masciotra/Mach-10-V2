// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ControlExtend extends CommandBase {
  /** Creates a new ControlExtend. */
  public ControlExtend() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.extend);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = RobotContainer.getRightX(RobotContainer.OpController);
    if(RobotContainer.extend.get_extend_encoder() <= -114.0 && speed<0.0){
      speed = 0.0;
    }else if(RobotContainer.extend.get_extend_encoder() >= -4.0 && speed>0.0){
      speed = 0.0;
    }
    RobotContainer.extend.extend(speed*0.6);

  // System.out.println(RobotContainer.extend.get_extend_encoder());
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
