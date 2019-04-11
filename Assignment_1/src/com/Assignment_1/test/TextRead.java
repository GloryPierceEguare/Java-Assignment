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
	int spell, punct, leng = 0;
	int i, j, y = 0;
	int high;
	float wordcount = 0;
	float formal, slang = 0;
	float total = 0;
	float formalp, slangp = 0;
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
	    	
	    	if(a1.length > 20 /*&& reMatcher.group().indexOf(",")!=-1*/) //indexOf(",")!=-1)
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
	    	
	        System.out.println(reMatcher.group());
	        
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
	         	//System.out.println("First letter in word "+ text + " is upper case");
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
	    
	    //Check if there is random capital letters in the middle of a word
	    for(j = 0;j < a1.length;j++)
	    {
	    	high = 0;
	    	
	    	for(y = 1;y < a1[j].length();y++)
	    	{
	    		char ch = a1[j].charAt(y);
	    		
	    		if(Character.isUpperCase(ch))
	    		{
	    			high += 1;
	    			System.out.println("High letter!");
	    		}
	    	}
	    	
	    	wordcount += 1;
	    	
	    	if(high == 0)
	    	{
	    		formal += 1;
	    	}
	    }
	    
	    try 
	    {   
	    	setFileName(new File("English.txt"));
		    
		    setMyScanner(new Scanner(getFileName()));
	    	
	    	// For each word in the input
	    	while (getMyScanner().hasNext()) 
	    	{
	    	    getDict().add(getMyScanner().next());
	    	}
	        
	    	 getMyScanner().close();
	    } 
	    catch(FileNotFoundException e) 
	    { 
	    	System.out.println("Dictionary file is not found!!");
	    }
	    
        for(i=0; i<a1.length;i++)
	    {
        	a1[i] = a1[i].replaceAll("[^a-zA-Z0-9]","").toLowerCase(); //https://stackoverflow.com/questions/22367028/given-a-txt-file-i-need-to-lower-case-and-remove-punctuation
        	System.out.println(a1[i]);
        	System.out.println("yep");
        	wordcount += 1;
        	
        	if (getDict().contains(a1[i])) 
        	{
        		System.out.println("1");
            	formal +=1;
        	}
        	else
        	{
        		spell += 1;
        	}
	    }
	    
	    //slang = a1.length - formal;
	    slang = wordcount - formal;
	    
	    //total = formal + slang;
	    System.out.println(wordcount);
	    
	    formalp = (100 * formal)/wordcount;
	    slangp = (100 * slang)/wordcount;
	    
	    System.out.println("This string is: "+formalp+"% formal language.");
	    System.out.println("This string is: "+slangp+"% informal language.");
	    
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

	//Getter & Setter: Dict
	public Set<String> getDict() 
	{
		return dict;
	}
	public void setDict(Set<String> dict) 
	{
		this.dict = dict;
	}

	//Getter & Setter: MyScanner
	public Scanner getMyScanner()
	{
		return myScanner;
	}
	public void setMyScanner(Scanner myScanner) 
	{
		this.myScanner = myScanner;
	}

	//Getter & Setter: FileName
	public File getFileName() 
	{
		return fileName;
	}
	public void setFileName(File fileName) 
	{
		this.fileName = fileName;
	}
}
