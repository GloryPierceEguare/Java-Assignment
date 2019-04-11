/*******************************************
 * TextRead: the purpose of this class is to take in the user input
 * from the TextGUI or FileRead classes and analyse them to check how 
 * much of them is formal and informal language. 
 * Author: Glory Pierce Eguare
 * OS: WIndows
 */

package com.Assignment_1.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRead 
{
	//Attributes
	private int spell, punct, leng = 0;
	private int i, y = 0;
	private int high;
	private float wordcount = 0;
	private float formal, slang = 0;
	private float formalp, slangp = 0;
	private File fileName;
	private Scanner myScanner;
	private Set<String> dict = new HashSet<>();

	public void addSentence(String sentence) 
	{ 
	    //https://stackoverflow.com/questions/21430447/how-to-split-paragraphs-into-sentences
	    Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
	    Matcher reMatcher = re.matcher(sentence);
	    while (reMatcher.find()) 
	    {
	    	String[] a1 = reMatcher.group().split(" ");
	    	
	    	if(a1.length > 20)
	    	{
	    		if(reMatcher.group().indexOf(",")!=-1 || reMatcher.group().indexOf(";")!=-1)
	    		{
	    			wordcount += 1;
		    		formal += 1;
	    		}
	    		else
	    		{
	    			wordcount += 1;
	    			leng += 1;
	    		}	
	    	}
	        
	        //Check for more than one fullstop, exclamation mark or space
	        if(reMatcher.group().indexOf("..")!=-1 || reMatcher.group().indexOf("!!")!=-1 || reMatcher.group().indexOf("  ")!=-1)
	        {
	        	wordcount += 1;
	        	punct += 1;
	        }
	        
	        wordcount += 1;
	        
	        //https://stackoverflow.com/questions/4452939/in-java-how-to-find-if-first-character-in-a-string-is-upper-case-without-regex
	        if (reMatcher.group().charAt(0) == (reMatcher.group().toUpperCase().charAt(0)))
		    {
	        	formal +=1;
		    }
	        else
	        {
	        	punct += 1;
	        }
	        
	        wordcount += 1;
	        
	        if(reMatcher.group().endsWith(".")||reMatcher.group().endsWith("!")||reMatcher.group().endsWith("?")) //punct = regex
	        {
	    		formal += 1;
	    	}
	        else
	        {
	        	punct += 1;
	        }
	    } 
	    
	    String[] a1 = sentence.split(" ");    
	    
	    try 
	    {   
	    	fileName = new File("English.txt");
		    
		    myScanner = new Scanner(fileName);
	    	
	    	// For each word in the input
	    	while (myScanner.hasNext()) 
	    	{
	    	    dict.add(myScanner.next());
	    	}
	        
	    	 myScanner.close();
	    } 
	    catch(FileNotFoundException e) 
	    { 
	    	System.out.println("Dictionary file is not found!!");
	    }
	    
        for(i=0; i<a1.length;i++)
	    {
        	a1[i] = a1[i].replaceAll("[^a-zA-Z0-9]","").toLowerCase(); //https://stackoverflow.com/questions/22367028/given-a-txt-file-i-need-to-lower-case-and-remove-punctuation
        	
        	wordcount += 1;
        	
        	if (dict.contains(a1[i])) 
        	{
            	formal +=1;
            	
            	//Check if there is random capital letters in the middle of a word
    	    	high = 0;
    	    	
    	    	for(y = 1;y < a1[i].length();y++)
    	    	{
    	    		char ch = a1[i].charAt(y);
    	    		
    	    		if(Character.isUpperCase(ch))
    	    		{
    	    			high += 1;
    	    		}
    	    	}
    	    	
    	    	wordcount += 1;
    	    	
    	    	if(high == 0)
    	    	{
    	    		formal += 1;
    	    	}
    	    	else
    	    	{
    	    		punct += 1;
    	    	}  
        	}
        	else
        	{
        		spell += 1;
        	}
	    }
	    
	    slang = wordcount - formal;
	    
	    formalp = (100 * formal)/wordcount;
	    slangp = (100 * slang)/wordcount;
	    
	    result();
	}
	
	public void result()
	{
		float a2[] = new float[5];
        a2[0] = formalp;
        a2[1] =  slangp;
        a2[2] =  spell;
        a2[3] =  punct;
        a2[4] =  leng;
		
        TextGUI.results(a2);
        FileGUI.results(a2);
	}
}
