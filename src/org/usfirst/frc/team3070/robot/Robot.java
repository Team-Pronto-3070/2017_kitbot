
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.CANTalon;

public class Robot extends IterativeRobot {
	//AnalogInput ultra;
	// AnalogGyro gyro;
	XboxController xbox;
	CANTalon talBR, talFR, talFL, talBL;
	public static final double DEAD_ZONE = .2;
	public static final double RAMP = .1;
	public static final int CURRENT_LIMIT = 30;
	public void robotInit() {
		xbox = new XboxController(0);
		// gyro = new AnalogGyro(0);
		//ultra = new  (0,0);
		talBR = new CANTalon(5);// 0
		talFR = new CANTalon(0);// 5
		talFL = new CANTalon(1);// 2
		talBL = new CANTalon(2);// 1
		SmartDashboard.putNumber("ultra", 1);
		talBR.setVoltageRampRate(RAMP);
		talFR.setVoltageRampRate(RAMP);
		talBL.setVoltageRampRate(RAMP);
		talFL.setVoltageRampRate(RAMP);
		
		talBR.setCurrentLimit(CURRENT_LIMIT);
		talFR.setCurrentLimit(CURRENT_LIMIT);
		talBL.setCurrentLimit(CURRENT_LIMIT);
		talFL.setCurrentLimit(CURRENT_LIMIT);

		talBR.set(0);
		talFR.set(0);
		talFL.set(0);
		talBL.set(0);

	}

	public void autonomousInit() {

	}

	public void autonomousPeriodic() {

	}

	public void teleopInit() {
		talBR.set(0);
		talFR.set(0);
		talFL.set(0);
		talBL.set(0);
	}

	public void teleopPeriodic() {
		
		//SmartDashboard.putNumber("ultra", ultra.getVoltage());
		if (Math.abs(xbox.getRawAxis(1)) > DEAD_ZONE) {
			talBL.set(xbox.getRawAxis(1));
			talFL.set(xbox.getRawAxis(1));
		} else {
			talBL.set(0);
			talFL.set(0);
		}

		if (Math.abs(xbox.getRawAxis(5)) > DEAD_ZONE) {
			talBR.set(-xbox.getRawAxis(5));
			talFR.set(-xbox.getRawAxis(5));
		} else {
			talFR.set(0);
			talBR.set(0);
		}
	}

	public void testPeriodic() {

	}

}
