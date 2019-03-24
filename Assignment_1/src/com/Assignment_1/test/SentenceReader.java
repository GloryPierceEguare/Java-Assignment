package com.Assignment_1.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SentenceReader 
{
	//Attributes
	int i = 0;
	File fileName;
	File fileName2;
	Scanner myScanner;
	Scanner myScanner2;

	public void addSentence(String sentence) 
	{
	    //GUI.Passer(sentence);
	    System.out.println(sentence);
	    
	    File fileName = new File("English.txt");
	    File fileName2 = new File("BadWords.txt");
	    
	    try 
	    {
	        Scanner myScanner = new Scanner(fileName);
	        Scanner myScanner2 = new Scanner(fileName2);

	        //now read the file line by line...
	        while (myScanner.hasNextLine() && myScanner2.hasNextLine()) 
	        {
	            String line = myScanner.nextLine();
	            String line2 = myScanner2.nextLine();
	 
	            if(line.equals(sentence) && line2.equals(sentence)) 
	            { 
	                System.out.println(sentence+": Is correct English.");
	                break;
	            }
	            else
	            {
	            	i++;
	            	//System.out.println(sentence+": Is not correct English.");
	            }
	        }
	        
	        myScanner.close();
	        myScanner2.close();
	    } 
	    catch(FileNotFoundException e) 
	    { 
	    	System.out.println("No file!!");
	    }
	    
	    
	}
	
	//Close the scanner
	public void ClosingTime()
	{
		myScanner.close();
	}	
}
