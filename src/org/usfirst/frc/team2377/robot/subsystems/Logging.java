package org.usfirst.frc.team2377.robot.subsystems;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
//import static org.junit.Assert.assertEquals;
//import org.junit.jupiter.api.Test;
//da weh
public class Logging {
	
	String defaultRobotDirectory = "/U/log/";
	FileWriter fileFritter;
	BufferedWriter writer;
	boolean fileOpen = false;

	public int init(String logName, int matchNumber, String fileLocation) {
		if (fileOpen)
			System.out.println("File already open.");
		
		System.out.println("Creating log file.");
		String fullFileName = fileLocation + logName + "_" + matchNumber + ".log";
		try {
			fileFritter = new FileWriter(fullFileName);
			writer = new BufferedWriter(fileFritter);
		} catch (IOException e) {
			fileOpen = false;
			System.out.println("Failed to create the log.");
			return -1;
		}
		fileOpen = true;
		return 0;
	}
	
	public int init(String logName, int matchNumber) {
		if (fileOpen)
			System.out.println("File already open.");
		
		System.out.println("Creating log file.");
		String fullFileName = defaultRobotDirectory + logName + "_" + matchNumber + ".log";
		try {
			fileFritter = new FileWriter(fullFileName);
			writer = new BufferedWriter(fileFritter);
		} catch (IOException e) {
			fileOpen = false;
			System.out.println("Failed to create the log.");
			return -1;
		}
		fileOpen = true;
		return 0;
	}
	
	public int init(String logName) {
		if (fileOpen)
			System.out.println("File already open.");
		
		System.out.println("Creating log file.");
		String fullFileName = defaultRobotDirectory + logName + "_" + LocalDateTime.now() + ".log";
		try {
			fileFritter = new FileWriter(fullFileName);
			writer = new BufferedWriter(fileFritter);
		} catch (IOException e) {
			fileOpen = false;
			System.out.println("Failed to create the log.");
			return -1;
		}
		fileOpen = true;
		return 0;
	}
	
	public int close() {
		if (fileOpen) {
			System.out.println("Closing file.");
			try {
				writer.close();
				fileFritter.close();
				return 0;
			} catch (IOException e) {
				System.out.println("Failed to close file.");
				return -1;
			}
		} else {
			System.out.println("File is not open.");
			return 0;
		}
	}
	
	public int error(String message, LocalDateTime timestamp) {
		if (fileOpen) {
			System.out.println("Writing error log.");
			try {
				writer.write(timestamp + "\t" + "ERROR" + "\t" + message + "\n");
				writer.flush();
				return 0;
			} catch (IOException e) {
				System.out.println("Failed to write to file");
				return -1;
			}
		}
		return 0;
	}
	
	public int info(String message, LocalDateTime timestamp) {
		if (fileOpen) {
			System.out.println("Writing info log.");
			try {
				writer.write(timestamp + "\t" + "INFO" + "\t" + message + "\n");
				return 0;
			} catch (IOException e) {
				System.out.println("Failed to write to file");
				return -1;
			}
		}
		return 0;
	}
	
	public int data(String message, LocalDateTime timestamp) {
		if (fileOpen) {
			System.out.println("Writing data log.");
			try {
				writer.write(timestamp + "\t" + "DATA" + "\t" + message + "\n");
				return 0;
			} catch (IOException e) {
				System.out.println("Failed to write to file");
				return -1;
			}
		}
		return 0;
	}
}
