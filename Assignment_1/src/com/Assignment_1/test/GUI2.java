package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI2 extends JFrame implements ActionListener
{
	//Attributes
	private JTextField field1;
	private JButton button3;
	public String sentence;
	
	public GUI2()
	{
		super();
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		
		field1 = new JTextField(100);
		//field1 = new JTextField();
		field1.setColumns(15);
		button3 = new JButton("ENTER");
		
		JPanel panel3 = new JPanel();
		add(panel3, BorderLayout.CENTER);
		
		panel3.add(field1);
		panel3.add(button3);
		
		//Set screen size
		setSize(900,600);
		
		//Makes the screen visible
		setVisible(true);
		
		//Set the location of the screen
		setLocation(100,100);
		
		//Link the listener to the button you want to monitor
		button3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button3)
		{
			sentence = field1.getText();
			System.out.println(sentence);
			Passer(sentence);
		}
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

}
