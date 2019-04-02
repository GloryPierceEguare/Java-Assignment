package com.Assignment_1.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceReader 
{
	//Attributes
	int i = 0;
	int wordcount = 0;
	int formal = 0;
	int slang = 0;
	float total = 0;
	float formalp = 0;
	float slangp = 0;
	File fileName;
	File fileName2;
	Scanner myScanner;
	//Scanner myScanner2;

	public void addSentence(String sentence) 
	{
	    //GUI.Passer(sentence);
		//String sentence2 = sentence.toLowerCase(); 
	    System.out.println(sentence);
	    
	    //https://stackoverflow.com/questions/21430447/how-to-split-paragraphs-into-sentences
	    Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
	    Matcher reMatcher = re.matcher(sentence);
	    while (reMatcher.find()) 
	    {
	    	String[] a1 = reMatcher.group().split(" ");
	    	
	    	if(a1.length > 27 && reMatcher.group().indexOf(",")!=-1)
	    	{
	    		wordcount += 1;
	    		formal += 1;
	    	}
	    	
	        System.out.println(reMatcher.group());
	        
	        wordcount += 1;
	        
	        //https://stackoverflow.com/questions/4452939/in-java-how-to-find-if-first-character-in-a-string-is-upper-case-without-regex
	        if (reMatcher.group().charAt(0) == (reMatcher.group().toUpperCase().charAt(0)))
		    {
	        	formal +=1;
	         	//System.out.println("First letter in word "+ text + " is upper case");
		    }
	    }
	    
	    
	    
	    String[] a1 = sentence.split(" ");    
	    
	    File fileName = new File("English.txt");
	    //File fileName2 = new File("BadWords.txt");
	    
	    try 
	    {   
	        //for(String sent : a1) 
	        for(i=0; i<a1.length;i++)
		    {
	        	Scanner myScanner = new Scanner(fileName);
		        //System.out.println(sent);
	        	a1[i] = a1[i].replaceAll("[^a-zA-Z0-9]","").toLowerCase(); //https://stackoverflow.com/questions/22367028/given-a-txt-file-i-need-to-lower-case-and-remove-punctuation
	        	System.out.println(a1[i]);
	        	System.out.println("yep");
	        	wordcount += 1;
	   		 
		        
		        //now read the file line by line...
		        while (myScanner.hasNextLine()) 
		        {
		            String line = myScanner.nextLine();
		          
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
	    } 
	    catch(FileNotFoundException e) 
	    { 
	    	System.out.println("No file!!");
	    }
	    
	    //slang = a1.length - formal;
	    slang = wordcount - formal;
	    
	    //total = formal + slang;
	    System.out.println(wordcount);
	    
	    formalp = (100 * formal)/wordcount;
	    slangp = (100 * slang)/wordcount;
	    
	    System.out.println("This string is: "+formalp+"% formal language.");
	    System.out.println("This string is: "+slangp+"% informal language.");
	    
	}
	
	//Close the scanner
	public void ClosingTime()
	{
		myScanner.close();
	}	
}
