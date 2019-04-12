/*******************************************
 * FileGUI: the purpose of this class is to display the file-reading GUI to the user.
 * In the FileGUI class the user can enter a file through the filechooser and send it off
 * for it to be analysed.
 * Author: Glory Pierce Eguare
 * OS: WIndows
 */

package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileGUI extends JFrame implements ActionListener
{
	//Attributes
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextArea area1;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private File selectedFile;
	private DecimalFormat twodec = new DecimalFormat("#.00");
	private DecimalFormat zerodec = new DecimalFormat("#");
	private static float a3[] = new float[5];
	private int check = 0;
	private String name;

	public FileGUI()
	{
		//Set layout to BorderLayout
		setLayout(new BorderLayout());
		
		//Create attributes
		button1 = new JButton("BACK");
		button2 = new JButton("Show Results");
		button3 = new JButton("Files");
		area1 = new JTextArea();
		
		//Set size of text area
		area1.setRows(10);
		area1.setColumns(40);
		
		//Create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		//Add panels
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		add(panel3, BorderLayout.CENTER);
		
		//panel1.add(chooser);
		panel1.add(button3);
		panel1.add(button2);
		panel2.add(button1);
		panel3.add(area1);

		//Set screen size
		setSize(900,600);
		
		//Makes the screen visible
		setVisible(true);
		
		//Set the location of the screen
		setLocation(100,100);
		
		//Link the listener to the button you want to monitor
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		//Show help message
		JOptionPane.showMessageDialog(this,"Instructions:\n1. Press 'File' to enter the file explorer.\n2. Choose the file that you want to analyse.\n3. Press 'Open' to select that file.\n4. Press 'Show Results' to display your results.");
	}

	//Action listeners 
	public void actionPerformed(ActionEvent event) 
	{
		//Button to return to the home GUI class
		if(event.getSource() == button1)
		{
			this.dispose();
			GUI gui = new GUI();
			gui.setVisible(true);
		}
		
		//Button to display results and error checking
		if(event.getSource() == button2)
		{
			if(check == 0)
			{
				JOptionPane.showMessageDialog(this,"You have not entered a file yet!!!");
			}
			else
			{
				area1.setText(null);
				area1.append("Selected file: "+name);
				area1.append("\n\nThis file is: "+twodec.format(a3[0])+"% formal language.\nThis file is: "+twodec.format(a3[1])+"% informal language.");
				area1.append("\n\nSpelling Errors: "+zerodec.format(a3[2])+"\nPunctuation Errors: "+zerodec.format(a3[3])+"\nSentence Structure Errors: "+zerodec.format(a3[4]));
			}
		}
		
		//Button to choose file and error checking
		if(event.getSource() == button3)
		{
			chooser = new JFileChooser();
			filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
			chooser.setFileFilter(filter);
			
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	name = chooser.getSelectedFile().getName();
		    	
		    	if(name.endsWith(".txt"))
		    	{
		    		check = 1;
		    		selectedFile = chooser.getSelectedFile();
			    	Passer2(selectedFile);
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(this,"This not a text file!");
		    	}
		    }
		}
	}
	
	//Method: to pass the selected file to the FileRead class
	public static void Passer2(File selectedFile)
	{
		FileRead f1 = new FileRead();
		f1.addFile(selectedFile);
	}
	
	//Method: to take in the analysed results from the TextRead class
	public static void results(float[] a2)
	{
	    for(int i=0;i<a2.length;++i)
	    {
			a3[i]=a2[i];
		}
	}
}
