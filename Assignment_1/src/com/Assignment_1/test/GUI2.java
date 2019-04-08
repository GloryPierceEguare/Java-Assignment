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
	private JButton button3;
	public String sentence;
	float a3[] = new float[2];
	
	public GUI2()
	{
		super();
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		
		field1 = new JTextField(100);
		area1 = new JTextArea();
		button1 = new JButton("ENTER");
		button2 = new JButton("HOME");
		button3 = new JButton("SHOW RESULTS");
		
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
		panel1.add(button3);
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
		button3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			area1.append("This string is: % formal language.");
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
		
		if(event.getSource() == button3)
		{
			//float name[] = results();
			System.out.println("string is: "+a3[0]+"% formal language.");
		    System.out.println("string is: "+a3[1]+"% informal language.");
			
			area1.append("This string is: "+a3[0]+"% formal language.\n");
			area1.append("This string is: "+a3[1]+"% formal language.");
		}
	}
	
	public static void Passer(String sentence)
	{
		System.out.println(sentence.toLowerCase());
		SentenceReader s1 = new SentenceReader();
		s1.addSentence(sentence);
	}
	
	public void results(float[] a2)
	{
		System.out.println("This string is: "+a2[0]+"% formal language.");
	    System.out.println("This string is: "+a2[1]+"% informal language.");
	    System.out.println("--------------------------------");
	    
	    
	    for(int i=0;i<a2.length;++i)
	    {
			a3[i]=a2[i];
		}
	    System.out.println("string is: "+a3[0]+"% formal language.");
	    System.out.println("string is: "+a3[1]+"% informal language.");
	    
	    //a3[0] = a2[0];
	    //a3[1] = a2[1];
	}
}
