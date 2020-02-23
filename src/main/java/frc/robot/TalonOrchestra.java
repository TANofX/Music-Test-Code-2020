/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.nio.file.spi.FileTypeDetector;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TalonOrchestra extends SubsystemBase {

TalonFX talonSoprano;
TalonFX talonAlto;
Orchestra talonOrchestra;
public String song;

public TalonOrchestra() {

    talonSoprano = new TalonFX(1);
    talonAlto = new TalonFX(2);
    talonOrchestra = new Orchestra();
    
    talonOrchestra.addInstrument(talonSoprano);
    talonOrchestra.addInstrument(talonAlto);


    restartSong();
}
public boolean playMusic(String song) {

  
  talonOrchestra.loadMusic(song);
  talonOrchestra.play();

  return talonOrchestra.isPlaying();
}

public void restartSong() {

  talonOrchestra.stop();

}

  @Override
  public void periodic() {

    if(talonOrchestra.isPlaying() == false) {
      playMusic(song);
    }
    else {

    }
    
    String tempSong = SmartDashboard.getString("Current Set Song", "Chrono_Trigger.chrp");
    
    if(tempSong != song) {
      restartSong();
      song = tempSong;
      playMusic(song);
    }
    

  }
}
