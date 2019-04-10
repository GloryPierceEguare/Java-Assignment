package com.Assignment_1.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead 
{
	BufferedReader br;
	StringBuilder sb;
	String sentence;
	Scanner myScanner;
	
	public void addFile(File selectedFile) 
	{
		try
		{
			br = new BufferedReader(new FileReader(selectedFile));
		    sb = new StringBuilder();

		    String line = br.readLine();
		    while (line != null) 
		    {
		      sb.append(line).append("\n");
		      line = br.readLine();
		    }

		    sentence = sb.toString();
		    
		    SentenceRead f1 = new SentenceRead();
			f1.addSentence(sentence);
			
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("No file!!");
		}
	}
}
