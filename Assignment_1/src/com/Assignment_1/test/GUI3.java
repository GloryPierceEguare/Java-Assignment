package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI3 extends JFrame implements ActionListener
{
	//Attributes
	private JFileChooser chooser;
	FileNameExtensionFilter filter;
	File selectedFile;
	private JButton button5;

	public GUI3()
	{
		super();
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		chooser = new JFileChooser();
		//chooser.setFileFilter(filter);
		filter = new FileNameExtensionFilter("txt","*.txt",".doc",".docx");
		chooser.setFileFilter(filter);
		button5 = new JButton("HOME");
		
		//Create panels
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		//Add panels
		add(panel5, BorderLayout.NORTH);
		add(panel6, BorderLayout.SOUTH);
		
		
		panel5.add(chooser);
		panel6.add(button5);

		//Set screen size
		setSize(900,600);
		
		//Makes the screen visible
		setVisible(true);
		
		//Set the location of the screen
		setLocation(100,100);
		
		//Link the listener to the button you want to monitor
		button5.addActionListener(this);
		//chooser.addActionListener(this);
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.setFileFilter(filter);
		
		//int returnVal = chooser.showOpenDialog(null);
	    int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	File selectedFile = chooser.getSelectedFile();
	    	//System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
	    	System.out.println("Selected file: " + chooser.getSelectedFile().getAbsolutePath());
	    	Passer2(selectedFile);
	    }
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button5)
		{
			this.dispose();
			GUI gui = new GUI();
			gui.setVisible(true);
		}
		
	}
	
	public static void Passer2(File selectedFile)
	{
		FileRead f1 = new FileRead();
		f1.addFile(selectedFile);
	}
}
