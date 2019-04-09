package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI3 extends JFrame implements ActionListener
{
	//Attributes
	private JFileChooser chooser;
	FileNameExtensionFilter filter;
	File selectedFile;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextArea area1;
	static float a3[] = new float[5];

	public GUI3()
	{
		super();
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		
		//chooser = new JFileChooser();
		//filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
		//chooser.addChoosableFileFilter(filter);
		//chooser.setFileFilter(filter);
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
		panel1.add(button2);
		panel1.add(button3);
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
		//chooser.addActionListener(this);
		
		//JFileChooser chooser = new JFileChooser();
		
		//chooser.setFileFilter(filter);
		
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
			/*if(check == 0)
			{
				JOptionPane.showMessageDialog(this,"You have not entered any text yet!!!");
			}
			else*/
			
			{
				System.out.println("string is: "+a3[0]+"% formal language.");//Delete before submit
			    System.out.println("string is: "+a3[1]+"% informal language.");//Delete before submit
				area1.setText(null);
				area1.append("This string is: "+a3[0]+"% formal language.\nThis string is: "+a3[1]+"% informal language.");
				area1.append("\nSpelling Errors: "+a3[2]+"\nPunctuation Errors: "+a3[3]+"\nSentence Structure Errors: "+a3[4]);
			}
		}
		
		if(event.getSource() == button3)
		{
			chooser = new JFileChooser();
			filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
			//chooser.addChoosableFileFilter(filter);
			chooser.setFileFilter(filter);
			
			//int returnVal = chooser.showOpenDialog(null);
		    int returnVal = chooser.showOpenDialog(this);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	File selectedFile = chooser.getSelectedFile();
		    	//System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
		    	System.out.println("Selected file: " + chooser.getSelectedFile().getAbsolutePath());//Delete before submit
		    	Passer2(selectedFile);
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
	    
	    //a3[0] = a2[0];
	    //a3[1] = a2[1];
	}
}
