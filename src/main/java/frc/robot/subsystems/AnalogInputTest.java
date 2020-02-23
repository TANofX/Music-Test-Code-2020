/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AnalogInputTest extends SubsystemBase {

  AnalogInput Jerome;

  public AnalogInputTest() {

    Jerome = new AnalogInput(0);

  }

  public boolean testJerome() {

    return (Jerome.getVoltage() >= 0.3); 

  }

  @Override
  public void periodic() {

SmartDashboard.putNumber("Jerome Value", Jerome.getVoltage());
SmartDashboard.putBoolean("Jerome Boolean", testJerome());

  }
}
