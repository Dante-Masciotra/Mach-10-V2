// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pneumatics extends SubsystemBase {
  /** Creates a new pneumatics. */
  Compressor pcmcompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  boolean pressureSwitch;
  public pneumatics() {}

  @Override
  public void periodic() {
    pressureSwitch = pcmcompressor.getPressureSwitchValue();
    if (pressureSwitch) {
      pcmcompressor.disable();
    }
    else {
      pcmcompressor.enableDigital();
    }
    // This method will be called once per scheduler run
  }
}
