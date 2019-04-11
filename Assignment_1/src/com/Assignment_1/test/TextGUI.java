/*******************************************
 * TextGUI: the purpose of this class is to display the text-reading GUI to the user.
 * In the TextGUI class the user can enter in a string whether it be a sentence or a paragraph
 * and it is then sent to be analysed.
 * Author: Glory Pierce Eguare
 * OS: WIndows
 */

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
	private int check = 0;
	
	public TextGUI()
	{
		//Set layout to BorderLayout
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
				area1.setText(null);
				area1.append("This text is: "+twodec.format(a3[0])+"% formal language.\nThis text is: "+twodec.format(a3[1])+"% informal language.");
				area1.append("\n\nSpelling Errors: "+zerodec.format(a3[2])+"\nPunctuation Errors: "+zerodec.format(a3[3])+"\nSentence Structure Errors: "+zerodec.format(a3[4]));
			}
		}
	}
	
	public static void Passer(String sentence)
	{
		TextRead s1 = new TextRead();
		s1.addSentence(sentence);
	}
	
	public static void results(float[] a2)
	{
	    for(int i=0;i<a2.length;++i)
	    {
			a3[i]=a2[i];
		}
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
}
