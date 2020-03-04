/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import frc.robot.subsystems.ColorWheelSub;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ColorWheelRotationalControl extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ColorWheelSub m_colorcode;
  private boolean finished= false;
  private boolean othercolor =false;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ColorWheelRotationalControl(ColorWheelSub colorcode) {
    m_colorcode = colorcode;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorcode);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_colorcode.postvalues();
    String scancolor;
    int scancolorcount =0;
    m_colorcode.postvalues();
    if(m_colorcode.isBlue()){//Blue
      //finds if the color being sensed is blue
      scancolor = "Blue";
            }
    else if(m_colorcode.isGreen()){//Green
     //finds if the color being sensed is green
     scancolor = "Green";
                }
    else if(m_colorcode.isRed()){//Red
     //finds out if the color being sensed red
     scancolor = "Red";
                } 
    else if(m_colorcode.isYellow()){//Yellow
     //finds out if the color being sensed yellow
     scancolor = "Yellow";
                }
    else{
     //finds out if the color being sensed null
     scancolor = "null";
                }
   if(!scancolor.equals("null")){//ensures that the code only runs if a color is scanned
    
   while(scancolorcount<7){
    m_colorcode.ColorWheelmotoron();
    if(scancolor.equals("Blue")){//checks if the first color scanned is Blue
      while(scancolorcount<7){
       if(m_colorcode.isBlue()){
           while(othercolor){
             if(!m_colorcode.isBlue()){
             othercolor = true;
           }
          }
          if(othercolor == true && m_colorcode.isBlue()){
       scancolorcount++;//increases the count when the color being scanned is Blue
                  }
                }
              }
            }
    else if(scancolor.equals("Green")){//checks if the first color scanned is Green
      if(m_colorcode.isGreen()){
        while(scancolorcount<7){
          if(m_colorcode.isGreen()){
              while(othercolor){
                if(!m_colorcode.isGreen()){
                othercolor = true;
              }
             }
             if(othercolor == true && m_colorcode.isGreen()){
          scancolorcount++;//increases the count when the color being scanned is Green
                     }
                   }
                 }
         
                }
            }
    else if(scancolor.equals("Red")){//checks if the first color scanned is Red
     if(m_colorcode.isRed()){
      while(scancolorcount<7){
        if(m_colorcode.isRed()){
            while(othercolor){
              if(!m_colorcode.isRed()){
              othercolor = true;
            }
           }
           if(othercolor == true && m_colorcode.isRed()){
                    scancolorcount++;//increases the count when the color being scanned is Red
                   }
                 }
               } 
            }
          }
   else if(scancolor.equals("Yellow")){ //checks if the first color scanned is Yellow
     if(m_colorcode.isYellow()){
      while(scancolorcount<7){
        if(m_colorcode.isYellow()){
            while(othercolor){
              if(!m_colorcode.isYellow()){
              othercolor = true;
            }
           }
           if(othercolor == true && m_colorcode.isYellow()){
                      scancolorcount++;//increases the count when the color being scanned is Yellow
                      othercolor =false;
                   }
                 }
               } 
                }  
            }  
        }
        finished =true;
        end(finished);
        scancolor = "null";
    }
}


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_colorcode.ColorWheelmotoroff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
//Made by Wynter Japp