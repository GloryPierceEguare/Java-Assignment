package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener
{
	//Attributes
	//private JFileChooser chooser;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextField field1;
	private JLabel label1;
	//private JLabel label2;
	//public String sentence;
	//FileNameExtensionFilter filter;
	//File selectedFile;
	
	//Constructor
	public GUI(/*String title*/)
	{
		super(/*title*/);
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		
		//chooser = new JFileChooser();
		button1 = new JButton("Choose File");
		button2 = new JButton("Enter Text");
		button3 = new JButton("EXIT");
		label1 =  new JLabel("<html><br>Welcome to the Language Analyser!<br>This program can analyse a string of text of a file based on a few factors.<br>These factors are:<br>1. Sentence Length<br>2. Correct punctuation<br>3. Correct Grammar</html>");
		//label2 = new JLabel("<html><br><br><br>1. Sentence Length</html>");
		
		//field1 = new JTextField(100);
		//field1 = new JTextField();
		//field1.setColumns(15);
		//chooser.setFileFilter(filter);
		//filter = new FileNameExtensionFilter("txt","*.txt",".doc",".docx");
		
		//Set font size of buttons and label
		button1.setFont (button1.getFont ().deriveFont (14.0f));
		button2.setFont (button2.getFont ().deriveFont (14.0f));
		label1.setFont (label1.getFont ().deriveFont (19.0f));
		
		//Set button sizes
		button1.setPreferredSize(new Dimension(120, 40));
		button2.setPreferredSize(new Dimension(130, 40));
		
		//Create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		//Adding the panels
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
		
		//Adding attributes to the panel
		//panel1.add(chooser);
		//panel1.add(field1);
		panel1.add(button1);
		panel1.add(button2);
		panel3.add(button3);
		panel2.add(label1);
		//panel2.add(label2);
		//panel1.add(filter);
		
		//Set screen size
		setSize(900,600);
		
		//Makes the screen visible
		setVisible(true);
		
		//Set the location of the screen
		setLocation(100,100);
		
		//Set the colour of the screen
		setBackground(Color.blue);
		
		//Link the listener to the button you want to monitor
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		//chooser.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent event) 
	{
		/*
		field1 = new JTextField(100);
		//field1 = new JTextField();
		field1.setColumns(15);
		JPanel panel3 = new JPanel();
		add(panel3, BorderLayout.CENTER);*/
		
		if(event.getSource() == button1)
		{
			this.dispose();
			GUI3 gui3 = new GUI3();
			gui3.setVisible(true);
			
			/*
			panel3.add(chooser);
			
			File selectedFile = chooser.getSelectedFile();
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	
		    	//System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
		    	System.out.println("Selected file: " + chooser.getSelectedFile().getAbsolutePath());
		    	Passer2(selectedFile);
		    }*/
		}
		
		if(event.getSource() == button2)
		{
			this.dispose();
			GUI2 gui2 = new GUI2();
			gui2.setVisible(true);
			/*
			//field1.getText();
			panel3.add(field1);
			panel3.add(button3);
			
			
			
			if(event.getSource() == button3)
			{
				sentence = field1.getText();
				System.out.println(sentence);
				Passer(sentence);
			}*/
		}
		
		if(event.getSource() == button3)
		{
			System.exit(0);
		}
	}
	
	/*
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
	}*/
}