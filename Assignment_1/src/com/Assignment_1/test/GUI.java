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
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener
{
	//Attributes
	private JFileChooser chooser;
	private JButton button1;
	private JTextField field1;
	public String sentence;
	FileNameExtensionFilter filter;
	File selectedFile;
	
	//Constructor
	public GUI(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		chooser = new JFileChooser();
		button1 = new JButton("Enter");
		field1 = new JTextField(100);
		field1 = new JTextField();
		field1.setColumns(15);
		chooser.setFileFilter(filter);
		filter = new FileNameExtensionFilter("txt","*.txt");
		
		//Create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		//Adding the panels
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		
		//Adding attributes to the panel
		panel1.add(chooser);
		panel1.add(field1);
		panel2.add(button1);
		//panel1.add(filter);
		
		//Set screen size
		setSize(900,600);
		
		//Makes the screen visible/
		setVisible(true);
		
		//Set the location of the screen
		setLocation(100,100);
		
		//Link the listener to the button you want to monitor
		button1.addActionListener(this);
		chooser.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			//field1.getText();
			sentence = field1.getText();
			System.out.println(sentence);
			Passer(sentence);
		}
		/*
		File selectedFile = chooser.getSelectedFile();
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	
	    	//System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
	    	System.out.println("Selected file: " + chooser.getSelectedFile().getAbsolutePath());
	    	Passer2(selectedFile);
	    }*/
	}
	
	public static void Passer(String sentence)
	{
		System.out.println(sentence.toLowerCase());
		SentenceReader s1 = new SentenceReader();
		s1.addSentence(sentence);
		//SentenceReader.addSentence(sentence);
		//System.out.println(sentence);
		//SentenceReader reader = new SentenceReader();
		//reader.addSentence(sentence);
		//return sentence;
	}
	
	public static void Passer2(File selectedFile)
	{
		FileReader f1 = new FileReader();
		f1.addFile(selectedFile);
	}
}