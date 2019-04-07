package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI2 extends JFrame implements ActionListener
{
	//Attributes
	private JTextField field1;
	private JTextArea area1; 
	private JButton button1;
	private JButton button2;
	public String sentence;
	
	public GUI2()
	{
		super();
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		
		field1 = new JTextField(100);
		area1 = new JTextArea();
		button1 = new JButton("ENTER");
		button2 = new JButton("HOME");
		
		//Set size of text field and text area
		field1.setColumns(30);
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
		
		panel1.add(field1);
		panel1.add(button1);
		panel2.add(button2);
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
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			sentence = field1.getText();
			System.out.println(sentence);
			Passer(sentence);
		}
		
		if(event.getSource() == button2)
		{
			this.dispose();
			GUI gui = new GUI();
			gui.setVisible(true);
		}
	}
	
	public static void Passer(String sentence)
	{
		System.out.println(sentence.toLowerCase());
		SentenceReader s1 = new SentenceReader();
		s1.addSentence(sentence);
	}

}
