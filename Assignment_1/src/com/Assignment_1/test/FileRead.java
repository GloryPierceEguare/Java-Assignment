package com.Assignment_1.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead 
{
	//Attributes
	private BufferedReader br;
	private StringBuilder sb;
	private String sentence;
	private String line;
	
	public void addFile(File selectedFile) 
	{
		//Write contents of a text file into a string
		try
		{
			setBr(new BufferedReader(new FileReader(selectedFile)));
		    setSb(new StringBuilder());

		    setLine(getBr().readLine());
		    while (getLine() != null) 
		    {
		    	getSb().append(getLine()).append("\n");
		    	setLine(getBr().readLine());
		    }

		    setSentence(getSb().toString());
		    
		    TextRead f1 = new TextRead();
			f1.addSentence(getSentence());
			
			getBr().close();
		}
		catch(IOException e)
		{
			System.out.println("No file!!");
		}
	}

	//Getter & Setter: Sentence
	public String getSentence() 
	{
		return sentence;
	}
	public void setSentence(String sentence) 
	{
		this.sentence = sentence;
	}

	//Getter & Setter: BufferedReader br
	public BufferedReader getBr() 
	{
		return br;
	}
	public void setBr(BufferedReader br) 
	{
		this.br = br;
	}

	//Getter & Setter: StringBuilder sb
	public StringBuilder getSb() 
	{
		return sb;
	}
	public void setSb(StringBuilder sb) 
	{
		this.sb = sb;
	}

	//Getter & Setter: Line
	public String getLine() 
	{
		return line;
	}
	public void setLine(String line) 
	{
		this.line = line;
	}
}
