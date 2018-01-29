package com.bhavik.validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/**
 * Maven project for Validating files.
 *
 */
public class FileCompatabilityApp 
{
	public static void main( String[] args )
    {
        getFileInfo();
    }
    
    /*
     * Inputs requested file and returns number of bytes and number of rows
     */
    public static void getFileInfo() {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Enter the complete file path: ");
    	String fileName = scan.nextLine();
    	File file = new File(fileName);
    	long size = FileUtils.sizeOf(file);
    	long rowCount = 0L;
    	try {
			rowCount = Files.lines(Paths.get(fileName)).count();
		} catch (IOException e1) {
			e1.printStackTrace();
		}    	
    	System.out.println("Number of bytes = " + size);
    	System.out.println("Number of rows = " + rowCount);
    	scan.close();
    }
}