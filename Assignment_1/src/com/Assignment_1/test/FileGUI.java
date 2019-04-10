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
	FileNameExtensionFilter filter;
	File selectedFile;
	DecimalFormat twodec = new DecimalFormat("#.00");
	DecimalFormat zerodec = new DecimalFormat("#");
	static float a3[] = new float[5];
	int check = 0;

	public FileGUI()
	{
		//super();
		setLayout(new BorderLayout());
		
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

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			this.dispose();
			GUI gui = new GUI();
			gui.setVisible(true);
		}
		
		if(event.getSource() == button2)
		{
			if(check == 0)
			{
				JOptionPane.showMessageDialog(this,"You have not entered a file yet!!!");
			}
			else
			{
				System.out.println("string is: "+a3[0]+"% formal language.");//Delete before submit
			    System.out.println("string is: "+a3[1]+"% informal language.");//Delete before submit
				area1.setText(null);
				area1.append("This file is: "+twodec.format(a3[0])+"% formal language.\nThis file is: "+twodec.format(a3[1])+"% informal language.");
				area1.append("\nSpelling Errors: "+zerodec.format(a3[2])+"\nPunctuation Errors: "+zerodec.format(a3[3])+"\nSentence Structure Errors: "+zerodec.format(a3[4]));
			}
		}
		
		if(event.getSource() == button3)
		{
			chooser = new JFileChooser();
			filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
			chooser.setFileFilter(filter);
			
		    int returnVal = chooser.showOpenDialog(this);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	String name = chooser.getSelectedFile().getName();
		    	System.out.println(name);
		    	
		    	if(name.endsWith(".txt"))
		    	{
		    		check = 1;
		    		File selectedFile = chooser.getSelectedFile();
			    	//System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
			    	System.out.println("Selected file: " + chooser.getSelectedFile().getAbsolutePath());//Delete before submit
			    	Passer2(selectedFile);
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(this,"This not a text file!");
		    	}
		    }
		}
	}
	
	public static void Passer2(File selectedFile)
	{
		FileRead f1 = new FileRead();
		f1.addFile(selectedFile);
	}
	
	public static void results(float[] a2)
	{
		System.out.println("This string is: "+a2[0]+"% formal language.");//Delete before submit
	    System.out.println("This string is: "+a2[1]+"% informal language.");//Delete before submit
	    System.out.println("--------------------------------");//Delete before submit
	    
	    
	    for(int i=0;i<a2.length;++i)
	    {
			a3[i]=a2[i];
		}
	    System.out.println("string is: "+a3[0]+"% formal language.");//Delete before submit
	    System.out.println("string is: "+a3[1]+"% informal language.");//Delete before submit
	}
}
