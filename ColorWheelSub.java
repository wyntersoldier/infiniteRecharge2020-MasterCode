/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ColorSensorV3;

public class ColorWheelSub extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  final I2C.Port i2cPort = I2C.Port.kOnboard; 
  final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final CANSparkMax colorwheelspinner1 = new CANSparkMax(Constants.colormotorID, MotorType.kBrushless); // with NEO 550
  
  
  public void postvalues() {
    SmartDashboard.putString("DB/String 0", "Blue Values");
    SmartDashboard.putString("DB/String 5", "" + m_colorSensor.getBlue());    
		SmartDashboard.putString("DB/String 1", "Green Values");
		SmartDashboard.putString("DB/String 6", "" + m_colorSensor.getGreen());
		SmartDashboard.putString("DB/String 2", "Red Values");
    SmartDashboard.putString("DB/String 7", ""+ m_colorSensor.getRed());
    SmartDashboard.putString("DB/String 3", "Color Scanning");
    if(isBlue()==true){
      SmartDashboard.putString("DB/String 8", "Blue");
    }
    else if(isGreen()==true){
      SmartDashboard.putString("DB/String 8", "Green");
    }
    else if(isRed()==true){
      SmartDashboard.putString("DB/String 8", "Red");
    }
    else if(isYellow()==true){
      SmartDashboard.putString("DB/String 8", "Yellow");
    }
    else{
      SmartDashboard.putString("DB/String 8", "Null");
    }
  }
public boolean isBlue(){
  if(((m_colorSensor.getGreen()<=((m_colorSensor.getRed()*3)+200))&&(m_colorSensor.getGreen()>=((m_colorSensor.getRed()*3)-200)))&& ((m_colorSensor.getBlue()<=((m_colorSensor.getRed()*3)+200))&&(m_colorSensor.getBlue()>=(((m_colorSensor.getRed()*3)-200))))){
    return true;
  }
  else{
    return false;
  }
}
public boolean isGreen(){
  if(((m_colorSensor.getGreen()<=((m_colorSensor.getBlue()*2)+100))&&(m_colorSensor.getGreen()>=((m_colorSensor.getBlue()*2)-100)))&& ((m_colorSensor.getRed()<=((m_colorSensor.getBlue())+100))&&(m_colorSensor.getRed()>=(((m_colorSensor.getBlue())-100))))){
    return true;
  }
  else{
    return false;
  }
  }
public boolean isRed(){
  if(((m_colorSensor.getGreen()<=((m_colorSensor.getBlue()*2)+200))&&(m_colorSensor.getGreen()>=((m_colorSensor.getBlue()*2)-200)))&& ((m_colorSensor.getRed()<=((m_colorSensor.getBlue()*3)+200))&&(m_colorSensor.getRed()>=(((m_colorSensor.getBlue()*3)-200))))){
    return true;
  }
  else{
    return false;
  }
}
public boolean isYellow(){
  if(((m_colorSensor.getGreen()<=((m_colorSensor.getBlue()*3.5)+200))&&(m_colorSensor.getGreen()>=((m_colorSensor.getBlue()*3.5)-200)))&& ((m_colorSensor.getRed()<=((m_colorSensor.getBlue()*2)+100))&&(m_colorSensor.getRed()>=(((m_colorSensor.getBlue()*2)-100))))){
    return true;
  }
  else{
    return false;
  }
}
public void ColorWheelmotoron(){
  colorwheelspinner1.set(1);
}
public void ColorWheelmotoroff(){
  colorwheelspinner1.set(0);
 }
 public void ColorWheelmotorclose(){
  colorwheelspinner1.close();
 }
}






