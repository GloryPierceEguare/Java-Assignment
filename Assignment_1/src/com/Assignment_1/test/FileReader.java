package com.Assignment_1.test;

//import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader 
{
	Scanner myScanner;
	
	public void addFile(File selectedFile) 
	{
		
		try
		{
			Scanner myScanner = new Scanner(selectedFile);
			String line = myScanner.nextLine();
			//now read the file line by line...
	        while (myScanner.hasNextLine()) 
	        {
	        	System.out.println(line);
	        }
	        myScanner.close();
		}
		catch(IOException e)
		{
			System.out.println("No file!!");
		}
        
        
		/*
		String line = null;
        try
        {
            //FileReader reads text files in the default encoding
            FileReader fileReader = new FileReader(selectedFile);
            
            //always wrap the FileReader in BufferedReader 
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            
             always close the file after use 
            bufferedReader.close();
        }
        catch(IOException e)
        {
            System.out.println("Error reading file named '" +selectedFile+ "'");
        }*/
	}


}
