package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener
{
	//Attributes
	//private JFileChooser chooser;
	private JButton button1;
	private JTextField field1;
	public String sentence;
	//FileNameExtensionFilter filter;
	
	//Constructor
	public GUI(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		//chooser = new JFileChooser();
		button1 = new JButton("Enter");
		field1 = new JTextField(100);
		field1 = new JTextField();
		field1.setColumns(15);
		//filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		
		//Create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		//Adding the panels
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.SOUTH);
		
		//Adding attributes to the panel
		//panel1.add(chooser);
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
	}
		
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			//field1.getText();
			sentence = field1.getText();
			System.out.println(sentence);
			Passer(sentence);
			
			/*
			chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		       System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
		    }*/
		}
	}
	
	public static void Passer(String sentence)
	{
		SentenceReader.addSentence(sentence);
		System.out.println(sentence);
		//SentenceReader reader = new SentenceReader();
		//reader.addSentence(sentence);
		//return sentence;
	}
}