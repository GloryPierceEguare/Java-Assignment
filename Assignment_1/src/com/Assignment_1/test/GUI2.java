package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	static float a3[] = new float[5];
	int check = 0;
	
	public GUI2()
	{
		super();//Delete before submit?
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		
		field1 = new JTextField("Enter text here...",100);
		area1 = new JTextArea();
		button1 = new JButton("ENTER");
		button2 = new JButton("BACK");
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
		
		//Show help message
		JOptionPane.showMessageDialog(this,"Here you can enter in text and check it percentage.");
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			if(field1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"There is no text in the text box!!!");
			}
			else
			{
				check = 1;
				sentence = field1.getText();
				System.out.println(sentence);//Delete before submit
				Passer(sentence);
			}
		}
		
		if(event.getSource() == button2)
		{
			check = 0;
			this.dispose();
			GUI gui = new GUI();
			gui.setVisible(true);
		}
		
		if(event.getSource() == button3)
		{
			if(check == 0)
			{
				JOptionPane.showMessageDialog(this,"You have not entered any text yet!!!");
			}
			else
			{
				System.out.println("string is: "+a3[0]+"% formal language.");//Delete before submit
			    System.out.println("string is: "+a3[1]+"% informal language.");//Delete before submit
				area1.setText(null);
				area1.append("This text is: "+a3[0]+"% formal language.\nThis text is: "+a3[1]+"% informal language.");
				area1.append("\nSpelling Errors: "+a3[2]+"\nPunctuation Errors: "+a3[3]+"\nSentence Structure Errors: "+a3[4]);
			}
		}
	}
	
	public static void Passer(String sentence)
	{
		System.out.println(sentence.toLowerCase());//Delete before submit
		SentenceReader s1 = new SentenceReader();
		s1.addSentence(sentence);
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
