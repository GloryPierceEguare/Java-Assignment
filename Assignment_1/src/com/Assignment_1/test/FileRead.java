/*******************************************
 * FileRead: the purpose of this class is to take in the file chosen
 * by the user in the FileGUI class and convert it into a string so
 * that it can be sent to the TextRead class to be analysed.
 * Author: Glory Pierce Eguare
 * OS: WIndows
 */

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
			br = new BufferedReader(new FileReader(selectedFile));
			sb = new StringBuilder();

		    line = br.readLine();
		    while (line != null) 
		    {
		    	sb.append(line).append("\n");
		    	line = br.readLine();
		    }

		    sentence = sb.toString();
		    
		    TextRead f1 = new TextRead();
		    f1.addSentence(sentence);
			
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("No file!!");
		}
	}
}
