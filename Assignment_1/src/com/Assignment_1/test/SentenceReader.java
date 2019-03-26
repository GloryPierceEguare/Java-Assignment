package com.Assignment_1.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SentenceReader 
{
	//Attributes
	int i = 0;
	int formal = 0;
	int slang = 0;
	int total = 0;
	float formalp = 0;
	float slangp = 0;
	File fileName;
	File fileName2;
	Scanner myScanner;
	//Scanner myScanner2;

	public void addSentence(String sentence) 
	{
	    //GUI.Passer(sentence);
		String sentence2 = sentence.toLowerCase(); 
	    System.out.println(sentence2);
	    String[] a1 = sentence2.split(" ");    
	    
	    File fileName = new File("English.txt");
	    //File fileName2 = new File("BadWords.txt");
	    
	    try 
	    {
	        //Scanner myScanner = new Scanner(fileName);
	        //Scanner myScanner2 = new Scanner(fileName2);
	        
	        //for(String sent : a1) 
	        for(i=0; i<a1.length;i++)
		    {
	        	Scanner myScanner = new Scanner(fileName);
		        //System.out.println(sent);
	        	System.out.println(a1[i]);
	        	System.out.println("yep");
		        
		        //now read the file line by line...
		        while (myScanner.hasNextLine()) 
		        {
		            String line = myScanner.nextLine();
		            //String line2 = myScanner2.nextLine();
		 
		            //if(line.equals(sent)) 
		            if(a1[i].equals(line))//(line.equals(a1[i]))
		            { 
		            	System.out.println("1");
		            	formal +=1;
		                //System.out.println(sent+": Is correct English.");
		                //break;
		            }
		        }
		        myScanner.close();
		    }     
	        
	        //myScanner.close();
	        //myScanner2.close();
	    } 
	    catch(FileNotFoundException e) 
	    { 
	    	System.out.println("No file!!");
	    }
	    
	    slang = a1.length - formal;
	    
	    total = formal + slang;
	    System.out.println(total);
	    
	    formalp = (100 * formal)/total;
	    slangp = (100 * slang)/total;
	    
	    System.out.println("This string is: "+formalp+"% formal language.");
	    System.out.println("This string is: "+slangp+"% informal language.");
	}
	
	//Close the scanner
	public void ClosingTime()
	{
		myScanner.close();
	}	
}
