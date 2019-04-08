package com.Assignment_1.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead 
{
	Scanner myScanner;
	
	public void addFile(File selectedFile) 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(selectedFile));
		    StringBuilder sb = new StringBuilder();

		    String line = br.readLine();
		    while (line != null) 
		    {
		      sb.append(line).append("\n");
		      line = br.readLine();
		    }

		    String sentence = sb.toString();
		    
		    SentenceReader f1 = new SentenceReader();
			f1.addSentence(sentence);
			
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("No file!!");
		}
	}
}
