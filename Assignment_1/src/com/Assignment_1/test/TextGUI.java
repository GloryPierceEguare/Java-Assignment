package com.Assignment_1.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextGUI extends JFrame implements ActionListener
{
	//Attributes
	private JTextField field1;
	private JTextArea area1; 
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private String sentence;
	private DecimalFormat twodec = new DecimalFormat("#.00");
	private DecimalFormat zerodec = new DecimalFormat("#");
	private static float a3[] = new float[5];
	int check = 0;
	
	public TextGUI()
	{
		super();//Delete before submit?
		setLayout(new BorderLayout());
		
		field1 = new JTextField(100);
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
		
		//Add attributes to panels
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
		JOptionPane.showMessageDialog(this,"Instructions:\n1. Enter text in the provided text box.\n2. Press 'Enter' to enter this text.\n3. Press 'Show Results' to display the outcome.");
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
				setSentence(field1.getText());
				System.out.println(getSentence());//Delete before submit
				Passer(getSentence());
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
				System.out.println("string is: "+getA3()[0]+"% formal language.");//Delete before submit
			    System.out.println("string is: "+getA3()[1]+"% informal language.");//Delete before submit
				area1.setText(null);
				area1.append("This text is: "+getTwodec().format(getA3()[0])+"% formal language.\nThis text is: "+getTwodec().format(getA3()[1])+"% informal language.");
				area1.append("\n\nSpelling Errors: "+getZerodec().format(getA3()[2])+"\nPunctuation Errors: "+getZerodec().format(getA3()[3])+"\nSentence Structure Errors: "+getZerodec().format(getA3()[4]));
			}
		}
	}
	
	public static void Passer(String sentence)
	{
		System.out.println(sentence.toLowerCase());//Delete before submit
		TextRead s1 = new TextRead();
		s1.addSentence(sentence);
	}
	
	public static void results(float[] a2)
	{
		System.out.println("This string is: "+a2[0]+"% formal language.");//Delete before submit
	    System.out.println("This string is: "+a2[1]+"% informal language.");//Delete before submit
	    System.out.println("--------------------------------");//Delete before submit
	    
	    
	    for(int i=0;i<a2.length;++i)
	    {
			getA3()[i]=a2[i];
		}
	    System.out.println("string is: "+getA3()[0]+"% formal language.");//Delete before submit
	    System.out.println("string is: "+getA3()[1]+"% informal language.");//Delete before submit
	}

	//Getter & Setter: Sentence
	public String getSentence() 
	{
		return sentence;
	}
	public void setSentence(String sentence) 
	{
		this.sentence = sentence;
	}

	//Getter & Setter: Twodec
	public DecimalFormat getTwodec() 
	{
		return twodec;
	}
	public void setTwodec(DecimalFormat twodec) 
	{
		this.twodec = twodec;
	}

	//Getter & Setter: Zerodec
	public DecimalFormat getZerodec() 
	{
		return zerodec;
	}
	public void setZerodec(DecimalFormat zerodec) 
	{
		this.zerodec = zerodec;
	}

	//Getter & Setter: a3[]
	public static float[] getA3() 
	{
		return a3;
	}
	public static void setA3(float a3[]) 
	{
		TextGUI.a3 = a3;
	}
}
